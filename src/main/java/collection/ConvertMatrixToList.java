package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConvertMatrixToList {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int row = 0; row < array.length; row++) {
            for (int cell = 0; cell < array[row].length; cell++) {
                list.add(array[row][cell]);
            }
        }
        return list;
    }

}
