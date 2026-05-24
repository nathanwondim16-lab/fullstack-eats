package com.pluralsight.models;

import com.pluralsight.enums.PizzaSize;
import com.pluralsight.enums.PizzaToppings;

public class Pizza extends Food<PizzaToppings> {
    private final PizzaSize pizzaSize;

    public Pizza(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
