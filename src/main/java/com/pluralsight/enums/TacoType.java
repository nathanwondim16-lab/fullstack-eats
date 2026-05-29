package com.pluralsight.enums;

public enum TacoType {
    CORN("Corn Tortilla"),
    FLOUR("Flour Tortilla"),
    HARD_SHELL("Hard Shell Taco"),
    BOWL("Bowl");

    private final String displayName;

    TacoType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}