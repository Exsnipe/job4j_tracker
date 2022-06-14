package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {
    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public void init() {
        try (InputStream in  = SqlTracker.class
                .getClassLoader().getResourceAsStream("app.properties")) {
            Properties config =  new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception es) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                cn.prepareStatement("insert into items (name, created) values (?,?)",
                        Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet set = statement.getGeneratedKeys()) {
                if (set.next()) {
                    item.setId(set.getInt(1));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean executed = false;
        try (PreparedStatement statement = cn.prepareStatement(
                "update items set name = ?, created = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            executed = statement.executeUpdate() > 0;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return executed;
    }

    @Override
    public boolean delete(int id) {
        boolean executed = false;
        try (PreparedStatement statement = cn.prepareStatement(
                "delete from items where id = ?")) {
            statement.setInt(1, id);
            executed = statement.executeUpdate() > 0;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return executed;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (Statement statement = cn.createStatement()) {
            String sql = "select * from items";
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                result.add(getItemFromSet(set));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        Item curItem = new Item();
        try (PreparedStatement statement = cn.prepareStatement(
                "select * from items where name = ?")) {
            statement.setString(1, key);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
               result.add(getItemFromSet(set));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement = cn.prepareStatement(
                "select * from items where id = ?")) {
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                item = getItemFromSet(set);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return item;
    }

    private Item getItemFromSet(ResultSet set) {
        Item item = new Item();
        try  {
            item.setId(set.getInt("id"));
            item.setName(set.getString("name"));
            item.setCreated(set.getTimestamp("created").toLocalDateTime());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return item;
    }
}
