package collection;

import org.junit.Test;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class UniqueTextTest {

    @Test
    public void whenEqual() {
        String original = "there are a lot of consequences in this case";
        String duplicate = "in this case there are a lot of consequences";
        Assert.assertTrue(UniqueText.isEquals(original, duplicate));
    }

    @Test
    public void whenNotEqual() {
        String original = "there are a lot of consequences in this case";
        String duplicate = "in this case there are a lo of consequences";
        Assert.assertFalse(UniqueText.isEquals(original, duplicate));
    }

    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse and milk";
        String text = "My cat eats milk and a mouse";
        Assert.assertThat(UniqueText.isEquals(origin, text), is(true));
    }

    @Test
    public void isNotEquals() {
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        Assert.assertThat(UniqueText.isEquals(origin, text), is(false));
    }
}