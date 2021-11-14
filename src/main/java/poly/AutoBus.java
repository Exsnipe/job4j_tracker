package poly;

import java.util.Scanner;

public abstract class AutoBus implements Transport {
    private static final double FUELPRICE = 1.5;
    private int pasangers;

    @Override
    public void ride() {
        Scanner scan = new Scanner(System.in);
        int push = scan.nextInt();
        double speed = startEngine(push);
    }

    @Override
    public void pasangers(int pasangers) {
        this.pasangers = pasangers;
    }

    @Override
    public double reFuel(int fuel) {
        return fuel * FUELPRICE;
    }

    public double startEngine(int push) {
        double speed = 0;
        switch (push) {
            case 1:
                speed = 10.0;
                break;
            case 2:
                speed = 20;
                break;
            case 3:
                speed = 30;
                break;
            default:
                speed = 0.5;
        }
    return speed;
    }
}
