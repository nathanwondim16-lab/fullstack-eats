package com.pluralsight.enums;

public enum PizzaToppingType {

    // Meats
    PEPPERONI(ToppingCategory.PREMIUM),
    SAUSAGE(ToppingCategory.PREMIUM),
    HAM(ToppingCategory.PREMIUM),
    BACON(ToppingCategory.PREMIUM),
    CHICKEN(ToppingCategory.PREMIUM),
    MEATBALL(ToppingCategory.PREMIUM),

    // Cheeses
    MOZZARELLA(ToppingCategory.PREMIUM),
    PARMESAN(ToppingCategory.PREMIUM),
    RICOTTA(ToppingCategory.PREMIUM),
    GOAT_CHEESE(ToppingCategory.PREMIUM),
    BUFFALO(ToppingCategory.PREMIUM),

    // Vegetables
    ONIONS(ToppingCategory.REGULAR),
    MUSHROOMS(ToppingCategory.REGULAR),
    BELL_PEPPERS(ToppingCategory.REGULAR),
    OLIVES(ToppingCategory.REGULAR),
    TOMATOES(ToppingCategory.REGULAR),
    SPINACH(ToppingCategory.REGULAR),
    BASIL(ToppingCategory.REGULAR),
    PINEAPPLE(ToppingCategory.REGULAR),
    ANCHOVIES(ToppingCategory.REGULAR);

    private final ToppingCategory category;

    PizzaToppingType(ToppingCategory category) {
        this.category = category;
    }

    public ToppingCategory getCategory() {
        return category;
    }
}
