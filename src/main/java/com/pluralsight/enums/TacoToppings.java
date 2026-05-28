package com.pluralsight.enums;

import com.pluralsight.interfaces.OrganizeToppings;

public enum TacoToppings implements OrganizeToppings {

    /*
    PREMIUM

                            Meats:
    */
    CARNE_ASADA(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    AL_PASTOR(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    CARNITAS(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    POLLO(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    CHORIZO(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    PESCADO(ToppingCategory.MEAT, ToppingTier.PREMIUM),


    //                      Cheeses
    QUESO_FRESCO(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    OAXACA(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    COTIJA(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    CHEDDAR(ToppingCategory.CHEESE, ToppingTier.PREMIUM),

    /*
    REGULAR


                     Other toppings
    */
    LETTUCE(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    CILANTRO(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    ONIONS(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    TOMATOES(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    JALAPENOS(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    RADISHES(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    PICO_DE(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    GUACAMOLE(ToppingCategory.REGULAR, ToppingTier.INCLUDED),
    CORN(ToppingCategory.REGULAR, ToppingTier.INCLUDED),

    //                       Sauces
    SALSA_VERDE(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    SALSA_ROJA(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    CHIPOTLE(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    HABANERO(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    MILD(ToppingCategory.SAUCE, ToppingTier.INCLUDED),
    EXTRA_HOT(ToppingCategory.SAUCE, ToppingTier.INCLUDED),

    //                       Sides
    LIME_WEDGES(ToppingCategory.SIDE, ToppingTier.INCLUDED),
    CREMA(ToppingCategory.SIDE, ToppingTier.INCLUDED);

    private final ToppingCategory category;
    private final ToppingTier tier;

    TacoToppings(ToppingCategory category, ToppingTier tier) {
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