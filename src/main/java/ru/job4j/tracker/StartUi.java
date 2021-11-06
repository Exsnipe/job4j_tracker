package ru.job4j.tracker;

import java.util.Scanner;

public class StartUi {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.print("Enter name of new Item: ");
                Item item = new Item(scanner.nextLine());
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
                System.out.print("press id of item you want to replace: ");
                int currentId = Integer.parseInt(scanner.nextLine());
                System.out.print("press name of new item: ");
                Item item = new Item(scanner.nextLine());
                if (tracker.replace(currentId, item)) {
                    System.out.println("suссed");
                } else {
                    System.out.println("There are no items with such id!");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.print("press id of item you want to delete: ");
                boolean deleted =  tracker.delete(Integer.parseInt(scanner.nextLine()));
                if (deleted) {
                    System.out.println("succed");
                } else {
                    System.out.println("There are no items with such id!");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                System.out.println("press id of item you want to find");
                Item finded = tracker.findById(Integer.parseInt(scanner.nextLine()));
                if (finded != null) {
                    System.out.println("your item is: ");
                    System.out.println(finded);
                } else {
                    System.out.println("There are no items with such id!");
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUi().init(scanner, tracker);
    }
}
