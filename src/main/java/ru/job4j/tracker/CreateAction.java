package ru.job4j.tracker;

import java.sql.SQLException;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Store store) throws SQLException {
        out.println("===Create a new item===");
        Item item = new Item(input.askStr("Enter name:"));
        store.add(item);
        out.println(item);
        return true;
    }
}
