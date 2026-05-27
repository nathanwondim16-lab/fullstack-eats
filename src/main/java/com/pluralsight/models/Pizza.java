package com.pluralsight.models;

import com.pluralsight.enums.PizzaSize;
import com.pluralsight.enums.PizzaToppings;

public class Pizza extends Food<PizzaToppings> {
    private final PizzaSize pizzaSize;
    private final boolean isCrustStuffed;

    public Pizza(PizzaSize pizzaSize, boolean isCrustStuffed) {
        this.pizzaSize = pizzaSize;
        this.isCrustStuffed = isCrustStuffed;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public boolean isCrustStuffed() {
        return isCrustStuffed;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void orderDetails() {

    }

    @Override
    public void editItem() {

    }
}