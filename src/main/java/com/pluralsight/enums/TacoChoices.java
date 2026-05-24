package com.pluralsight.enums;

public enum TacoChoices {
    SINGLE(3.50),
    THREE_TACO(9),
    BURRITO(8.50);

    private final double price;

    TacoChoices(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}