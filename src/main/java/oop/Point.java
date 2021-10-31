package oop;

public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point another) {
        return Math.sqrt(Math.pow(another.x - this.x, 2) + Math.pow(another.y - this.y, 2));
    }

    public double distance3d(Point another) {
        return Math.sqrt(Math.pow(another.x - this.x, 2) + Math.pow(another.y - this.y, 2)
                + Math.pow(another.z - this.z, 2));
    }
}