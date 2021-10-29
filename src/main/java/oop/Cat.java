package oop;

public class Cat {
    private String food;
    private String name;
    public void show() {
        System.out.println("name of cat is " + this.name);
        System.out.println(name + " eats " + this.food);
    }

    public void eat(String meal) {
        this.food = meal;
    }

    public void giveNick(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.eat("Kotleta");
        gav.giveNick("Gav");
        gav.show();
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Black");
        black.show();
    }
}
