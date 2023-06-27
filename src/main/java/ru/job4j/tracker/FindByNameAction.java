package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Find items by name ===");
        List<Item> items = store.findByName(input.askStr("press "
                + "name of item you want to find"));
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("There are no items with such ");
        }
        return true;
    }
}
