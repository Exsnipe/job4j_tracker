package fabricpattern;

import java.util.Scanner;

public class TriangleOperator extends ShapeOperator {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Shape createShape() {
        System.out.println("Введите основание треугольника");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите высоту треугольника");
        int h = Integer.parseInt(scanner.nextLine());
        return new Triangle(a, h);
    }
}
