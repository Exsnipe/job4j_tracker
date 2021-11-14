package poly;

public class Train implements Vechicle {
    private int fuel = 2000;

    @Override
    public void move() {
        System.out.println(" started moving");
    }

    @Override
    public int fuelSupply() {
        return fuel;
    }
}
