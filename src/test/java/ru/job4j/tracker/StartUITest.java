package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Tracker tracker = new Tracker();
        String[]  answers = {"0", "new item in whenCreate test", "1"};
        Input stubInp = new StubInput(answers);
        Output out = new ConsoleOutput();
        UserAction[] actions = {new CreateAction(out), new ExitAction()};
        new StartUI(out).init(stubInp, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("new item in whenCreate test"));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item item = new Item("first item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "edited item", "1"};
        Input stubInp = new StubInput(answers);
        Output out = new ConsoleOutput();
        UserAction[] actions = {new EditAction(out), new ExitAction()};
        new StartUI(out).init(stubInp, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("edited item"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("Deleted item");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input stubInp = new StubInput(answers);
        Output out = new ConsoleOutput();
        UserAction[] actions = {new DeleteAction(out),  new ExitAction()};
        new StartUI(out).init(stubInp, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Tracker tracker = new Tracker();
        String[] answers = {"0"};
        Input input = new StubInput(answers);
        Output out = new StubOutput();
        UserAction[] actions = {new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
               + "0. Exit" + System.lineSeparator()));
    }
}