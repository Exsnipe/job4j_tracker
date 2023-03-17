package stream.cards;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoubleLevel {
    public static void main(String[] args) {
        String[] levels = {"level 1", "level 2", "level 3"};
        String[] tasks = {"task 1", "task 2", "task 3", "task 4"};
        Stream.of(levels)
                .flatMap(l -> Stream.of(tasks)
                        .map(t -> l + " " + t)).toList()
                .forEach(System.out::println);
    }
}
