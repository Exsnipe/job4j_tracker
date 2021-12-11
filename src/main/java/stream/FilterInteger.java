package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterInteger {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 7, -2, 6, 8, -1, 3, 9);
        List<Integer> filteredList = list.stream().filter(p -> p > 0).collect(Collectors.toList());
        System.out.println(filteredList);
    }

}
