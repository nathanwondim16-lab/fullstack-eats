package com.pluralsight.models;

import com.pluralsight.enums.Knots;
import com.pluralsight.interfaces.Chargeable;
import com.pluralsight.ui.UserInterface;

public class GarlicKnots implements Chargeable {
    private final Knots knots;

    public GarlicKnots(Knots knots) {
        this.knots = knots;
    }

    public Knots getKnots() {
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