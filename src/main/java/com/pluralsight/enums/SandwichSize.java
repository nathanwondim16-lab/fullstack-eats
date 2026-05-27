package com.pluralsight.enums;

import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum SandwichSize {
    FOUR(4,5.50, 1, .50, .75, .30),
    EIGHT(8,7, 2, 1, 1.50, .60),
    TWELVE(12,8.50, 3, 1.50, 2.25, .90);

    private final int displaySize;
    private final double sandwichSizePrice;
    private final double meatPremiumToppingPrice;
    private final double meatExtraToppingPrice;
    private final double cheesePremiumToppingPrice;
    private final double cheeseExtraToppingPrice;

    SandwichSize(int displaySize, double sandwichSizePrice, double meatPremiumToppingPrice,
                 double extraToppingPrice, double cheesePremiumToppingPrice, double cheeseExtraToppingPrice) {
        this.displaySize = displaySize;
        this.sandwichSizePrice = sandwichSizePrice;
        this.meatPremiumToppingPrice = meatPremiumToppingPrice;
        this.meatExtraToppingPrice = extraToppingPrice;
        this.cheesePremiumToppingPrice = cheesePremiumToppingPrice;
        this.cheeseExtraToppingPrice = cheeseExtraToppingPrice;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public double getSandwichSizePrice() {
        return sandwichSizePrice;
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

    public double getToppingPrice(Topping<SandwichToppings> topping) {
        double price = 0;
        switch(topping.getType().getCategory()) {
            case MEAT -> price = topping.isExtra() ? meatPremiumToppingPrice + meatExtraToppingPrice : meatPremiumToppingPrice;
            case CHEESE -> price = topping.isExtra() ? cheesePremiumToppingPrice + cheeseExtraToppingPrice : cheesePremiumToppingPrice;
        }
        return price;
    }

    public static void getAllSizes() {
        Arrays.stream(SandwichSize.values()).map(SandwichSize::getDisplaySize).forEach(size -> System.out.println("◆ " + size + "\""));
    }
}