package com.pluralsight.models;

import java.time.LocalDate;

public class Order {
    private final Food<?> meal;
    private final Drink drink;

    private final LocalDate orderDate;

    public Order(Food<?> meal, Drink drink, LocalDate orderDate) {
        this.meal = meal;
        this.drink = drink;
        this.orderDate = orderDate;
    }

    public Food<?> getMeal() {
        return meal;
    }

    public Drink getDrink() {
        return drink;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}