package com.pluralsight.enums;

import com.pluralsight.interfaces.OrganizeToppings;

public enum SandwichToppings implements OrganizeToppings {

    /*
    PREMIUM

                            Meats:
     */
    STEAK(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    HAM(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    TURKEY(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    SALAMI(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    ROAST_BEEF(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    CHICKEN(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    BACON(ToppingCategory.MEAT, ToppingTier.PREMIUM),

    //                      Cheeses
    AMERICAN(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    PROVOLONE(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    CHEDDAR(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    SWISS(ToppingCategory.CHEESE, ToppingTier.PREMIUM),

    /*
    REGULAR


                         Other toppings
     */
    LETTUCE(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    PEPPERS(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    ONIONS(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    TOMATOES(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    JALAPENOS(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    CUCUMBERS(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    PICKLES(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    GUACAMOLE(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    MUSHROOMS(ToppingCategory.REGULAR, ToppingTier.INCLUDED),

    //                       Sauces
    MAYO(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    MUSTARD(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    KETCHUP(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    RANCH(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    THOUSAND_ISLANDS(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    VINAIGRETTE(ToppingCategory.SAUCE, ToppingTier.INCLUDED),

    //                       Sides
    FRIES(ToppingCategory.SIDE, ToppingTier.INCLUDED),
    SALAD(ToppingCategory.SIDE, ToppingTier.INCLUDED);


    private final ToppingCategory category;
    private final ToppingTier tier;

    SandwichToppings(ToppingCategory category, ToppingTier tier) {
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