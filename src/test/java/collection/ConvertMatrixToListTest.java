package collection;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrixToListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrixToList list = new ConvertMatrixToList();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when3on3ToList() {
        ConvertMatrixToList list = new ConvertMatrixToList();
        int[][] array = {
                {4, 8, 1},
                {7, 2, 0},
                {6, 2, 8}
        };
        List<Integer> expected = Arrays.asList(4, 8, 1, 7, 2, 0, 6, 2, 8);
        assertThat(expected, is(list.toList(array)));
    }
}