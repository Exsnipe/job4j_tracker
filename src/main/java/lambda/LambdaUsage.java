package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(
                "Beta",
                "Gamma",
                "Omega",
                "Alpha"
        ));
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare: " + left + " " + right);
            return left.compareTo(right);
        };
        list.sort(comparator);
        System.out.println(list);
    }
}
