package ru.job4j.tracker.input;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        int value = -1;
        boolean invalid = true;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Please enter valid data again.");
            }
        } while (invalid);
        return value;
    }
}
