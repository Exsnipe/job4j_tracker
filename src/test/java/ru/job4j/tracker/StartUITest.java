package ru.job4j.tracker;

import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {
    @Test
    public void whenCreateItem() throws SQLException {
        MemTracker memTracker = new MemTracker();
        String[]  answers = {"0", "new item in whenCreate test", "1"};
        Input stubInp = new StubInput(answers);
        Output out = new ConsoleOutput();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new CreateAction(out),
                new ExitAction()));
        new StartUI(out).init(stubInp, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("new item in whenCreate test"));
    }

    @Test
    public void whenReplace() throws SQLException {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("first item");
        memTracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "edited item", "1"};
        Input stubInp = new StubInput(answers);
        Output out = new ConsoleOutput();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new EditAction(out),
                new ExitAction()));
        new StartUI(out).init(stubInp, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("edited item"));
    }

    @Test
    public void whenDelete() throws SQLException {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Deleted item");
        memTracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input stubInp = new StubInput(answers);
        Output out = new ConsoleOutput();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new DeleteAction(out),
                new ExitAction()));
        new StartUI(out).init(stubInp, memTracker, actions);
        assertNull(memTracker.findById(item.getId()));
    }

    @Test
    public void whenExit() throws SQLException {
        MemTracker memTracker = new MemTracker();
        String[] answers = {"0"};
        Input input = new StubInput(answers);
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new ExitAction()));
        new StartUI(out).init(input, memTracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
               + "0. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessful() throws SQLException {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("First");
        memTracker.add(item);
        Output out = new StubOutput();
        List<UserAction> action = new ArrayList<>(Arrays.asList(new EditAction(out),
                new ExitAction()));
        String[] answers = {"0", "1", "item after item", "1"};
        Input input = new StubInput(answers);
        new StartUI(out).init(input, memTracker, action);
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
    public void whenFindAllItemsOutputIsSuccessful() throws SQLException {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        Item item1 = new Item("test2");
        memTracker.add(item1);
        String[] answers = {"0", "1"};
        Input input = new StubInput(answers);
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new ShowAction(out),
                new ExitAction()));
        new StartUI(out).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Show all items" + ln
                + "1. Exit" + ln + "=== Show all items ===" + ln
                + item + ln + item1 + ln
                + "Menu." + ln + "0. Show all items" + ln
                + "1. Exit" + ln));
    }

    @Test
    public void whenFindByNameOutputIsSuccessful() throws SQLException {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test");
        memTracker.add(item);
        String[] answers = {"0", "test", "1"};
        Input input = new StubInput(answers);
        Output out = new StubOutput();
        List<UserAction> action = new ArrayList<>(Arrays.asList(new FindByNameAction(out),
                new ExitAction()));
        new StartUI(out).init(input, memTracker, action);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Find item by name" + ln
                + "1. Exit" + ln + "=== Find items by name ===" + ln
                + item + ln + "Menu." + ln
                + "0. Find item by name" + ln
                + "1. Exit" + ln));
    }

    @Test
    public  void whenFindItemByIdOutputIsSuccessful() throws SQLException {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test");
        memTracker.add(item);
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(new FindByIdAction(out),
                new ExitAction()));
        new StartUI(out).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Find item by id" + ln
                + "1. Exit" + ln + "=== Find item by id ===" + ln
                + "your item is: " + ln + item + ln + "Menu." + ln
                + "0. Find item by id" + ln
                + "1. Exit" + ln));
    }

    @Test
    public void whenInvalidExit() throws SQLException {
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(new ExitAction());
        String[] answers = {"1", "0"};
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        new StartUI(output).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("Menu." + ln
            + "0. Exit" + ln + "Wrong input. You can select 0 .. " + (actions.size() - 1) + ln
            + "Menu." + ln + "0. Exit" + ln));
    }
}