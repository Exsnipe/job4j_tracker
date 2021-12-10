package lambda;

import org.junit.Test;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class DiapasonFunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = DiapasonFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunction() {
        List<Double> rsl = DiapasonFunction.diapason(4, 8, (x) -> 4 * Math.pow(x, 2) - 6 * x + 2);
        List<Double> expected = Arrays.asList(42D, 72D, 110D, 156D);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenIndicateFunction() {
        List<Double> rsl = DiapasonFunction.diapason(2, 6, (x) -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D, 32D);
        assertThat(rsl, is(expected));
    }
}