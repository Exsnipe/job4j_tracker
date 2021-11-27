package collection;

import java.util.List;
import java.util.ArrayList;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> convertedList = new ArrayList<>();
        for (int[] array : list) {
            for (int num : array) {
                convertedList.add(num);
            }
        }
        return convertedList;
    }
}
