package lambda;

import java.util.function.Supplier;

public class ScopeInside {
    private static int total;

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        total = 0;
        for (int number : numbers) {
            total = add(
                    () -> number + total
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}