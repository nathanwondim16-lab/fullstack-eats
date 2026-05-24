package com.pluralsight.models;

import java.time.LocalDate;

public class Order {
    private final Food<?> meal;
    private final LocalDate orderDate;

    public Order(Food<?> meal, LocalDate orderDate) {
        this.meal = meal;
        this.orderDate = orderDate;
    }

    public Food getMeal() {
        return meal;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
