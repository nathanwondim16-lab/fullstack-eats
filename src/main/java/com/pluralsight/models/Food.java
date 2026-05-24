package com.pluralsight.models;

import com.pluralsight.interfaces.Chargeable;

import java.util.ArrayList;
import java.util.List;

public abstract class Food<T extends Enum<T>> implements Chargeable {
    private final List<Topping<T>> toppings;

    public Food() {
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping<T> topping) {
        toppings.add(topping);
    }

    public List<Topping<T>> getToppings() {
        return toppings;
    }
}