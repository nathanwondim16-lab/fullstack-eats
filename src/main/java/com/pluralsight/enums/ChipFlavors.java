package com.pluralsight.enums;

import java.util.Arrays;

public enum ChipFlavors {
    LAYS,
    DORITOS,
    RUFFLES,
    PRINGLES,
    SUN_CHIPS,
    CHEETOS,
    TAKIS;

    public static void displayFlavors() {
        Arrays.stream(ChipFlavors.values())
                .map(Enum::toString)
                .forEach(flavor -> System.out.println("◆ " + flavor));
    }
}