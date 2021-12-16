package collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] left = o1.split("/");
        String[] right = o2.split("/");
        for (int index = 0; index < Math.min(left.length, right.length); index++) {
            if (!left[index].equals(right[index])) {
                return left[index].compareTo(right[index]);
            }
        }
        return 0;
    }
}
