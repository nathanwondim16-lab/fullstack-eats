package com.pluralsight.models;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.SandwichSize;
import com.pluralsight.enums.SandwichToppings;

public class Sandwich extends Food<SandwichToppings> {
    private final BreadType breadType;
    private final SandwichSize sandwichSize;
    private final boolean isToasted;

    public Sandwich(BreadType breadType, SandwichSize sandwichSize, boolean isToasted) {
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.isToasted = isToasted;
    }

    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    @Override
    public double getPrice() {
        return sandwichSize.getSandwichSizePrice() + getToppings().stream().mapToDouble(sandwichSize::getToppingPrice).sum();
    }
}