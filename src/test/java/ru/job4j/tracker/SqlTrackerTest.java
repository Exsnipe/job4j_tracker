package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class
                .getClassLoader().getResourceAsStream("test.properties")) {
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

    @AfterClass
    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplaceItemAndCheckNewName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = new Item("item2");
        tracker.replace(item1.getId(), item2);
        assertThat(tracker.findById(item1.getId()).getName(), is(item2.getName()));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item());
        tracker.delete(item.getId());
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        assertThat(tracker.findAll(), is(List.of(item1, item2)));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findByName("item"), is(List.of(item)));
    }

    @Test
    public void whenFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId()), is(item));
    }
}