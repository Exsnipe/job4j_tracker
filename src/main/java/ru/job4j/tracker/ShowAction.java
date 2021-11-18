package ru.job4j.tracker;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] allFiles = tracker.findAll();
        if (allFiles.length > 0) {
            for (Item item : allFiles) {
                System.out.println(item);
            }
        } else {
            System.out.println("There are no items in storage");
        }
        return true;
    }
}
