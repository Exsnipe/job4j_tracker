package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String askStr(String question) {
        System.out.println(question + " ");
        return scanner.nextLine();
    }

    public int askInt(String question) {
        System.out.println(question);
        return Integer.parseInt(scanner.nextLine());
    }
}
