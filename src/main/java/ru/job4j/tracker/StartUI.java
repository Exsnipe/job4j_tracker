package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> action) {
        boolean run = true;
        while (run) {
            showMenu(action);
            int select = input.askInt("select:");
            if (select < 0 || select > action.size() - 1) {
                out.println("Wrong input. You can select 0 .. " + (action.size() - 1));
                continue;
            }
            run = action.get(select).execute(input, tracker);
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
        Tracker tracker = new Tracker();
        List<UserAction> action = new ArrayList<>(Arrays.asList(new CreateAction(out),
                new ShowAction(out), new EditAction(out), new DeleteAction(out),
                new FindByIdAction(out), new FindByNameAction(out), new ExitAction()));
        new StartUI(out).init(input, tracker, action);
    }
}
