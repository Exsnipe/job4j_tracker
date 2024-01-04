package collection.repeate;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSort {
    public static void main(String[] args) {
        Set<Integer> treeset = new TreeSet<>(Collections.reverseOrder());
        treeset.add(5);
        treeset.add(3);
        treeset.add(7);
        treeset.add(1);
        System.out.println(treeset);
    }
}
