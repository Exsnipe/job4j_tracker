package oldtasks.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    public String name() {
        return super.name() + " + extra tomato";
    }
}
