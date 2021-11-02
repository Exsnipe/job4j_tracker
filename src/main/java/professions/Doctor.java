package professions;

public class Doctor extends Profession {
    private String name;
    private String surname;
    private String eduucation;
    private int birthday;

    public Doctor(String name, String surname, String  eduucation, int birthday) {
        super(name, surname, eduucation, birthday);
    }

    public Diagnosis heal(Pacient pacient) {
        if (pacient.getSick()) {
            return new Diagnosis((int) Math.round(Math.random() * 3));
        } else {
            return new Diagnosis("not sick");
        }
    }
}
