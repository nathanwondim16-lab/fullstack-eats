package com.pluralsight.enums;

import java.util.Arrays;

public enum KnotsType {
    GARLIC("Garlic"),
    STUFFED("Stuffed"),
    BUFFALO("Buffalo"),
    LAMINATED("Laminated");

    private final String displayName;

    KnotsType(String name) {
        this.displayName = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static void displayKnots() {
        Arrays.stream(KnotsType.values())
                .map(KnotsType::getDisplayName)
                .forEach(choice -> System.out.println("◆ " + choice));
    }
}