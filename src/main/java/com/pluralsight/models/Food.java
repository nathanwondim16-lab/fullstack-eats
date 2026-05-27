package com.pluralsight.models;

import com.pluralsight.enums.Colors;
import com.pluralsight.interfaces.Chargeable;
import com.pluralsight.ui.UserInterface;

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

    public void removeTopping(Topping<T> topping) {
        if(!toppings.contains(topping)) {
            UserInterface.printToConsole("Topping doesn't exist in your order", Colors.CRIMSON);
            return;
        }

        toppings.remove(topping);
    }

    public List<Topping<T>> getToppings() {

        return toppings;
    }

    @Override
    public String toString() {
        return "";
    }
}