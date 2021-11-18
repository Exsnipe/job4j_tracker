package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ===");
        Item finded = tracker.findById(input.askInt("press "
                + "id of item you want to find"));
        if (finded != null) {
            System.out.println("your item is: ");
            System.out.println(finded);
        } else {
            System.out.println("There are no items with such id!");
        }
        return true;
    }
}
