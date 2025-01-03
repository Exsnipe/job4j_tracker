package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.store.SqlTracker;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        tracker.add(item1);
        tracker.replace(item1.getId(), new Item("item2"));
        assertThat(tracker.findById(item1.getId()).getName()).isEqualTo("item2");
    }

    @Test
    public void whenDeleteItem() {
        SqlTracker sqlTracker = new SqlTracker(connection);
        Item item = new Item("item");
        sqlTracker.add(item);
        sqlTracker.delete(item.getId());
        assertThat(sqlTracker.findById(item.getId())).isEqualTo(null);
    }

    @Test
    public void whenFindAll() {
        SqlTracker sqlTracker = new SqlTracker(connection);
        sqlTracker.add(new Item("item1"));
        sqlTracker.add(new Item("item2"));
        assertThat(sqlTracker.findAll().size()).isEqualTo(2);
    }

    @Test
    public void whenFindByName() {
        SqlTracker sqlTracker = new SqlTracker(connection);
        sqlTracker.add(new Item("item1"));
        sqlTracker.add(new Item("item2"));
        sqlTracker.add(new Item("item1"));
        assertThat(sqlTracker.findByName("item1").size()).isEqualTo(2);
    }
}