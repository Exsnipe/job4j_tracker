package professions;

public class Engineer extends Profession {
   private int seniority;

    public Engineer(String name, String surname, String eduucation, int birthday, int seniority) {
        super(name, surname, eduucation, birthday);
        this.seniority = seniority;
    }

    public Task makeTask(String ttz) {
        return new Task();
    }
}
