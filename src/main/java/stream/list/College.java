package stream.list;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findStudent(String account) {
        Optional<Student> rsl = Optional.empty();
        for (var student : students.keySet()) {
            if (student.getAccount().equals(account)) {
                rsl = Optional.of(student);
                break;
            }
        }
        return rsl;
    }

    public Optional<Subject> findSubject(String account, String subject) {
        Optional<Student> currentStudent = findStudent(account);
        Optional<Subject> rsl = Optional.empty();
        if (currentStudent.isPresent()) {
            Set<Subject> subjects = students.get(currentStudent.get());
            for (var subj : subjects) {
                if (subj.getName().equals(subject)) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );
        College college = new College(students);
        Optional<Student> student = college.findStudent("000001");
        System.out.println("Найденный студент: " + student);
        Optional<Subject> english = college.findSubject("000001", "English");
        System.out.println(english);
        System.out.println("Оценка по найденному предмету: " + english.get().getScore());
    }
}
