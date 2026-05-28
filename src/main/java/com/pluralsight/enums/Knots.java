package com.pluralsight.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Knots {
    GARLIC("Garlic Knots"),
    STUFFED("Stuffed Knots"),
    BUFFALO("Buffalo Knots"),
    LAMINATED("Laminated Knots");

    private final String displayName;

    Knots(String name) {
        this.displayName = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static String displayKnots() {
        return Arrays.stream(Knots.values()).map(Enum::toString).collect(Collectors.joining(", "));
    }
}