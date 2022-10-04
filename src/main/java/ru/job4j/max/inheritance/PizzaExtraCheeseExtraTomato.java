package ru.job4j.max.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    @Override
    public String name() {
        return super.name() + " + extra tomato";
    }
}
