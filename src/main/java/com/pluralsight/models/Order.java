package com.pluralsight.models;

import com.pluralsight.exceptions.EmptyOrderException;
import com.pluralsight.interfaces.Chargeable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> orderItems;
    private int itemID = 1;
    private final int orderID;
    private static int nextOrderID = 1;
    private final LocalDate orderDate;

    public Order(LocalDate orderDate) {
        orderItems = new ArrayList<>();
        this.orderID = nextOrderID++;
        this.orderDate = orderDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getItemID() {
        return itemID;
    }

    public void addItemToOrder(Chargeable item) {
        orderItems.add(new OrderItem(itemID++, item));
    }

    public boolean removeItemFromOrder(int itemID) {
        boolean removed = orderItems.removeIf(orderItem -> orderItem.getItemID() == itemID);

        if(removed) {
            resetItemIDs();
        }

        return removed;
    }

    public void cancelOrder() {
        orderItems.clear();
    }

    public double getTotal() {
        return orderItems.stream()
                .mapToDouble(item -> item.getItem().getPrice())
                .sum();
    }

    public boolean isEmpty() {
        return orderItems.isEmpty();
    }

    public void validateOrder() {
        if(isEmpty()) {
            throw new EmptyOrderException("CANNOT CHECKOUT AN EMPTY ORDER ❌");
        }
    }

    private void resetItemIDs() {
        // Sorts items back in order by ID
        for(int i = 0; i < orderItems.size(); i++) {
            orderItems.get(i).setItemID(i + 1);
        }

        itemID = orderItems.size() + 1;
    }
}