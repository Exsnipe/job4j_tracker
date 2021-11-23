package fabricpattern;

import java.util.Scanner;

public class Canvas {
    private ShapeOperator shapeOperator;

    public Canvas(ShapeOperator shapeOperator) {
        this.shapeOperator = shapeOperator;
    }

    public void demonstrate() {
        shapeOperator.showInfo();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeOperator operator;
        System.out.println("Какую фигуру создать? Прямоугольник или треугольник");
        String answer = scanner.nextLine();
        if (answer.equals("прямоугольник")) {
             operator = new RectangleOperator();
        } else  {
            operator = new TriangleOperator();
        }
        new Canvas(operator).demonstrate();
    }
}
