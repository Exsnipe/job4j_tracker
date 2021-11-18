package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUiTest {

    @Test
    public void whenAddNewItem() {
        String[] answers = {"Fix PC"};
        Input stbInput = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUi.addNewItem(stbInput, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenEdited() {
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "edited item"};
        StartUi.editItem(new StubInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName(), is("edited item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("New item");
        tracker.add(item);
        int curId = item.getId();
        String[] answers = {String.valueOf(curId)};
        StartUi.deleteItem(new StubInput(answers), tracker);
        Item nullPointer = null;
        assertNull(tracker.findById(curId));
    }
}