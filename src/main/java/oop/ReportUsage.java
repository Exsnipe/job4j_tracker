package oop;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport textReport = new TextReport();
        System.out.println(textReport.generate("name", "body"));
        JSONReport jsRep = new JSONReport();
        System.out.println(jsRep.generate("name", "body"));
    }
}
