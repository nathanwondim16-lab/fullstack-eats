package com.pluralsight.models;

import com.pluralsight.enums.SandwichSize;
import com.pluralsight.enums.SandwichToppings;
import com.pluralsight.interfaces.Chargeable;

public class Sandwich extends Food<SandwichToppings> implements Chargeable {

    private final SandwichSize sandwichSize;

    public Sandwich(SandwichSize sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
