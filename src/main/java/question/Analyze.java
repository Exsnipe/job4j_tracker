package question;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        Set<User> intersection = new HashSet<>(previous);
        intersection.retainAll(current);
        int trunkedPrevious = previous.size() - intersection.size();
        int trunkedCurrent = current.size() - intersection.size();
        previous.removeAll(intersection);
        current.removeAll(intersection);
        previous.addAll(current);
        int summed = previous.size();
        Set<Integer> ids = previous.stream()
                .map(User::getId)
                .collect(Collectors.toSet());
        int changed = summed - ids.size();
        return new Info(trunkedCurrent - changed,
                changed, trunkedPrevious - changed);
    }
}
