package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartMemUI {
    private final Output out;

    public StartMemUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store store, List<UserAction> action) {
        boolean run = true;
        while (run) {
            showMenu(action);
            int select = input.askInt("select:");
            if (select < 0 || select > action.size() - 1) {
                out.println("Wrong input. You can select 0 .. " + (action.size() - 1));
                continue;
            }
            run = action.get(select).execute(input, store);
        }
    }

    public void showMenu(List<UserAction> action) {
        out.println("Menu.");
        for (int i = 0; i < action.size(); i++) {
            out.println(i + ". " + action.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input consoleInput = new ConsoleInput();
        Input input = new ValidateInput(out, consoleInput);
        MemTracker tracker = new MemTracker();
            List<UserAction> action = new ArrayList<>(Arrays.asList(new CreateAction(out),
                    new ShowAction(out), new EditAction(out), new DeleteAction(out),
                    new FindByIdAction(out), new FindByNameAction(out), new CreateManyItems(out),
                    new DeleteAllItems(out), new ExitAction()));
            new StartMemUI(out).init(input, tracker, action);
    }
}
