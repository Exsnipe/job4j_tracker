package professions;

public class Engineer extends Profession {
    private String name;
    private String surname;
    private String eduucation;
    private int birthday;

    public Engineer(String name, String surname, String eduucation, int birthday) {
        super(name, surname, eduucation, birthday);
    }

    public Task makeTask(String ttz) {
        return new Task();
    }
}
