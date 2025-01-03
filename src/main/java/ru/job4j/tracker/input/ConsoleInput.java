package ru.job4j.tracker.input;

import ru.job4j.tracker.input.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String askStr(String question) {
        System.out.print(question + " ");
        return scanner.nextLine();
    }

    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
