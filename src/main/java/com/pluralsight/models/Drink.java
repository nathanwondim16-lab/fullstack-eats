package com.pluralsight.models;

import com.pluralsight.enums.DrinkSize;
import com.pluralsight.interfaces.Chargeable;

public class Drink implements Chargeable {
    private final String flavor;
    private final DrinkSize drinkSize;

    public Drink(String flavor, DrinkSize drinkSize) {
        this.flavor = flavor;
        this.drinkSize = drinkSize;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice() {
        return drinkSize.getPrice();
    }
}