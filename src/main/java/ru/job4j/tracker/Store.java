package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public interface Store {
    Item add(Item item) throws SQLException;

    boolean replace(int id, Item item) throws SQLException;

    boolean delete(int id);

    List<Item> findAll();

    List<Item> findByName(String key) throws SQLException;

    Item findById(int id) throws SQLException;
}
