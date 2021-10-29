package oop;

public class Ball {
    public void tryToRun(boolean isEaten) {
        if (isEaten) {
            System.out.println("Ball has been eaten");
        } else {
            System.out.println("Ball has run");
        }
    }
}
