package com.pluralsight.enums;

public enum PizzaSize {

    EIGHT(8.50),
    TWELVE(12),
    SIXTEEN(16.50);

    private final double price;

    PizzaSize(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}