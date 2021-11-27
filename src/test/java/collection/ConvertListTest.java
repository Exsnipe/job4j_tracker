package collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ConvertListTest {

    @Test
    public void whenConvert() {
        List<int[]> list = new ArrayList<>();
        int[] first = {5, 8, 1, 0};
        int[] second = {5};
        int[] third = {6, 3, 9, 1};
        list.add(first);
        list.add(second);
        list.add(third);
        List<Integer> expected = new ArrayList<>(Arrays.asList(5, 8, 1, 0, 5, 6, 3, 9, 1));
        assertThat(expected, is(ConvertList.convert(list)));
    }

    @Test
    public void whenTwoList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {1});
        in.add(new int[] {2, 3});
        List<Integer> expect = Arrays.asList(1, 2, 3);
        assertThat(ConvertList.convert(in), is(expect));
    }
}