package professions;

public class Diagnosis {
    private String[] diagnosis = {"measles", "chickenpox", "headacke", "cough"};
    private String diagnos;
    private String pationName;

    public Diagnosis(int numberOfDiagnosis) {
        diagnos = diagnosis[numberOfDiagnosis];
    }

    public Diagnosis(String diagnos) {
        this.diagnos = diagnos;
    }
}
