package com.pluralsight.models;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.Colors;
import com.pluralsight.enums.SandwichSize;
import com.pluralsight.enums.SandwichToppings;
import com.pluralsight.ui.UserInterface;

import java.util.Arrays;

public class Sandwich extends Food<SandwichToppings> {
    private BreadType breadType;
    private SandwichSize sandwichSize;
    private boolean isToasted;

    public Sandwich(BreadType breadType, SandwichSize sandwichSize, boolean isToasted) {
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.isToasted = isToasted;
    }

    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    @Override
    public double getPrice() {
        return sandwichSize.getSandwichSizePrice()
                + getToppings().stream()
                .mapToDouble(sandwichSize::getToppingPrice)
                .sum();
    }

    @Override
    public void editItem() {
        while(true) {
            UserInterface.printToConsole("WHAT DO YOU WANT TO CHANGE ABOUT YOUR SANDWICH?\n", Colors.GOLD);
            int option = UserInterface.promptForNumber("""
                    
                    1) Size
                    2) Bread
                    3) Toppings
                    4) Toasting
                    0) Done
                    
                    Select Option ❯\s""");

            switch(option) {
                case 1 -> changeSize();
                case 2 -> changeBread();
                case 3 -> editToppings(SandwichToppings.class);
                case 4 -> changeToastedStatus();
                case 0 -> {
                    UserInterface.printToConsole("\nCHANGES TO YOUR SANDWICH HAVE BEEN SAVED ✅", Colors.GREEN);
                    return;
                }

                default -> UserInterface.invalidOption();
            }
        }
    }

    private void changeSize() {
        UserInterface.printToConsole("\nWHICH SIZE DO YOU WANT TO CHANGE YOUR SANDWICH TO?", Colors.GOLD);

        SandwichSize.getAllSizes();

        int sizeChoice = UserInterface.promptForNumber("\nSANDWICH SIZE ❯ ");

        SandwichSize selectedSize = Arrays.stream(SandwichSize.values())
                .filter(size -> size.getDisplaySize() == sizeChoice)
                .findFirst()
                .orElse(null);

        if(selectedSize == null) {
            UserInterface.invalidOption();
            return;
        }

        sandwichSize = selectedSize;

        UserInterface.printToConsole("\nSIZE HAS BEEN CHANGED ✅", Colors.GREEN);
    }

    private void changeBread() {
        UserInterface.printToConsole("\nWHAT BREAD DO YOU WANT TO SWITCH TO?", Colors.GOLD);

        BreadType.getAllBreads();

        try {
            breadType = BreadType.valueOf(UserInterface.promptForInput("\n SELECT BREAD ❯ ").toUpperCase());

            UserInterface.printToConsole("\nBREAD HAS BEEN CHANGED ✅", Colors.GREEN);
        } catch (Exception e) {
            UserInterface.invalidOption();
        }
    }

    private void changeToastedStatus() {
        isToasted = !isToasted;

        UserInterface.printToConsole("\nSANDWICH IS NOW " + (isToasted ? "TOASTED ✅" : "NOT TOASTED ❌"), Colors.GREEN);
    }

    @Override
    public void orderDetails() {
        UserInterface.printToConsoleFormatted("""
                ◦ Custom Sandwich
                \t\t• %s" %s bread
                """, sandwichSize.getDisplaySize(), breadType);

        displayToppings();

        UserInterface.printToConsoleFormatted("""
                \t\t%s
                """, isToasted ? "• TOASTED" : "");

        UserInterface.printToConsole(String.format("""
                
                %-10s $%.2f""", "Price:", getPrice()), Colors.GREEN);
    }
}