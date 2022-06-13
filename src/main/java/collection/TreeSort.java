package collection;

import java.util.Set;
import java.util.TreeSet;

public class TreeSort {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(3);
        set.add(1);
        System.out.println(set);

        Set<User> setUser = new TreeSet<>();
        setUser.add(new User("Viktor", 25));
        setUser.add(new User("Alex", 42));
        setUser.add(new User("Viktor", 14));
        System.out.println(setUser);
    }
}
