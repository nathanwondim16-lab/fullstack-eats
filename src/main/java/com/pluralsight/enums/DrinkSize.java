package com.pluralsight.enums;

import java.util.Arrays;

public enum DrinkSize {
    SMALL(2),
    MEDIUM(2.50),
    LARGE(3);

    private final double price;

    DrinkSize(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public static void displayDrinkSizes() {
        Arrays.stream(DrinkSize.values())
                .map(Enum::toString)
                .forEach(size -> System.out.println("◆ " + size));
    }
}