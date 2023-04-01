package stream.cards;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoubleCard {
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values())
                        .map(v -> new Card(s, v))).toList()
                .forEach(System.out::println);
    }
}
