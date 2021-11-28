package collection;

import java.util.ArrayList;

public class ConvertListToArray {
    public static int[][] toArray(ArrayList<Integer> list, int cells) {
        int group = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[group][cells];
        int row = 0, cell = 0;
        for (int num: list) {
            array[row][cell++] = num;
            if (cell == cells) {
                cell = 0;
                row++;
            }
        }
        return array;
    }
}
