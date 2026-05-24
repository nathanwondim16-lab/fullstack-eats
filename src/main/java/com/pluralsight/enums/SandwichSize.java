package com.pluralsight.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum SandwichSize {
    FOUR("4\"",5.50),
    EIGHT("8\"",7),
    TWELVE("12\"",8.50);

    private final String displaySize;
    private final double price;

    SandwichSize(String displaySize, double price) {
        this.displaySize = displaySize;
        this.price = price;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public double getPrice() {
        return price;
    }

    public static String getAllSizes() {
        return Arrays.stream(SandwichSize.values()).map(SandwichSize::getDisplaySize).collect(Collectors.joining(", "));
    }
 }