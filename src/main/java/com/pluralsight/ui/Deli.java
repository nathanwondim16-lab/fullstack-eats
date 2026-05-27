package com.pluralsight.ui;

import com.pluralsight.enums.*;
import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;

import java.util.ArrayList;
import java.util.List;

public class Deli {

    public static Sandwich orderSandwich() {

        UserInterface.printDivider();

        UserInterface.printToConsole("""
                  ________________________
                 /                      /|
                /______________________/ |
                |                      | |
                |   THE DELI COUNTER   | |
                |======================| |
                |                      | |
                |   🥪 🥪 🥪 🥪       | |
                |                      | |
                |  Fresh Ingredients   | |
                |  Fresh Bread Daily   | |
                |  Made To Order       | |
                |______________________|/
                
                
                ╔═══════════════════════════════╗
                ║      CUSTOMER FAVORITES       ║
                ╠═══════════════════════════════╣
                ║  🥓 Bacon Ranch Melt          ║
                ║  🥩 Steak & Cheese Supreme    ║
                ║  🥪 Triple Stack Club         ║
                ║  🌶️ Spicy Chipotle Chicken    ║
                ╚═══════════════════════════════╝
                """);

        UserInterface.printOnSameLine(BreadType.getAllBreads());

        BreadType breadChoice = BreadType.valueOf(UserInterface.promptForInput("\nSelect your bread ❯ ").toUpperCase());

        UserInterface.printOnSameLine(SandwichSize.getAllSizes());

        SandwichSize sandwichSize = SandwichSize.valueOf(UserInterface.promptForInput("\nSandwich size ❯ ").toUpperCase());

        UserInterface.printToConsole("\nTOPPINGS 🍗🌶️🧀🍅");

        List<Topping<SandwichToppings>> toppings = new ArrayList<>();

        for(ToppingCategory category : ToppingCategory.values()) {

            while(true) {
                SandwichToppings.displayToppings(category);

                // Give users the option to enter no if they don't want to add any toppings
                String toppingChoice = UserInterface.promptForInput("ENTER TOPPING OR SAY SKIP ❯ ").toUpperCase();

                if(toppingChoice.equalsIgnoreCase("skip")) {
                    break;
                }

                // Asks user if they want extra of X topping.
                boolean isExtra = UserInterface.promptForInput("Do you want extra " + toppingChoice + " on your sandwich? ").equalsIgnoreCase("yes");

                String finished = UserInterface.promptForInput("Are you done adding " + (category + "s to your sandwich ❯ ").toLowerCase());

                // Adds topping to the list of toppings
                toppings.add(new Topping<>(SandwichToppings.valueOf(toppingChoice), isExtra));

                if(finished.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }

        boolean isToasted = UserInterface.promptForInput("Do you want your sandwich toasted ❯ ").equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(breadChoice, sandwichSize, isToasted);

        toppings.forEach(sandwich::addTopping);

        return sandwich;
    }

    public static Drink orderDrink() {
        UserInterface.printToConsole("\nCHOOSE A DRINK BELOW");

        UserInterface.printToConsole(DrinkFlavors.displayFlavors());

        DrinkFlavors flavor = DrinkFlavors.valueOf(UserInterface.promptForInput("Select flavor ❯ ").toUpperCase());

        UserInterface.printToConsole("\nCHOOSE A SIZE");

        UserInterface.printToConsole(DrinkSize.displayDrinkSizes());

        DrinkSize drinkSize = DrinkSize.valueOf(UserInterface.promptForInput("Select size ❯ ").toUpperCase());

        return new Drink(flavor, drinkSize);
    }

    public static Chips orderChips() {
        UserInterface.printToConsole("\nWHAT CHIPS WOULD YOU LIKE");

        UserInterface.printToConsole(ChipFlavors.displayFlavors());

        ChipFlavors chips = ChipFlavors.valueOf(UserInterface.promptForInput("Select flavor ❯ ").toUpperCase());

        return new Chips(chips);
    }
}