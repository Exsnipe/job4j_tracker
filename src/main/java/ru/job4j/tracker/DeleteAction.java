package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ===");
        boolean deleted =  tracker.delete(input.askInt("press "
                + "id of item you want to delete: "));
        if (deleted) {
            out.println("succed");
        } else {
            out.println("There are no items with such id!");
        }
        return true;
    }
}
