package stream.list;

import java.util.Map;
import java.util.Set;

public class CollegeStream {
    private final Map<Student, Set<Subject>> students;

    public CollegeStream(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Student findStudent(String account) {
        return students.keySet()
                .stream()
                .filter(s -> s.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }

    public Subject findSubject(String account, String subject) {
        Student currentStudent = findStudent(account);
        if (currentStudent != null) {
            return students.get(currentStudent)
                    .stream()
                    .filter(s -> s.getName().equals(subject))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );
        College college = new College(students);
        Student student = college.findStudent("000001");
        System.out.println("Найденный студент: " + student);
        Subject english = college.findSubject("000001", "English");
        System.out.println(english);
        System.out.println("Оценка по найденному предмету: " + english.getScore());
    }
}