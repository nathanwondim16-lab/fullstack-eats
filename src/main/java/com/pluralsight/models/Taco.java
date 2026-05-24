package com.pluralsight.models;

import com.pluralsight.enums.TacoChoices;
import com.pluralsight.enums.TacoToppings;
import com.pluralsight.interfaces.Chargeable;

public class Taco extends Food<TacoToppings> implements Chargeable {

    private final TacoChoices tacoChoices;

    public Taco(TacoChoices tacoChoices) {
        this.tacoChoices = tacoChoices;
    }

    public TacoChoices getTacoChoices() {
        return tacoChoices;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
