package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by id ===");
        Item finded = tracker.findById(input.askInt("press "
                + "id of item you want to find:"));
        if (finded != null) {
            out.println("your item is: ");
            out.println(finded);
        } else {
            out.println("There are no items with such id!");
        }
        return true;
    }
}
