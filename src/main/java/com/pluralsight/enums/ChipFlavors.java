package com.pluralsight.enums;

import java.util.Arrays;

public enum ChipFlavors {
    LAYS("Lays"),
    DORITOS("Doritos"),
    RUFFLES("Ruffles"),
    PRINGLES("Pringles"),
    SUN_CHIPS("Sun Chips"),
    CHEETOS("Cheetos"),
    HOT_CHEETOS("Hot Cheetos"),
    TAKIS("Takis");

    private final String displayName;

    ChipFlavors(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static void displayFlavors() {
        Arrays.stream(ChipFlavors.values())
                .forEach(flavor -> System.out.println("◆ " + flavor.getDisplayName()));
    }
}