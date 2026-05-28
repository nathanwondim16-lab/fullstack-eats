package com.pluralsight.ui;

import com.pluralsight.enums.Colors;
import com.pluralsight.exceptions.InvalidMenuSelectionException;
import com.pluralsight.io.ReceiptsFileManager;
import com.pluralsight.models.Order;
import com.pluralsight.services.OrderService;

import java.time.LocalDate;

public class OrderScreen {
    private static final OrderService orderService = new OrderService();
    private static final ReceiptsFileManager receiptsFileManager = new ReceiptsFileManager();

    public static void startOrder() {
        Order order = new Order(LocalDate.now());

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
                case 6 -> order.addItemToOrder(TacoTruckScreen.orderTaco()); // Add Taco
                case 7 -> order.addItemToOrder(TacoTruckScreen.orderChipsAndSalsa());
                case 8 -> {
                    if(handleCheckout(order)) {
                        return;
                    }
                }
                case 9 -> handleEditOrder(order);
                case 10 -> handleRemoveItem(order);
                case 0 -> {
                    order.cancelOrder();
                    UserInterface.printToConsole("\nORDER CANCELED ❌", Colors.GREEN);
                    return;
                }

                default -> UserInterface.invalidOption();
            }
        }
    }

    private static boolean handleCheckout(Order order) {
        try {
            order.validateOrder();

            orderService.displayOrderDetails(order);

            int confirmOrCancel = UserInterface.promptForNumber("""
                                    1) Confirm Order
                                    2) Cancel Order
                                    
                                    Select Option ❯\s""");
            switch (confirmOrCancel) {
                case 1 -> {
                    receiptsFileManager.save(order);
                    UserInterface.confirmOrder();
                    return true;
                }
                case 2 -> {
                    order.cancelOrder();
                    UserInterface.printToConsole("\nORDER CANCELED ❌", Colors.GREEN);
                    return true;
                }

                default -> {
                    UserInterface.invalidOption();
                    return false;
                }
            }
        } catch (RuntimeException e) {
            UserInterface.handleException(e);
            return false;
        }
    }

    private static void handleEditOrder(Order order) {
        try {
            order.validateOrder();
            orderService.editOrder(order);
        } catch(RuntimeException e) {
            UserInterface.handleException(e);
        }
    }

    private static void handleRemoveItem(Order order) {
        try {
            order.validateOrder();

            int itemID = UserInterface.promptForNumber("Enter the ID number of the item you wish to remove ❯ ");

            orderService.removeItemFromOrder(order, itemID);
        } catch (RuntimeException e) {
            UserInterface.handleException(e);
        }
    }
}