package poly;

public class TransportUsage {
    public static void main(String[] args) {
        Vechicle cesna = new Aircraft();
        Vechicle vilga = new Aircraft(4000);
        Vechicle treinToMoscow = new Train();
        Vechicle electroTrain = new Train();
        Vechicle busToVoronezh = new Bus(450);
        Vechicle busNumberOne = new Bus();
        Vechicle[] vechicles = {cesna, vilga, treinToMoscow, electroTrain,
                busToVoronezh, busNumberOne};
        for (Vechicle vechicle : vechicles) {
            System.out.print(vechicle.getClass().getSimpleName());
            vechicle.move();
            System.out.println("Fuel supply is " + vechicle.fuelSupply());
        }
    }
}
