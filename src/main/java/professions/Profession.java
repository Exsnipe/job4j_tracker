package professions;

public class Profession {
    private String name;
    private String surname;
    private String eduucation;
    private int birthday;

    public Profession(String name, String surname, String education, int birthday) {
        this.name = name;
        this.surname = surname;
        this.eduucation = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return eduucation;
    }

    public int getBirthday() {
        return birthday;
    }
}
