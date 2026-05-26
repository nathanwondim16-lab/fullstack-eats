package com.pluralsight.models;

import com.pluralsight.enums.ChipFlavors;
import com.pluralsight.interfaces.Chargeable;

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
}