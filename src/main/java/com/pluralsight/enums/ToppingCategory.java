package com.pluralsight.enums;

public enum ToppingCategory {
    MEAT("Meat"),
    CHEESE("Cheese"),
    SAUCE("Sauces"),
    OTHER("Other toppings");

    private final String name;

    ToppingCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}