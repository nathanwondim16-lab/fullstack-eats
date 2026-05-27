package com.pluralsight.models;

import com.pluralsight.enums.TacoChoices;
import com.pluralsight.enums.TacoToppings;

public class Taco extends Food<TacoToppings> {

    private final TacoChoices tacoChoices;
    private final boolean isCoveredInSalasAndQueso;

    public Taco(TacoChoices tacoChoices, boolean isCoveredInSalasAndQueso) {
        this.tacoChoices = tacoChoices;
        this.isCoveredInSalasAndQueso = isCoveredInSalasAndQueso;
    }

    public TacoChoices getTacoChoices() {
        return tacoChoices;
    }

    public boolean isCoveredInSalasAndQueso() {
        return isCoveredInSalasAndQueso;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void orderDetails() {

    }
}