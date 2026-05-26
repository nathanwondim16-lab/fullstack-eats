package com.pluralsight.models;

import com.pluralsight.interfaces.Chargeable;
import com.pluralsight.ui.UserInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Chargeable> order;

    private final LocalDate orderDate;

    public Order(LocalDate orderDate) {
        order = new ArrayList<>();
        this.orderDate = orderDate;
    }

    public List<Chargeable> getOrder() {
        return order;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void addItemToOrder(Chargeable item) {
        order.add(item);
    }

    public void removeItemFromOrder(Chargeable item) {
        if(!order.contains(item)) {
            UserInterface.printToConsole("Item doesn't exists so it cannot be removed");
            return;
        }

        order.remove(item);
    }

    public void displayOrderDetails() {

    }
}