package com.pluralsight.models;

import com.pluralsight.enums.ChipFlavors;
import com.pluralsight.interfaces.Chargeable;
import com.pluralsight.ui.UserInterface;

public class Chips implements Chargeable {
    private final ChipFlavors flavor;

    public Chips(ChipFlavors flavor) {
        this.flavor = flavor;
    }

    public ChipFlavors getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public void orderDetails() {
        UserInterface.printToConsoleFormatted("""
  
                Chips: %s
                Price: $%.2f
                """, flavor, getPrice());
    }

    @Override
    public void editOrder() {

    }
}