package oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void show() {
        System.out.println("active is " + this.active);
        System.out.println("status is " + this.status);
        System.out.println("message is " + this.message);
    }

    public static void main(String[] args) {
        Error er1 = new Error(true, 5, "Loading");
        Error er2 = new Error();
        Error er3 = new Error();
        er1.show();
        er2.show();
        er3.show();
    }
}
