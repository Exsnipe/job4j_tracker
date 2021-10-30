package oop;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point  c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double semiPerimetr(double ab, double bc, double ac) {
        if (this.exsists(ab, bc, ac)) {
            return (ab + bc + ac) / 2;
        }
        return 0;
    }

    public boolean exsists(double ab, double bc, double ac) {
        return (ab + bc >  ac) &&  (ab + ac > bc) && (bc + ac > ab);
    }

    public double area() {
        double ab = this.a.distance(b);
        double bc = this.b.distance(c);
        double  ac = this.c.distance(a);
        double perimetr = this.semiPerimetr(ab, bc, ac);
        double s = Math.sqrt(perimetr * (perimetr - ab) * (perimetr - bc) * (perimetr - ac));
        return s;
    }
}