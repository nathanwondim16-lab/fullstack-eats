package com.pluralsight.models;

public class Topping<T> {
    private final T type;
    private final boolean isExtra;

    public Topping(T type, boolean isExtra) {
        this.type = type;
        this.isExtra = isExtra;
    }

    public T getType() {
        return type;
    }

    public boolean isExtra() {
        return isExtra;
    }
}