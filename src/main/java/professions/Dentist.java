package professions;

public class Dentist extends Doctor {
    private String name;
    private String surname;
    private String education;
    private int birthday;

    public Dentist(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    public Pacient treatTooth(Pacient pacient) {
        return new Pacient();
    }
}
