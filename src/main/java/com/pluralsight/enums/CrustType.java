package com.pluralsight.enums;

import java.util.Arrays;

public enum CrustType {
    THIN("Thin 🫓"),
    REGULAR("Regular 🍕"),
    THICK("Thick 🍕"),
    CAULIFLOWER("Cauliflower 🥦");

    private final String displayName;

    CrustType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static void getAllCrusts() {
        Arrays.stream(CrustType.values())
                .map(type -> "◆ " + type.displayName)
                .forEach(System.out::println);
    }
}