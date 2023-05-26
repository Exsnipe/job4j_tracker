package stream.mapto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapToIntExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        OptionalDouble average = people.stream()
                .mapToInt(Person::getAge)
                .average();
        System.out.println(average.getAsDouble());
    }
}
