package stream.cards;

public class DoubleLoop {
    public static void main(String[] args) {
        for (Suit st : Suit.values()) {
            for (Value val : Value.values()) {
                System.out.println(new Card(st, val));
            }
        }
    }
}
