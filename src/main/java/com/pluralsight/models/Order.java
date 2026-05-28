package com.pluralsight.models;

import com.pluralsight.enums.Colors;
import com.pluralsight.interfaces.Chargeable;
import com.pluralsight.ui.UserInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> order;
    private int itemID = 0;
    private static int orderID = 0;

    private final LocalDate orderDate;

    public Order(LocalDate orderDate) {
        order = new ArrayList<>();
        this.orderDate = orderDate;
        orderID++;
        itemID++;
    }

    public List<OrderItem> getOrder() {
        return order;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public static int getOrderID() {
        return orderID;
    }

    public int getItemID() {
        return itemID;
    }

    public void addItemToOrder(Chargeable item) {
        order.add(new OrderItem(itemID++, item));
    }

    public void removeItemFromOrder(int itemID) {
        for(OrderItem orderItem : order) {
            if(orderItem.getItemID() == itemID) {
                order.remove(orderItem);

                // Sorts items back in order by ID
                for(int i = 0; i < order.size(); i++) {
                    order.get(i).setItemID(i + 1);
                }

                UserInterface.printToConsole("\nITEM HAS BEEN REMOVED ❌", Colors.GREEN);
                return;
            }
        }

        UserInterface.printToConsole("CANNOT REMOVE ITEM SINCE IT DOESN'T EXIST IN ORDER ID: " + orderID, Colors.CRIMSON);
    }

    public void cancelOrder() {
        order.clear();
        orderID--;
    }

    public void editOrder() {
        UserInterface.printToConsole("\nHERE IS EVERYTHING YOU'VE ADDED TO YOUR ORDER SO FAR\n");
        displayOrderDetails();

        int itemID = UserInterface.promptForNumber("Enter the ID number of the item you wish to edit ❯ ");

        OrderItem item = order.stream().filter(orderItem -> orderItem.getItemID() == itemID).findFirst().orElse(null);

        if(item != null) {
            item.getItem().editItem();
        }
    }

    public void displayOrderDetails() {
        UserInterface.printToConsole("\nORDER ID: " + orderID + " DETAILS", Colors.GOLD);
        order.forEach(orderItem -> {
            UserInterface.printDivider();
            UserInterface.printToConsole("ITEM ID: " + orderItem.getItemID(), Colors.TRON);
            orderItem.getItem().orderDetails();
        });

        double total = order.stream().mapToDouble(orderItem -> orderItem.getItem().getPrice()).sum();

        UserInterface.printDivider();
        UserInterface.printToConsoleFormatted("""
                
                TOTAL: $%.2f
                """, Colors.GREEN, total);
    }
}