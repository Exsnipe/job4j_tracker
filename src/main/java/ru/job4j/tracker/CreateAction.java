package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        out.println("===Create a new item===");
        Item item = new Item(input.askStr("Enter name:"));
        tracker.add(item);
        out.println(item);
        return true;
    }
}
