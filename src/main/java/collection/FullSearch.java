package collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    public static Set<String> extractNumbers(List<TaskH> list) {
        Set<String> numbers = new HashSet<>();
        for (TaskH task1 : list) {
            numbers.add(task1.getNumber());
        }
        return numbers;
    }
}
