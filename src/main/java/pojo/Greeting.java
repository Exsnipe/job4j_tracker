package pojo;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello. What's your name?");
        String name = input.nextLine();
        System.out.println(name + ", nice to meet you!");
    }
}
