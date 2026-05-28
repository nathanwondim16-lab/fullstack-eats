package com.pluralsight.enums;

import com.pluralsight.interfaces.OrganizeToppings;

public enum PizzaToppings implements OrganizeToppings {

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
    BUFFALO_CHEESE(ToppingCategory.CHEESE, ToppingTier.PREMIUM),

    // REGULAR
    ONIONS(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    MUSHROOMS(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    BELL_PEPPERS(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    OLIVES(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    TOMATOES(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    SPINACH(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    BASIL(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    PINEAPPLE(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    ANCHOVIES(ToppingCategory.REGULAR, ToppingTier.INCLUDED),

    //                       Sauces
    MARINARA(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    ALFREDO(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    PESTO(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    BBQ(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    BUFFALO_(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    OLIVE_OIL(ToppingCategory.SAUCE, ToppingTier.INCLUDED),

    //                       Sides
    RED_PEPPER(ToppingCategory.SIDE, ToppingTier.INCLUDED),
    PARMESAN_PACKET(ToppingCategory.SIDE, ToppingTier.INCLUDED);

    private final ToppingCategory category;
    private final ToppingTier tier;

    PizzaToppings(ToppingCategory category, ToppingTier tier) {
        this.category = category;
        this.tier = tier;
    }

    @Override
    public ToppingCategory getCategory() {
        return category;
    }

    @Override
    public ToppingTier getTier() {
        return tier;
    }
}