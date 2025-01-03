package ru.job4j.tracker.input;

import ru.job4j.tracker.input.Input;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answer) {
        this.answers = answer;
    }

    public String askStr(String question) {
        return answers[position++];
    }

    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
