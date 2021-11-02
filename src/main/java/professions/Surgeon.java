package professions;

public class Surgeon extends Doctor {
    private int amountSurgerys;

    public Surgeon(String name, String surname, String education, int birthday, String spec,
                   int amountSurgerys) {
        super(name, surname, education, birthday, spec);
        this.amountSurgerys =  amountSurgerys;
    }

    public Pacient makeSurgery(Pacient pacient) {
        return new Pacient();
    }
}