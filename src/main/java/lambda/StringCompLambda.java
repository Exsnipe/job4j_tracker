package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class StringCompLambda {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
                "Petr"
        };
        Comparator<String> comp = (right, left) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, comp);
    }
}
