package ru.job4j.tracker;

import java.util.Scanner;

public class StartUi {

    public void init(Input input, Tracker tracker, UserAction[] action) {
        boolean run = true;
        while (run) {
            showMenu(action);
            int select = input.askInt("select: ");
            run = action[select].execute(input, tracker);
        }
    }

    public void showMenu(UserAction[] action) {
        System.out.println("Menu:");
        for (int i = 0; i < action.length; i++) {
            System.out.println(i + ". " + action[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] action = {new CreateAction(), new ShowAction(), new EditAction(),
        new DeleteAction(), new FindByIdAction(), new FindByNameAction(), new ExitAction()};
        new StartUi().init(input, tracker, action);
    }
}
