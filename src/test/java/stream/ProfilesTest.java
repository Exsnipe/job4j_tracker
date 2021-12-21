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
            new Profile(new Address("Voronezh", "Shishkova", 61, 105)),
            new Profile(new Address("Samara", "Mira", 5, 1))
        );
        List<Address> rsl = new Profiles().collect(profiles);
        List<Address> expected = Arrays.asList(
             new Address("Voronezh", "Shishkova", 61, 105),
             new Address("Samara", "Mira", 5, 1)
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenTestMethodCollectSortWithoutDuplicate() {
        Address first = new Address("City1", "Street1", 1, 1);
        Address second = new Address("City2", "Street2", 2, 2);
        Address third = new Address("City3", "Street3", 3, 3);
        Address fourth = new Address("City1", "Street1", 1, 1);
        Address fifth = new Address("City2", "Street2", 2, 2);
        Address seventh = new Address("City3", "Street3", 3, 3);
        List<Profile> profiles = Arrays.asList(
                new Profile(second),
                new Profile(fourth),
                new Profile(fifth),
                new Profile(first),
                new Profile(seventh),
                new Profile(third)
        );
        List<Address> result = new Profiles().collectSortWithoutDuplicate(profiles);
        List<Address> expected = Arrays.asList(first, second, third);
        assertEquals(expected, result);
    }
}