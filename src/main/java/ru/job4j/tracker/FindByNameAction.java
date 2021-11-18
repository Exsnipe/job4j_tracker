package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        Item[] items = tracker.findByName(input.askStr("press "
                + "name of item you want to find"));
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("There are no items with such ");
        }
        return true;
    }
}
