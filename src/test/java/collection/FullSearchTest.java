package collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FullSearchTest {

    @Test
    public void whenExtractNumbers() {
        List<TaskH> tasks= new ArrayList<>(Arrays.asList(new TaskH("1", "first task"),
                new TaskH("2", "second task"), new TaskH("1", "first task")));
        Set<String> result = FullSearch.extractNumbers(tasks);
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(result, is(expected));
    }
}