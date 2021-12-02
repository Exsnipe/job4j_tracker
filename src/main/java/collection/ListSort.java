package collection;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Integer first = 6;
        Integer second = 2;
        int rsl = first.compareTo(second);
        System.out.println(rsl);
    }
}
