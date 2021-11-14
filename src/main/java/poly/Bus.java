package poly;

public class Bus implements Vechicle {
    private int fuel = 200;

    public Bus() {

    }

    public Bus(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public void move() {
        System.out.println(" started moving");
    }

    @Override
    public int fuelSupply() {
        return fuel;
    }
}
