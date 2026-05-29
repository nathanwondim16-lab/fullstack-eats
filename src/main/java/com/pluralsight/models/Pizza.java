package com.pluralsight.models;

import com.pluralsight.enums.Colors;
import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.PizzaSize;
import com.pluralsight.enums.PizzaToppings;
import com.pluralsight.ui.UserInterface;

public class Pizza extends Food<PizzaToppings> {
    private final CrustType crustType;
    private final PizzaSize pizzaSize;
    private final boolean isCrustStuffed;

    public Pizza(CrustType crustType, PizzaSize pizzaSize, boolean isCrustStuffed) {
        this.crustType = crustType;
        this.pizzaSize = pizzaSize;
        this.isCrustStuffed = isCrustStuffed;
    }

    public CrustType getCrustType() {
        return crustType;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public boolean isCrustStuffed() {
        return isCrustStuffed;
    }

    @Override
    public double getPrice() {
        return pizzaSize.getPizzaSizePrice()
                + getToppings().stream()
                .mapToDouble(pizzaSize::getToppingPrice)
                .sum();
    }

    @Override
    public void orderDetails() {
        UserInterface.printToConsoleFormatted("""
                ◦ Custom Pizza
                \t\t• %s" %s crust
                """, pizzaSize.getDisplaySize(), crustType);

        displayToppings();

        UserInterface.printToConsoleFormatted("""
                \t\t%s
                """, isCrustStuffed ? "• STUFFED CRUST" : "");

        UserInterface.printToConsole(String.format("""
                
                %-10s $%.2f
                """, "Price:", getPrice()), Colors.GREEN);
    }

    @Override
    public void editItem() {

    }
}