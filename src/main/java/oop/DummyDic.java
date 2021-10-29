package oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic test = new DummyDic();
        System.out.println(test.engToRus("helicopter"));
        System.out.println(test.engToRus("airplane"));
    }
}
