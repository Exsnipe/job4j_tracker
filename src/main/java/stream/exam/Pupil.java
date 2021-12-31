package stream.exam;

import java.util.List;

public class Pupil {
    private String name;
    private List<Subject> subject;

    public Pupil(String name, List<Subject> subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubject() {
        return subject;
    }
}
