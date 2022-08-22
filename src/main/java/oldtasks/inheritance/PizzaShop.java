package oldtasks.inheritance;

public class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        System.out.println(pizza.name());
        PizzaExtraCheese pec = new PizzaExtraCheese();
        System.out.println(pec.name());
        PizzaExtraCheeseExtraTomato pecet = new PizzaExtraCheeseExtraTomato();
        System.out.println(pecet.name());
    }
}
