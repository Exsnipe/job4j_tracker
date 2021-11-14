package poly;

public class Aircraft implements Vechicle {
    private int fuel = 6000;

   public Aircraft() {

   }

    public Aircraft(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public void move() {
        System.out.println(" took off");
    }

    @Override
    public int fuelSupply() {
        return fuel;
    }
}
