package oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже пещехожы по лужам, а вода по асфальту рекой...");
        } else if (position == 2) {
            System.out.println("Спокойной ноч, малыши");
        } else {
            System.out.println("Композиция не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox test = new Jukebox();
        test.music(1);
        test.music(2);
        test.music(3);
    }
}
