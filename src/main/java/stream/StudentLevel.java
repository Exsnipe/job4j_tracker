package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Stud> levelOf(List<Stud> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> right.getScore() - left.getScore())
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }
 }
