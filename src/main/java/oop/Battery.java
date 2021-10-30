package oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(75);
        Battery second = new Battery(15);
        System.out.println("first battery load is " + first.load);
        System.out.println("second battery load is " + second.load);
        first.exchange(second);
        System.out.println("-----------make exchange--------------");
        System.out.println("first battery load is " + first.load);
        System.out.println("second battery load is " + second.load);
    }
}
