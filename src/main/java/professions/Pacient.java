package professions;

public class Pacient {
    private String name;
    private boolean isSick;
    private Diagnosis myDiagnos;

    public Pacient(String name, boolean isSick) {
        this.name = name;
        this.isSick = isSick;
    }

    public Pacient() {
    }

    public boolean getSick() {
        return isSick;
    }

    public void getDiagnosis(Diagnosis diagnosis) {
        this.myDiagnos = diagnosis;
    }
}
