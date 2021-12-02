package collection;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.ItemAscByName;
import ru.job4j.tracker.ItemDescByName;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortItemsTest {
    @Test
    public void whenAscSort() {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item("Beta"),
                new Item("Gamma"),
                new Item("Alpha")

        ));
        List<Item> expected = new ArrayList<>(Arrays.asList(
                new Item("Alpha"),
                new Item("Beta"),
                new Item("Gamma")
        ));
        Collections.sort(items, new ItemAscByName());
        assertThat(expected, is(items));
    }

    @Test
    public void whenDescSort() {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item("Beta"),
                new Item("Gamma"),
                new Item("Alpha")

        ));
        List<Item> expected = new ArrayList<>(Arrays.asList(
                new Item("Gamma"),
                new Item("Beta"),
                new Item("Alpha")
        ));
        Collections.sort(items, new ItemDescByName());
        assertThat(expected, is(items));
    }
}
