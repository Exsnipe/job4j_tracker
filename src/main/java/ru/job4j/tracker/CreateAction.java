package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("===Create a new item===");
        Item item = new Item(input.askStr("Enter name of new item"));
        tracker.add(item);
        System.out.println(item);
        return true;
    }
}
