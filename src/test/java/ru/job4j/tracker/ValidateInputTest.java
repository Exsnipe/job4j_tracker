package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        String[] answers = {"one", "1"};
        Input in = new StubInput(answers);
        Input input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMiltiValidInput() {
        Output out = new StubOutput();
        String[] answers = {"0", "1", "2", "3"};
        Input in = new StubInput(answers);
        Input input = new ValidateInput(out, in);
        int[] selected = new int[answers.length];
        selected[0] = input.askInt("");
        selected[1] = input.askInt("");
        selected[2] = input.askInt("");
        selected[3] = input.askInt("");
        int[] expected = {0, 1, 2, 3};
        assertArrayEquals(expected, selected);
    }

    @Test
    public void whenMinusInput() {
        Output out = new StubOutput();
        String[] answers = {"-1"};
        Input in = new StubInput(answers);
        Input input = new ValidateInput(out, in);
        assertEquals(-1, input.askInt(""));
    }
}