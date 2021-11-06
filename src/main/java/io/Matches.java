package io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        System.out.println("Start game 11");
        Scanner input = new Scanner(System.in);
        int count = 11;
        boolean turn = false;
        while (count > 0) {
            System.out.println("First player takes:");
            count -= Integer.parseInt(input.nextLine());
            if (count <= 0) {
                turn = !turn;
                break;
            }
            System.out.println("Осталось " + count);
            System.out.println("Second player takes");
            count -= Integer.parseInt(input.nextLine());
            if (count <= 0) {
                break;
            }
            System.out.println("Осталось " + count);
        }
        String rsl = !turn ? "Second" : "First";
        System.out.println(rsl + " player wone");
    }
}
