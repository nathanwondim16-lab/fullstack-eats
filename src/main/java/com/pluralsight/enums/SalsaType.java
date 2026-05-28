package com.pluralsight.enums;

import java.util.Arrays;

public enum SalsaType {
    SALSA_ROJA("Salsa Roja (Red Sauce)"),
    SALSA_VERDE("Salsa Verde (Green Sauce)"),
    PICO_DE_GALLO("Pico de Gallo (Salsa Fresca)"),
    FRUIT_AND_MANGO_SALSA("Fruit & Mango Salsa"),
    CHIPOTLE_SALSA("Chipotle Salsa");

    private final String displayName;

    SalsaType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static void getSalsaOptions() {
        Arrays.stream(SalsaType.values())
                .map(Enum::toString)
                .forEach(salsa -> System.out.println("◆ " + salsa));
    }
}