package com.pluralsight.enums;

public enum SandwichToppings {

    /*
    PREMIUM

                            Meats:
     */
    STEAK(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    HAM(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    SALAMI(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    ROAST_BEEF(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    CHICKEN(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    BACON(ToppingCategory.MEAT, ToppingTier.PREMIUM),

    //                      Cheeses
    AMERICAN(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    PROVOLONE(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    CHEDDAR(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    SWISS(ToppingCategory.CHEESE, ToppingTier.PREMIUM),

    // REGULAR
    LETTUCE(ToppingCategory.OTHER, ToppingTier.REGULAR),
    PEPPERS(ToppingCategory.OTHER, ToppingTier.REGULAR),
    ONIONS(ToppingCategory.OTHER, ToppingTier.REGULAR),
    TOMATOES(ToppingCategory.OTHER, ToppingTier.REGULAR),
    JALAPEÑOS(ToppingCategory.OTHER, ToppingTier.REGULAR),
    CUCUMBERS(ToppingCategory.OTHER, ToppingTier.REGULAR),
    PICKLES(ToppingCategory.OTHER, ToppingTier.REGULAR),
    GUACAMOLE(ToppingCategory.OTHER, ToppingTier.REGULAR),
    MUSHROOMS(ToppingCategory.OTHER, ToppingTier.REGULAR);


    private final ToppingCategory category;
    private final ToppingTier tier;

    SandwichToppings(ToppingCategory category, ToppingTier tier) {
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
