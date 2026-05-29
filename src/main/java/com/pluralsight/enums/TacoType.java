package com.pluralsight.enums;

import com.pluralsight.ui.UserInterface;

import java.util.Arrays;

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

    public static void getTacoOptions() {
        Arrays.stream(TacoType.values())
                .forEach(type -> UserInterface.printToConsole("◆ " + type.getDisplayName()));
    }
}