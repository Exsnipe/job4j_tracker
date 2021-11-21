package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] action) {
        boolean run = true;
        while (run) {
            showMenu(action);
            int select = input.askInt("select:");
            run = action[select].execute(input, tracker);
        }
    }

    public void showMenu(UserAction[] action) {
        out.println("Menu.");
        for (int i = 0; i < action.length; i++) {
            out.println(i + ". " + action[i].name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] action = {new CreateAction(out), new ShowAction(out), new EditAction(out),
        new DeleteAction(out), new FindByIdAction(out), new FindByNameAction(out),
        new ExitAction()};
        new StartUI(out).init(input, tracker, action);
    }
}
