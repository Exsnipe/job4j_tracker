package ex;

public class FactRec {
    public static int factRec(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factRec(n - 1) * n;
        }
    }

    public static void main(String[] args) {
        System.out.println(factRec(3));
    }
}
