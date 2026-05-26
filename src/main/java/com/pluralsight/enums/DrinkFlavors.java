package com.pluralsight.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum DrinkFlavors {

    // SODAS
    SPRITE("Sprite"),
    COCA_COLA("Coca-Cola"),
    FANTA("Fanta"),
    PEPSI("Pepsi"),
    DR_PEPPER("Dr Pepper"),
    MOUNTAIN_DEW("Mountain Dew");

    private final String flavor;

    DrinkFlavors(String flavor) {
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public static String displayFlavors() {
        return Arrays.stream(DrinkFlavors.values()).map(DrinkFlavors::getFlavor).collect(Collectors.joining(", "));
    }
}