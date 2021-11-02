package professions;

public class Dentist extends Doctor {
   private int seniority;

    public Dentist(String name, String surname, String education, int birthday, String spec, int seniority) {
        super(name, surname, education, birthday, spec);
        this.seniority = seniority;
    }

    public Pacient treatTooth(Pacient pacient) {
        return new Pacient();
    }
}
