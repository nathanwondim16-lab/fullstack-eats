package com.pluralsight.ui;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.SandwichSize;
import com.pluralsight.enums.SandwichToppings;
import com.pluralsight.enums.ToppingCategory;
import com.pluralsight.models.Food;
import com.pluralsight.models.Topping;

public class Deli {

    public static void orderSandwich() {

        UserInterface.printDivider("=");

        UserInterface.printToConsole("""
                                    _______________________
                                   /                      /|
                                  /______________________/ |
                                  |                      | |
                                  |   THE DELI COUNTER   | |
                                  |======================| |
                                  |                      | |
                                  |   🥪 🥪 🥪 🥪        | |
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

        String breadChoice = UserInterface.promptForInput("\nSelect bread ❯ ");

        UserInterface.printToConsole("\nCHOOSE SANDWICH SIZE 📏");

        UserInterface.printOnSameLine(SandwichSize.getAllSizes());

        String sandwichSize = UserInterface.promptForInput("\nSelect size ❯ ");

        UserInterface.printToConsole("\nTOPPINGS 🍗🌶️🧀🍅");

        for(ToppingCategory category : ToppingCategory.values()) {

            UserInterface.printToConsole("SELECT " + category.toString() + "S");
            SandwichToppings.displayToppings(category);

            while(true) {

                String topping = UserInterface.promptForInput("ENTER TOPPING ❯ ");

                String finished = UserInterface.promptForInput("Are you done adding " + category + "toppings to your sandwich ❯");

                if(finished.equalsIgnoreCase("yes")) {
                    break;
                }

            }
        }



    }
}
