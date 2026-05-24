package com.pluralsight.ui;

import com.pluralsight.enums.Colors;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OrderScreen {

    public static void startOrder() {
        while (true) {
            UserInterface.printDivider("=");
            int userChoice = UserInterface.promptForNumber("""
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order
                    
                    Select Option ❯\s""");

            switch (userChoice) {
                case 1 -> Deli.orderSandwich();
                case 0 -> {
                    UserInterface.printToConsole("\nORDER CANCELED ❌", Colors.CRIMSON);
                    return;
                }

                default -> UserInterface.invalidOption();
            }
        }
    }
}
