package com.pluralsight.models;

public record Topping<T extends Enum<T>>(T type, boolean isExtra) {}