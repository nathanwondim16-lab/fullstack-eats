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
                    4) Add Pizza
                    5) Add Garlic Knots
                    6) Add Taco
                    7) Add Chips & Salsa
                    8) Checkout
                    9) Edit Order
                    10) Remove Item From Order
                    0) Cancel Order
                    
                    Select Option ❯\s""");
            switch (userChoice) {
                case 1 -> order.addItemToOrder(DeliScreen.orderSandwich());
                case 2 -> order.addItemToOrder(DeliScreen.orderDrink());
                case 3 -> order.addItemToOrder(DeliScreen.orderChips());
                case 4 -> order.addItemToOrder(PizzeriaScreen.orderPizza());
                case 5 -> order.addItemToOrder(PizzeriaScreen.orderKnots());
                //case 6 -> order.addItemToOrder(); // Add Taco
                //case 7 -> order.addItemToOrder(); // Add Chips & Salsa
                case 8 -> {
                    order.displayOrderDetails();
                    int confirmOrCancel = UserInterface.promptForNumber("""
                            1) Confirm Order
                            2) Cancel Order
                            
                            Select Option ❯\s""");
                    switch(confirmOrCancel) {
                        case 1 -> {
                            receiptsFileManager.save(order);
                            UserInterface.confirmOrder();
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
                case 9 -> order.editOrder();
                case 10 -> {
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