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

    @Test
    public void whenReplaceItemTestOutputIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("First");
        tracker.add(item);
        Output out = new StubOutput();
        UserAction[] action = {new EditAction(out), new ExitAction()};
        String[] answers = {"0", "1", "item after item", "1"};
        Input input = new StubInput(answers);
        new StartUI(out).init(input, tracker, action);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
        + "0. Edit item" + ln
        + "1. Exit" + ln
        + "=== Edit item ==" + ln
        + "suссed" + ln + "Menu." + ln
                + "0. Edit item" + ln
                + "1. Exit" + ln));
    }

    @Test
    public void whenFindAllItemsOutputIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item item1 = new Item("test2");
        tracker.add(item1);
        String[] answers = {"0", "1"};
        Input input = new StubInput(answers);
        Output out = new StubOutput();
        UserAction[] actions = {new ShowAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Show all items" + ln
                + "1. Exit" + ln + "=== Show all items ===" + ln
                + item + ln + item1 + ln
                + "Menu." + ln + "0. Show all items" + ln
                + "1. Exit" + ln));
    }

    @Test
    public void whenFindByNameOutputIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        tracker.add(item);
        String[] answers = {"0", "test", "1"};
        Input input = new StubInput(answers);
        Output out = new StubOutput();
        UserAction[] action = {new FindByNameAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, action);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Find item by name" + ln
                + "1. Exit" + ln + "=== Find items by name ===" + ln
                + item + ln + "Menu." + ln
                + "0. Find item by name" + ln
                + "1. Exit" + ln));
    }

    @Test
    public  void whenFindItemByIdOutputIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("test");
        tracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        Output out = new StubOutput();
        UserAction[] actions = {new FindByIdAction(out), new ExitAction()};
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Find item by id" + ln
                + "1. Exit" + ln + "=== Find item by id ===" + ln
                + "your item is: " + ln + item + ln + "Menu." + ln
                + "0. Find item by id" + ln
                + "1. Exit" + ln));
    }

    @Test
    public void whenInvalidExit() {
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction()};
        String[] answers = {"1", "0"};
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("Menu." + ln
            + "0. Exit" + ln + "Wrong input. You can select 0 .. " + (actions.length - 1) + ln
            + "Menu." + ln + "0. Exit" + ln));
    }
}