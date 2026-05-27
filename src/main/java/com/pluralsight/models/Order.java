package com.pluralsight.models;

import com.pluralsight.enums.Colors;
import com.pluralsight.interfaces.Chargeable;
import com.pluralsight.ui.UserInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Chargeable> order;
    private int orderNumber = 1;

    private final LocalDate orderDate;

    public Order(LocalDate orderDate) {
        order = new ArrayList<>();
        this.orderDate = orderDate;
        orderNumber++;
    }

    public List<Chargeable> getOrder() {
        return order;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void addItemToOrder(Chargeable item) {
        order.add(item);
    }

    public void removeItemFromOrder(Chargeable item) {
        if(!order.contains(item)) {
            UserInterface.printToConsole("Item doesn't exist so it cannot be removed", Colors.CRIMSON);
            return;
        }

        order.remove(item);
    }

    public void displayOrderDetails() {
        UserInterface.printToConsole("\nORDER DETAILS", Colors.GOLD);
        order.forEach(item -> {
            UserInterface.printDivider();
            item.orderDetails();
        });

        double total = order.stream().mapToDouble(Chargeable::getPrice).sum();

        UserInterface.printToConsoleFormatted("""
                
                TOTAL: $%.2f
                """, Colors.GREEN, total);
    }
}