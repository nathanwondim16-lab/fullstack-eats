package com.pluralsight.models;

public class Topping<T extends Enum<T>> {
    private final T type;
    private boolean isExtra;

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

    void setExtra() {
        isExtra = false;
    }
}