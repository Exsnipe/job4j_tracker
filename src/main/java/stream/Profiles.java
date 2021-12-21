package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    private Comparator<Address> comparator = (Address o1, Address o2) -> o1.getCity().compareTo(o2.getCity());

    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress()).collect(Collectors.toList());
    }

    public List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress())
                .sorted(comparator).distinct().collect(Collectors.toList());
    }
}
