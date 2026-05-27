package com.pluralsight.ui;

import com.pluralsight.enums.Colors;
import com.pluralsight.io.ReceiptsFileManager;
import com.pluralsight.models.Order;

import java.time.LocalDate;

public class OrderScreen {

    public static void startOrder() {

        Order order = new Order(LocalDate.now());
        ReceiptsFileManager receiptsFileManager = new ReceiptsFileManager();

        while (true) {
            UserInterface.printDivider();
            int userChoice = UserInterface.promptForNumber("""
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    5) Edit Order
                    6) Remove Item From Order
                    0) Cancel Order
                    
                    Select Option ❯\s""");
            switch (userChoice) {
                case 1 -> order.addItemToOrder(Deli.orderSandwich());
                case 2 -> order.addItemToOrder(Deli.orderDrink());
                case 3 -> order.addItemToOrder(Deli.orderChips());
                case 4 -> {
                    order.displayOrderDetails();
                    int confirmOrCancel = UserInterface.promptForNumber("""
                            1) Confirm Order
                            2) Cancel Order
                            
                            Select Option ❯\s""");
                    switch(confirmOrCancel) {
                        case 1 -> {
                            receiptsFileManager.save(order);
                            return;
                        }
                        case 2 -> {
                            order.cancelOrder();
                            UserInterface.printToConsole("\nORDER CANCELED ❌", Colors.GREEN);
                            return;
                        }

                        default -> UserInterface.invalidOption();
                    }
                }
                case 5 -> order.editOrder();
                case 6 -> {
                    int itemID = UserInterface.promptForNumber("Enter the ID number of the item you wish to remove ❯ ");
                    order.removeItemFromOrder(itemID);
                }
                case 0 -> {
                    order.cancelOrder();
                    UserInterface.printToConsole("\nORDER CANCELED ❌", Colors.GREEN);
                    return;
                }

                default -> UserInterface.invalidOption();
            }
        }
    }
}