package com.pluralsight.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ChipFlavors {
    LAYS,
    DORITOS,
    RUFFLES,
    PRINGLES,
    SUN_CHIPS,
    CHEETOS,
    TAKIS;

    public static String displayFlavors() {
        return Arrays.stream(ChipFlavors.values()).map(Enum::toString).collect(Collectors.joining(", "));
    }
}