package com.pluralsight.models;

import com.pluralsight.enums.*;
import com.pluralsight.ui.UserInterface;

import java.util.Arrays;

public class Pizza extends Food<PizzaToppings> {
    private CrustType crustType;
    private PizzaSize pizzaSize;
    private boolean isCrustStuffed;

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
    public void editItem() {
        while(true) {
            UserInterface.printDivider();
            UserInterface.printToConsole("\nWHAT DO YOU WANT TO CHANGE ABOUT YOUR PIZZA?\n", Colors.GOLD);
            int option = UserInterface.promptForNumber("""
                    
                    1) Size
                    2) Crust
                    3) Toppings
                    4) Stuffed Crust
                    0) Done
                    
                    Select Option ❯\s""");

            UserInterface.printDivider();

            switch(option) {
                case 1 -> changeSize();
                case 2 -> changeCrust();
                case 3 -> editToppings(PizzaToppings.class);
                case 4 -> changeStuffedCrustStatus();
                case 0 -> {
                    UserInterface.printToConsole("\nCHANGES TO YOUR PIZZA HAVE BEEN SAVED ✅", Colors.GREEN);
                    return;
                }

                default -> UserInterface.invalidOption();
            }
        }
    }

    private void changeSize() {
        UserInterface.printToConsole("\nWHICH SIZE DO YOU WANT TO CHANGE YOUR PIZZA TO?", Colors.GOLD);

        PizzaSize.getAllSizes();

        int sizeChoice = UserInterface.promptForNumber("\nPIZZA SIZE ❯ ");

        PizzaSize selectedSize = Arrays.stream(PizzaSize.values())
                .filter(size -> size.getDisplaySize() == sizeChoice)
                .findFirst()
                .orElse(null);

        if(selectedSize == null) {
            UserInterface.invalidOption();
            return;
        }

        pizzaSize = selectedSize;

        UserInterface.printToConsole("\nSIZE HAS BEEN CHANGED ✅", Colors.GREEN);
    }

    private void changeCrust() {
        UserInterface.printToConsole("\nWHICH CRUST DO YOU WANT TO SWITCH TO?", Colors.GOLD);

        CrustType.getAllCrusts();

        try {
            crustType = CrustType.valueOf(UserInterface.promptForInput("\nSELECT CRUST ❯ ").toUpperCase());

            UserInterface.printToConsole("\nCRUST HAS BEEN CHANGED ✅", Colors.GREEN);
        } catch (Exception e) {
            UserInterface.invalidOption();
        }
    }

    private void changeStuffedCrustStatus() {
        isCrustStuffed = !isCrustStuffed;

        UserInterface.printToConsole("\nPIZZA CRUST IS " + (isCrustStuffed ? "STUFFED ✅" : "NO LONGER STUFFED ❌"), Colors.GREEN);
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
}