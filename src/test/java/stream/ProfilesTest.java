package stream;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {
    @Test
    public void whenCollect() {
        List<Profile> profiles = Arrays.asList(
            new Profile(new Address("Voronezh", "Shishkova", "61", "105")),
            new Profile(new Address("Samara", "Mira", "5", "1"))
        );
        List<Address> rsl = new Profiles().collect(profiles);
        List<Address> expected = Arrays.asList(
             new Address("Voronezh", "Shishkova", "61", "105"),
             new Address("Samara", "Mira", "5", "1")
        );
        assertThat(rsl, is(expected));
    }
}