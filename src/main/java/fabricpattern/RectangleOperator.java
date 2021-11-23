package fabricpattern;

import java.util.Scanner;

public class RectangleOperator extends ShapeOperator {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Shape createShape() {
        System.out.println("Введите ширину прямоугольника");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите длинну прямоугольника");
        int b = Integer.parseInt(scanner.nextLine());
        return new Rectangle(a, b);
    }
}
