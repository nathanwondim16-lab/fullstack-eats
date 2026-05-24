package com.pluralsight.enums;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum BreadType {
    WHITE,
    WHEAT,
    RYE,
    WRAP;

    public static String getAllBreads() {
        return Arrays.stream(BreadType.values()).map(Enum::toString).collect(Collectors.joining(", "));
    }
}