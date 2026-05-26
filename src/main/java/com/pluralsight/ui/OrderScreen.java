package com.pluralsight.ui;

import com.pluralsight.enums.Colors;
import com.pluralsight.models.Order;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class OrderScreen {

    public static void startOrder() {

        Order order = new Order(LocalDate.now());

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
                case 1 -> order.addItemToOrder(Deli.orderSandwich());
                case 2 -> order.addItemToOrder(Deli.orderDrink());
                case 3 -> order.addItemToOrder(Deli.orderChips());
                //case 4 -> Checkout goes here
                case 0 -> {
                    UserInterface.printToConsole("\nORDER CANCELED ❌", Colors.CRIMSON);
                    return;
                }

                default -> UserInterface.invalidOption();
            }
        }
    }
}