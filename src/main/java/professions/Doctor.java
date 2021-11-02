package professions;

public class Doctor extends Profession {
    private String spec;

    public Doctor(String name, String surname, String  eduucation, int birthday, String spec) {
        super(name, surname, eduucation, birthday);
        this.spec =  spec;
    }

    public Diagnosis heal(Pacient pacient) {
        if (pacient.getSick()) {
            return new Diagnosis((int) Math.round(Math.random() * 3));
        } else {
            return new Diagnosis("not sick");
        }
    }
}
