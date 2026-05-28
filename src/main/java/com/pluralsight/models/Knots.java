package com.pluralsight.models;

import com.pluralsight.interfaces.Chargeable;
import com.pluralsight.ui.UserInterface;

public class Knots implements Chargeable {
    private final com.pluralsight.enums.Knots knots;

    public Knots(com.pluralsight.enums.Knots knots) {
        this.knots = knots;
    }

    public com.pluralsight.enums.Knots getKnots() {
        return knots;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public void orderDetails() {
        UserInterface.printToConsoleFormatted("""
  
                %s
                Price: $%.2f
                """, knots.getDisplayName(), getPrice());
    }

    @Override
    public void editItem() {

    }
}