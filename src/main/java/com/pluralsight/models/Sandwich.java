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
        return sandwichSize.getSandwichSizePrice() + getToppings().stream().mapToDouble(sandwichSize::getToppingPrice).sum();
    }

    @Override
    public void editOrder() {
        while(true) {
            int option = UserInterface.promptForNumber("""
                
                What do you want to change about your sandwich?
                
                1) size
                2) bread
                3) toppings
                4) toasting
                
                Select Option ❯\s""");

            switch(option) {
                case 1 -> {
                    UserInterface.printToConsole("\nWhat size do you want to change your sandwich to?", Colors.GOLD);

                    SandwichSize.getAllSizes();

                    int sizeChoice = UserInterface.promptForNumber("\nSANDWICH SIZE ❯ ");

                    sandwichSize = Arrays.stream(SandwichSize.values())
                            .filter(size -> size.getDisplaySize() == sizeChoice).findFirst().orElse(null);
                }

                case 2 -> {
                    UserInterface.printToConsole("\nWhat bread do you want to switch to?", Colors.GOLD);

                    BreadType.getAllBreads();

                    breadType = BreadType.valueOf(UserInterface.promptForInput("\nSELECT BREAD ❯ ").toUpperCase());
                }

                case 3 -> {
                    for(Topping<SandwichToppings> topping : getToppings()) {

                        UserInterface.printToConsole("Topping: " + topping.getType().name());

                        String changeTopping = UserInterface.promptForInput("Do you want to change this topping? ❯ ");

                        if(changeTopping.equalsIgnoreCase("yes")) {
                            int choice = UserInterface.promptForNumber("""
                                    
                                    1) Remove topping
                                    2) Remove extra amount
                                    3) Remove and add different topping
                                    
                                    Select Option ❯\s""");

                            switch(choice) {
                                case 1 -> removeTopping(topping);
                                case 2 -> topping.setExtra();
                                case 3 -> {
                                    removeTopping(topping);

                                    SandwichToppings newTopping = SandwichToppings.valueOf(UserInterface.promptForInput("Enter new topping ❯ ").toUpperCase());

                                    boolean isExtra = UserInterface.promptForInput("Do you want extra " + newTopping + " on your sandwich? ").equalsIgnoreCase("yes");

                                    Topping<SandwichToppings> changedTopping = new Topping<>(newTopping, isExtra);

                                    addTopping(changedTopping);
                                }
                            }
                        }
                    }
                }

                case 4 -> {
                    isToasted = !isToasted;
                }
            }

            String changeMore = UserInterface.promptForInput("Is there anything else you want to change? (Yes) or (No) ❯ ");

            if(changeMore.equalsIgnoreCase("no")) {
                break;
            }

        }
    }

    @Override
    public void orderDetails() {
        UserInterface.printToConsoleFormatted("""
                ◦ Custom Sandwich
                \t\t• %s" %s bread
                """, sandwichSize.getDisplaySize(), breadType);

        getToppings().forEach(topping -> UserInterface.printToConsoleFormatted("""
                \t\t• %s %s
                """, topping.getType(), topping.isExtra() ? "(Extra)" : ""));

        String toasted = isToasted ? "Toasted" : "Not toasted";

        UserInterface.printToConsoleFormatted("\t\t• " + toasted);
    }
}