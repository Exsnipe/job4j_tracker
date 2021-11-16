package ru.job4j.tracker;

import java.util.Scanner;

public class StartUi {

    public void init(ConsoleInput consoleInput, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = consoleInput.askInt("select: ");
            if (select == 0) {
                Item item = new Item(consoleInput.askStr("Enter name of new Item: "));
                tracker.add(item);
                System.out.println("Item added " + item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] allFiles = tracker.findAll();
                if (allFiles.length > 0) {
                    for (Item item : allFiles) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("There are no items in storage");
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ==");
                int currentId = consoleInput.askInt("press id of item you want to replace: ");
                Item item = new Item(consoleInput.askStr("press name of new item: "));
                if (tracker.replace(currentId, item)) {
                    System.out.println("suссed");
                } else {
                    System.out.println("There are no items with such id!");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                boolean deleted =  tracker.delete(consoleInput.askInt("press "
                        + "id of item you want to delete: "));
                if (deleted) {
                    System.out.println("succed");
                } else {
                    System.out.println("There are no items with such id!");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                Item finded = tracker.findById(consoleInput.askInt("press "
                        + "id of item you want to find"));
                if (finded != null) {
                    System.out.println("your item is: ");
                    System.out.println(finded);
                } else {
                    System.out.println("There are no items with such id!");
                }
            } else if (select == 5) {
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
            } else if (select == 6) {
                run = false;
            }
        }
    }

    public void showMenu() {
        String[] menuItems = {
            "Add new Item", "Show all items", "Edit item",
            "Delete item", "Find item by id", "Find items by name",
            "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(i + ". " + menuItems[i]);
        }
    }

    public static void main(String[] args) {
        ConsoleInput consoleInput = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUi().init(consoleInput, tracker);
    }
}
