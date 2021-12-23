package stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public static Map<String, Student> convert(List<Student> studentList) {
        return studentList.stream()
                .collect(Collectors.toMap(
                Student::getSurName,
                student -> student,
                (existing, replacement) -> existing
        ));
    }
}
