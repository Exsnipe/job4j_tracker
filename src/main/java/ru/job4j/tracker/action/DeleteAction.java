package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Delete item ===");
        boolean deleted =  memTracker.delete(input.askInt("press "
                + "id of item you want to delete:"));
        if (deleted) {
            out.println("succed");
        } else {
            out.println("There are no items with such id!");
        }
        return true;
    }
}
