package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Stud> input = new ArrayList<>();
        input.add(new Stud("Masha", 28));
        input.add(new Stud("Pety", 128));
        List<Stud> expected = List.of(
                new Stud("Pety", 128),
                new Stud("Masha", 28)
        );
        assertThat(StudentLevel.levelOf(input, 20), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Stud> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Stud> input = new ArrayList<>();
        input.add(null);
        input.add(new Stud("Pety", 28));
        List<Stud> expected = List.of(new Stud("Pety", 28));
        assertThat(StudentLevel.levelOf(input, 10), is(expected));
    }
}