package professions;

public class Surgeon extends Doctor {
    private String name;
    private String surname;
    private String education;
    private int birthday;

    public Surgeon(String name, String surname, String education, int birthday) {
        super(name, surname, education, birthday);
    }

    public Pacient makeSurgery(Pacient pacient) {
        return new Pacient();
    }
}