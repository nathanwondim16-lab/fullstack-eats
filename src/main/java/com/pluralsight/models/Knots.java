package com.pluralsight.models;

import com.pluralsight.enums.KnotsType;
import com.pluralsight.interfaces.Chargeable;
import com.pluralsight.ui.UserInterface;

public class Knots implements Chargeable {
    private final KnotsType knotsType;

    public Knots(KnotsType knotsType) {
        this.knotsType = knotsType;
    }

    public KnotsType getKnots() {
        return knotsType;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public void orderDetails() {
        UserInterface.printToConsoleFormatted("""
  
                %s KNOTS
                Price: $%.2f
                """, knotsType, getPrice());
    }

    @Override
    public void editItem() {

    }
}