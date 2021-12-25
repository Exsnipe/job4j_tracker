package stream.cards;

import java.util.stream.Stream;

public class DoubleStream {
    public static void main(String[] args) {
       Stream.of(Suit.values())
               .flatMap(suit -> Stream.of(Value.values())
                       .map(value -> new Card(suit, value)))
               .forEach(System.out::println);
    }
}
