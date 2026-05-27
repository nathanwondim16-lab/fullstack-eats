package com.pluralsight.ui;

import com.pluralsight.enums.*;
import com.pluralsight.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deli {

    public static Sandwich orderSandwich() {

        UserInterface.printDivider();

        UserInterface.printToConsoleFormatted("""
                ╔════════════════════════╗
                ║   FULLSTACK DELI       ║
                ║════════════════════════║
                ║ 🥓  Ham & Bacon        ║
                ║ 🧀 Swiss & Cheddar     ║
                ║ 🥬 Fresh Veggies       ║
                ║ 🔥 Toasted Subs        ║
                ║                        ║
                ║  ★ CODE. EAT. REPEAT ★ ║
                ╚════════════════════════╝
                """, Colors.ORANGE_JUICE);

        UserInterface.printToConsole("\n⦿ BREAD OPTIONS:\n", Colors.GOLD);

        BreadType breadChoice;
        SandwichSize sandwichSize;

        while(true) {
            try {
                BreadType.getAllBreads();

                breadChoice = BreadType.valueOf(UserInterface.promptForInput("\nSELECT BREAD ❯ ").toUpperCase());

                UserInterface.printToConsole("\n⦿ BREAD SIZES:\n", Colors.GOLD);

                SandwichSize.getAllSizes();

                int sizeChoice = UserInterface.promptForNumber("\nSANDWICH SIZE ❯ ");

                sandwichSize = Arrays.stream(SandwichSize.values())
                        .filter(size -> size.getDisplaySize() == sizeChoice).findFirst().orElse(null);

                break;
            } catch (Exception e) {
                UserInterface.invalidOption();
            }
        }

        UserInterface.printToConsole("\n⦿ TOPPINGS:", Colors.GOLD);

        List<Topping<SandwichToppings>> toppings = new ArrayList<>();

        for(ToppingCategory category : ToppingCategory.values()) {

            while(true) {
                UserInterface.printDivider();
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

        boolean isToasted = UserInterface.promptForInput("\nDo you want your sandwich toasted ❯ ").equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(breadChoice, sandwichSize, isToasted);

        toppings.forEach(sandwich::addTopping);

        UserInterface.printToConsole("\nSANDWICH ADDED TO ORDER ✅", Colors.GREEN);

        return sandwich;
    }

    public static Drink orderDrink() {
        UserInterface.printToConsole("\nCHOOSE A DRINK BELOW");

        UserInterface.printToConsole(DrinkFlavors.displayFlavors());

        DrinkFlavors flavor = DrinkFlavors.valueOf(UserInterface.promptForInput("Select flavor ❯ ").toUpperCase());

        UserInterface.printToConsole("\nCHOOSE A SIZE");

        UserInterface.printToConsole(DrinkSize.displayDrinkSizes());

        DrinkSize drinkSize = DrinkSize.valueOf(UserInterface.promptForInput("Select size ❯ ").toUpperCase());

        UserInterface.printToConsole("\nDRINK ADDED TO ORDER ✅", Colors.GREEN);

        return new Drink(flavor, drinkSize);
    }

    public static Chips orderChips() {
        UserInterface.printToConsole("\nWHAT CHIPS WOULD YOU LIKE");

        UserInterface.printToConsole(ChipFlavors.displayFlavors());

        ChipFlavors chips = ChipFlavors.valueOf(UserInterface.promptForInput("Select flavor ❯ ").toUpperCase());

        UserInterface.printToConsole("\nCHIPS ADDED TO ORDER ✅", Colors.GREEN);

        return new Chips(chips);
    }
}