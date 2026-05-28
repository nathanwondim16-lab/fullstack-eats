package com.pluralsight.enums;

import com.pluralsight.models.Topping;

import java.util.Arrays;

public enum TacoChoices {
    SINGLE("Single taco",3.50, 1, .50, .75, .30),
    THREE_TACO("3-Taco",9, 2, 1, 1.50, .60),
    BURRITO("Burrito",8.50, 3, 1.50, 2.25, .90);

    private final String displayName;
    private final double tacoChoicePrice;
    private final double meatPremiumToppingPrice;
    private final double meatExtraToppingPrice;
    private final double cheesePremiumToppingPrice;
    private final double cheeseExtraToppingPrice;

    TacoChoices(String displayName, double tacoChoicePrice, double meatPremiumToppingPrice,
                double meatExtraToppingPrice, double cheesePremiumToppingPrice, double cheeseExtraToppingPrice) {
        this.displayName = displayName;
        this.tacoChoicePrice = tacoChoicePrice;
        this.meatPremiumToppingPrice = meatPremiumToppingPrice;
        this.meatExtraToppingPrice = meatExtraToppingPrice;
        this.cheesePremiumToppingPrice = cheesePremiumToppingPrice;
        this.cheeseExtraToppingPrice = cheeseExtraToppingPrice;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getTacoChoicePrice() {
        return tacoChoicePrice;
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

    public double getToppingPrice(Topping<TacoToppings> topping) {
        double price = 0;
        switch(topping.getType().getCategory()) {
            case MEAT -> price = topping.isExtra() ? meatPremiumToppingPrice + meatExtraToppingPrice : meatPremiumToppingPrice;
            case CHEESE -> price = topping.isExtra() ? cheesePremiumToppingPrice + cheeseExtraToppingPrice : cheesePremiumToppingPrice;
        }
        return price;
    }

    public static void getAllChoices() {
        Arrays.stream(TacoChoices.values())
                .map(TacoChoices::getDisplayName)
                .forEach(size -> System.out.println("◆ " + size));
    }
}