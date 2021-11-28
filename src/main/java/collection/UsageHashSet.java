package collection;

import java.util.Set;
import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        Set<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("Toyota");
        for (String auto : autos) {
            System.out.println(auto);
        }
    }
}
