package com.pluralsight.services;

import com.pluralsight.enums.Colors;
import com.pluralsight.models.Order;
import com.pluralsight.models.OrderItem;
import com.pluralsight.ui.UserInterface;

public class OrderService {

    public void removeItemFromOrder(Order order, int itemID) {
        boolean removed = order.removeItemFromOrder(itemID);

        if(removed) {
            UserInterface.printToConsole("\nITEM HAS BEEN REMOVED ❌", Colors.GREEN);
        } else {
            UserInterface.printToConsole("CANNOT REMOVE ITEM SINCE IT DOESN'T EXIST IN ORDER ID: " + order.getOrderID(), Colors.CRIMSON);
        }
    }

    public void editOrder(Order order) {
        UserInterface.printToConsole("\nHERE IS EVERYTHING YOU'VE ADDED TO YOUR ORDER SO FAR\n");

        displayOrderDetails(order);

        int itemID = UserInterface.promptForNumber("Enter the ID number of the item you wish to edit ❯ ");

        OrderItem item = order.getOrderItems().stream()
                .filter(orderItem -> orderItem.getItemID() == itemID)
                .findFirst()
                .orElse(null);

        if(item != null) {
            item.getItem().editItem();
        }
    }

    public void displayOrderDetails(Order order) {
        UserInterface.printDivider();

        UserInterface.printToConsole("\nORDER ID: " + order.getOrderID() + " DETAILS", Colors.GOLD);
        order.getOrderItems().forEach(orderItem -> {
            UserInterface.printDivider();

            UserInterface.printToConsole("ITEM " + orderItem.getItemID() + ":", Colors.TRON);

            orderItem.getItem().orderDetails();
        });

        double total = order.getOrderItems().stream()
                .mapToDouble(orderItem -> orderItem.getItem().getPrice())
                .sum();

        UserInterface.printDivider();

        UserInterface.printToConsoleFormatted("""
                
                TOTAL: $%.2f
                """, Colors.GREEN, total);

        UserInterface.printDivider();
    }
}
