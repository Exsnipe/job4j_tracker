package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Edit item ==");
        int currentId = input.askInt("press id of item you want to replace:");
        Item item = new Item(input.askStr("press name of new item: "));
        if (store.replace(currentId, item)) {
            out.println("suссed");
        } else {
            out.println("There are no items with such id!");
        }
        return true;
    }
}
