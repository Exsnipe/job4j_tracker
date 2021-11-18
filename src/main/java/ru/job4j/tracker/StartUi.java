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

    public static void addNewItem(Input consoleInput, Tracker tracker) {
        Item item = new Item(consoleInput.askStr("Enter name of new Item: "));
        tracker.add(item);
        System.out.println("Item added " + item);
    }

    public static void showAllItem(Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] allFiles = tracker.findAll();
        if (allFiles.length > 0) {
            for (Item item : allFiles) {
                System.out.println(item);
            }
        } else {
            System.out.println("There are no items in storage");
        }
    }

    public static void editItem(Input consoleInput, Tracker tracker) {
        System.out.println("=== Edit item ==");
        int currentId = consoleInput.askInt("press id of item you want to replace: ");
        Item item = new Item(consoleInput.askStr("press name of new item: "));
        if (tracker.replace(currentId, item)) {
            System.out.println("suссed");
        } else {
            System.out.println("There are no items with such id!");
        }
    }

    public static void deleteItem(Input consoleInput, Tracker tracker) {
        System.out.println("=== Delete item ===");
        boolean deleted =  tracker.delete(consoleInput.askInt("press "
                + "id of item you want to delete: "));
        if (deleted) {
            System.out.println("succed");
        } else {
            System.out.println("There are no items with such id!");
        }
    }

    public static void findById(Input consoleInput, Tracker tracker) {
        System.out.println("=== Find item by id ===");
        Item finded = tracker.findById(consoleInput.askInt("press "
                + "id of item you want to find"));
        if (finded != null) {
            System.out.println("your item is: ");
            System.out.println(finded);
        } else {
            System.out.println("There are no items with such id!");
        }
    }

    public static void findByName(Input consoleInput, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        Item[] items = tracker.findByName(consoleInput.askStr("press "
                + "name of item you want to find"));
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("There are no items with such ");
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
