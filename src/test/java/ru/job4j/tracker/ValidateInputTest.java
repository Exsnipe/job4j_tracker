package ru.job4j.tracker;

import org.junit.Test;

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
        for (int index = 0; index < selected.length; index++) {
           selected[index] = input.askInt("");
        }
        int[] expected = {0, 1, 2, 3};
        assertArrayEquals(expected, selected);
    }
}