package com.pluralsight.models;

import com.pluralsight.enums.Colors;
import com.pluralsight.enums.ToppingCategory;
import com.pluralsight.formatters.ToppingFormatter;
import com.pluralsight.interfaces.Chargeable;
import com.pluralsight.interfaces.OrganizeToppings;
import com.pluralsight.ui.UserInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Food<T extends Enum<T> & OrganizeToppings> implements Chargeable {
    private final List<Topping<T>> toppings;

    public Food() {
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping<T> topping) {
        toppings.add(topping);
    }

    public void removeTopping(Topping<T> topping) {
        if(!toppings.contains(topping)) {
            UserInterface.printToConsole("Topping doesn't exist in your order", Colors.CRIMSON);
            return;
        }

        toppings.remove(topping);
    }

    public void displayToppings() {
        if(toppings.isEmpty()) {
            UserInterface.printToConsole("\t\t• No Toppings");
            return;
        }

        toppings.forEach(topping -> UserInterface.printToConsoleFormatted("""
                \t\t• %s %s
                """, topping.getType(), topping.isExtra() ? "(Extra)" : ""));
    }

    public void editToppings(Class<T> toppingEnum) {
        while(true) {
            UserInterface.printToConsole("\nCURRENT TOPPINGS", Colors.GOLD);
            displayToppings();
            UserInterface.printToConsole("What do you want to do?", Colors.GOLD);
            int choice = UserInterface.promptForNumber("""
                   
                    
                    1) Add Topping
                    2) Remove Topping
                    3) Change Extra
                    0) Done
                    
                    Select Option ❯\s""");

            switch(choice) {
                case 1 -> addToppingToItem(toppingEnum);
                case 2 -> removeToppingFromItem(toppingEnum);
                case 3 -> changeItemExtraStatus(toppingEnum);
                case 0 -> {
                    UserInterface.printToConsole("\nTOPPING CHANGES HAVE BEEN SAVED ✅", Colors.GREEN);
                    return;
                }

                default -> UserInterface.invalidOption();
            }
        }
    }

    private void addToppingToItem(Class<T> toppingEnum) {
        displayAvailableToppings(toppingEnum);

        T toppingType = promptForTopping(toppingEnum, "\nENTER TOPPING TO ADD ❯ ");

        boolean isExtra = UserInterface.promptForInput("Do you want extra " + toppingType + " on your sandwich? ").equalsIgnoreCase("yes");

        addTopping(new Topping<>(toppingType, isExtra));

        UserInterface.printToConsole("\nTOPPING HAS BEEN ADDED ✅", Colors.GREEN);
    }

    private void removeToppingFromItem(Class<T> toppingEnum) {
        T toppingType = promptForTopping(toppingEnum, "\nENTER TOPPING TO REMOVE ❯ ");

        Topping<T> toppingToRemove = findTopping(toppingType);

        if(toppingToRemove == null) {
            UserInterface.printToConsole("\nTHAT TOPPING IS NOT ON THIS ITEM", Colors.CRIMSON);
        }

        removeTopping(toppingToRemove);

        UserInterface.printToConsole("\nTOPPING HAS BEEN REMOVED ❌", Colors.GREEN);
    }

    private void changeItemExtraStatus(Class<T> toppingEnum) {
        T toppingType = promptForTopping(toppingEnum, "\nENTER TOPPING TO UPDATE EXTRA STATUS ❯ ");

        Topping<T> topping = findTopping(toppingType);

        if (topping == null) {
            UserInterface.printToConsole("\nTHIS TOPPING IS NOT ON THIS ITEM", Colors.CRIMSON);
            return;
        }

        topping.setExtra();

        UserInterface.printToConsole("\nEXTRA OPTION UPDATED ✅", Colors.GREEN);
    }

    private Topping<T> findTopping(T toppingType) {
        return toppings.stream()
                .filter(topping -> topping.getType() == toppingType)
                .findFirst()
                .orElse(null);
    }

    private T promptForTopping(Class<T> toppingEnum, String message) {
        return Enum.valueOf(toppingEnum, UserInterface.promptForInput(message).toUpperCase());
    }

    private void displayAvailableToppings(Class<T> toppingEnum) {
        UserInterface.printToConsole("\nAVAILABLE TOPPINGS", Colors.GOLD);

        Arrays.stream(ToppingCategory.values()).forEach(category -> ToppingFormatter.displayToppings(toppingEnum, category));
    }

    public List<Topping<T>> getToppings() {
        return toppings;
    }
}