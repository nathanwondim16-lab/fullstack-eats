package com.pluralsight.ui;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.SandwichSize;
import com.pluralsight.enums.SandwichToppings;
import com.pluralsight.enums.ToppingCategory;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Topping;

import java.util.ArrayList;
import java.util.List;

public class Deli {

    public static void orderSandwich() {

        UserInterface.printDivider("=");

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

        UserInterface.printToConsole("\nCHOOSE A BREAD 🍞");

        UserInterface.printOnSameLine(BreadType.getAllBreads());

        BreadType breadChoice = BreadType.valueOf(UserInterface.promptForInput("\nSelect bread ❯ ").toUpperCase());

        UserInterface.printToConsole("\nCHOOSE SANDWICH SIZE 📏");

        UserInterface.printOnSameLine(SandwichSize.getAllSizes());

        SandwichSize sandwichSize = SandwichSize.valueOf(UserInterface.promptForInput("\nSelect size ❯ ").toUpperCase());

        String isToasted = UserInterface.promptForInput("Do you want your sandwich toasted ❯ ");

        Sandwich sandwich = new Sandwich(breadChoice, sandwichSize, isToasted.equalsIgnoreCase("yes"));

        UserInterface.printToConsole("\nTOPPINGS 🍗🌶️🧀🍅");

        for(ToppingCategory category : ToppingCategory.values()) {


            UserInterface.printToConsole("SELECT " + category.toString() + "TOPPINGS");

            while(true) {
                SandwichToppings.displayToppings(category);

                // Give users the option to enter no if they don't want to add any toppings
                String topping = UserInterface.promptForInput("ENTER TOPPING OR SAY SKIP ❯ ").toUpperCase();

                if(topping.equalsIgnoreCase("skip")) {
                    break;
                }


                String isExtra = UserInterface.promptForInput("Do you want extra on your sandwich? ");

                String finished = UserInterface.promptForInput("Are you done adding " + category + "S to your sandwich ❯");

                sandwich.addTopping(new Topping<>(SandwichToppings.valueOf(topping), isExtra.equalsIgnoreCase("yes")));

                if(finished.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }

        UserInterface.printToConsole("HERE ARE YOU SANDWICH DETAILS: \n");

        UserInterface.printToConsole(String.format("""
                Bread: %s
                Sandwich size: %s
                
                Toppings: %s
                
                Total: $%.2f
                """,
                sandwich.getBreadType(),
                sandwich.getSandwichSize().getDisplaySize(),
                sandwich.getToppings().toString(),
                sandwich.getPrice())
        );
    }
}
