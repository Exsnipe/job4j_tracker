package stream;

import java.util.Objects;

public class Student {
    private int score;
    private String surName;

    public Student(int score, String surName) {
        this.score = score;
        this.surName = surName;
    }

    public int getScore() {
        return score;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score && Objects.equals(surName, student.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surName);
    }
}