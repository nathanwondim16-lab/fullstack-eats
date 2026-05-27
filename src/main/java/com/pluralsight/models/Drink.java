package com.pluralsight.models;

import com.pluralsight.enums.DrinkFlavors;
import com.pluralsight.enums.DrinkSize;
import com.pluralsight.interfaces.Chargeable;
import com.pluralsight.ui.UserInterface;

public class Drink implements Chargeable {
    private final DrinkFlavors flavor;
    private final DrinkSize drinkSize;

    public Drink(DrinkFlavors flavor, DrinkSize drinkSize) {
        this.flavor = flavor;
        this.drinkSize = drinkSize;
    }

    public DrinkFlavors getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice() {
        return drinkSize.getPrice();
    }

    @Override
    public void orderDetails() {
        UserInterface.printToConsoleFormatted("""
                
                %-10s %s
                %-10s %s
                %-10s $%.2f
                """, "Drink:", flavor, "Size:", drinkSize, "Price:", getPrice());
    }
}