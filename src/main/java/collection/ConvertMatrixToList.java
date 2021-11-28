package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConvertMatrixToList {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] num : array) {
            for (int number : num) {
                list.add(number);
            }
        }
        return list;
    }

}
