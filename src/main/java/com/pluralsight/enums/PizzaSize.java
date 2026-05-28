package com.pluralsight.enums;

import com.pluralsight.models.Topping;

import java.util.Arrays;

public enum PizzaSize {

    EIGHT(8, 8.50, 1, .50, .75, .30),
    TWELVE(12, 12, 2, 1, 1.50, .60),
    SIXTEEN(16, 16.50, 3, 1.50, 2.25, .90);

    private final int displaySize;
    private final double pizzaSizePrice;
    private final double meatPremiumToppingPrice;
    private final double meatExtraToppingPrice;
    private final double cheesePremiumToppingPrice;
    private final double cheeseExtraToppingPrice;

    PizzaSize(int displaySize, double pizzaSizePrice, double meatPremiumToppingPrice,
              double meatExtraToppingPrice, double cheesePremiumToppingPrice,
              double cheeseExtraToppingPrice) {
        this.displaySize = displaySize;
        this.pizzaSizePrice = pizzaSizePrice;
        this.meatPremiumToppingPrice = meatPremiumToppingPrice;
        this.meatExtraToppingPrice = meatExtraToppingPrice;
        this.cheesePremiumToppingPrice = cheesePremiumToppingPrice;
        this.cheeseExtraToppingPrice = cheeseExtraToppingPrice;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public double getPizzaSizePrice() {
        return pizzaSizePrice;
    }

    public double getMeatPremiumToppingPrice() {
        return meatPremiumToppingPrice;
    }

    public double getMeatExtraToppingPrice() {
        return meatExtraToppingPrice;
    }

    public double getCheesePremiumToppingPrice() {
        return cheesePremiumToppingPrice;
    }

    public double getCheeseExtraToppingPrice() {
        return cheeseExtraToppingPrice;
    }

    public double getToppingPrice(Topping<PizzaToppings> topping) {
        double price = 0;
        switch(topping.getType().getCategory()) {
            case MEAT -> price = topping.isExtra() ? meatPremiumToppingPrice + meatExtraToppingPrice : meatPremiumToppingPrice;
            case CHEESE -> price = topping.isExtra() ? cheesePremiumToppingPrice + cheeseExtraToppingPrice : cheesePremiumToppingPrice;
        }
        return price;
    }

    public static void getAllSizes() {
        Arrays.stream(PizzaSize.values()).map(PizzaSize::getDisplaySize).forEach(size -> System.out.println("◆ " + size + "\""));
    }
}