package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Show all items ===");
        List<Item> allFiles = store.findAll();
        if (allFiles.size() > 0) {
            for (Item item : allFiles) {
                out.println(item);
            }
        } else {
            out.println("There are no items in storage");
        }
        return true;
    }
}
