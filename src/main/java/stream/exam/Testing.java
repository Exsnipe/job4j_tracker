package stream.exam;

import java.util.*;
import java.util.stream.Collectors;

public class Testing {
    private int a;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Testing testing = (Testing) o;
        Testing te = (Testing) o;
        Testing ing = (Testing) o;
        return a == testing.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    public static void main(String[] args) {
        Byte a = 2;
        System.out.println(a.hashCode());
        List<String> ls = new ArrayList<>();
        ls.iterator();
    }

}

