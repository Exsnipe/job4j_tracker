package io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        String[] answers = {"Yes", "No", "May be"};
        Scanner scan = new Scanner(System.in);
        System.out.println("I am Oracle the great! What do you want to know?");
        scan.nextLine();
        System.out.println(answers[new Random().nextInt(3)]);
    }
}
