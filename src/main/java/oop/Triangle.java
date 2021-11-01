package oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point a, Point b, Point  c) {
        this.first = a;
        this.second = b;
        this.third = c;
    }

    public double semiPerimetr(double ab, double bc, double ac) {
        return (ab + bc + ac) / 2;
    }

    public boolean exsist(double ab, double bc, double ac) {
        return (ab + bc >  ac) &&  (ab + ac > bc) && (bc + ac > ab);
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exsist(ab, ac, bc)) {
            double p = semiPerimetr(ab, ac, bc);
            rsl = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return rsl;
    }
}