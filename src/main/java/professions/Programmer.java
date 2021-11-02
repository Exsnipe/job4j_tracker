package professions;

public class Programmer extends Engineer {
    private String status;

    public Programmer(String name, String surname, String eduucation, int birthday,  int seniority, String status) {
        super(name, surname, eduucation, birthday, seniority);
        this.status = status;
    }

    public Programm makeProgram(String ttz) {
        return new Programm();
    }
}
