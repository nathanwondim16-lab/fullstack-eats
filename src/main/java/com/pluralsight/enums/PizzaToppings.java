package com.pluralsight.enums;

public enum PizzaToppings {

    /*
    PREMIUM

                            Meats:
     */
    PEPPERONI(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    SAUSAGE(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    HAM(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    BACON(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    CHICKEN(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    MEATBALL(ToppingCategory.MEAT, ToppingTier.PREMIUM),

    //                      Cheeses
    MOZZARELLA(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    PARMESAN(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    RICOTTA(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    GOAT_CHEESE(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    BUFFALO(ToppingCategory.CHEESE, ToppingTier.PREMIUM),

    // REGULAR
    ONIONS(ToppingCategory.OTHER, ToppingTier.REGULAR),
    MUSHROOMS(ToppingCategory.OTHER, ToppingTier.REGULAR),
    BELL_PEPPERS(ToppingCategory.OTHER, ToppingTier.REGULAR),
    OLIVES(ToppingCategory.OTHER, ToppingTier.REGULAR),
    TOMATOES(ToppingCategory.OTHER, ToppingTier.REGULAR),
    SPINACH(ToppingCategory.OTHER, ToppingTier.REGULAR),
    BASIL(ToppingCategory.OTHER, ToppingTier.REGULAR),
    PINEAPPLE(ToppingCategory.OTHER, ToppingTier.REGULAR),
    ANCHOVIES(ToppingCategory.OTHER, ToppingTier.REGULAR);

    private final ToppingCategory category;
    private final ToppingTier tier;

    PizzaToppings(ToppingCategory category, ToppingTier tier) {
        this.category = category;
        this.tier = tier;
    }

    public ToppingCategory getCategory() {
        return category;
    }

    public ToppingTier getTier() {
        return tier;
    }
}
