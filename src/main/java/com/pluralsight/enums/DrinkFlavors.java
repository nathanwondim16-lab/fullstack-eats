package com.pluralsight.enums;

import java.util.Arrays;

public enum DrinkFlavors {

    // SODAS
    SPRITE("McDonald's Sprite"),
    COCA_COLA("Coca Cola"),
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

    public static void displayFlavors() {
        Arrays.stream(DrinkFlavors.values())
                .map(DrinkFlavors::getFlavor)
                .forEach(flavor -> System.out.println("◆ " + flavor));
    }
}