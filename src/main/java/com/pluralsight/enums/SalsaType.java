package com.pluralsight.enums;

import java.util.Arrays;

public enum SalsaType {
    SALSA_ROJA("Salsa Roja"),
    SALSA_VERDE("Salsa Verde"),
    PICO_DE_GALLO("Pico de Gallo"),
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
                .map(SalsaType::getDisplayName)
                .forEach(salsa -> System.out.println("◆ " + salsa));
    }
}