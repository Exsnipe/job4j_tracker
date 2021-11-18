package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ==");
        int currentId = input.askInt("press id of item you want to replace: ");
        Item item = new Item(input.askStr("press name of new item: "));
        if (tracker.replace(currentId, item)) {
            System.out.println("suссed");
        } else {
            System.out.println("There are no items with such id!");
        }
        return true;
    }
}
