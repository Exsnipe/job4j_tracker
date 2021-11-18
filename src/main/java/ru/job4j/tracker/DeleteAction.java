package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        boolean deleted =  tracker.delete(input.askInt("press "
                + "id of item you want to delete: "));
        if (deleted) {
            System.out.println("succed");
        } else {
            System.out.println("There are no items with such id!");
        }
        return true;
    }
}
