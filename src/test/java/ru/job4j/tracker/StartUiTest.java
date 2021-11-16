package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUiTest {

    @Test
    public void addNewItem() {
        String[] answers = {"Fix PC"};
        Input stbInput = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUi.addNewItem(stbInput, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
}