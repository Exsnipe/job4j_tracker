package professions;

public class Programmer extends Engineer {
    private String name;
    private String surname;
    private String eduucation;
    private int birthday;

    public Programmer(String name, String surname, String eduucation, int birthday) {
        super(name, surname, eduucation, birthday);
    }

    public Programm makeProgram(String ttz) {
        return new Programm();
    }
}
