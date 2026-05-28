package com.pluralsight.enums;

import java.util.Arrays;

public enum BreadType {
    WHITE("White 🍞"),
    WHEAT("Wheat 🌾"),
    RYE("Rye 🥖"),
    WRAP("Wrap 🥬");

    private final String displayName;

    BreadType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static void getAllBreads() {
        Arrays.stream(BreadType.values())
                .map(type -> "◆ " + type.displayName)
                .forEach(System.out::println);
    }
}