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

        BreadType breadChoice = getBreadType();
        SandwichSize sandwichSize = getSandwichSize();
        boolean isToasted = getToasted();

        Sandwich sandwich = new Sandwich(breadChoice, sandwichSize, isToasted);

        addSandwichToppings(sandwich);

        UserInterface.printToConsole("\nSANDWICH ADDED TO ORDER ✅", Colors.GREEN);

        return sandwich;
    }

    private static BreadType getBreadType() {
        while(true) {
            try {
                UserInterface.printToConsole("\n⦿ BREAD OPTIONS:\n", Colors.GOLD);
                BreadType.getAllBreads();

                return BreadType.valueOf(UserInterface.promptForInput("\nSELECT BREAD ❯ ").toUpperCase());
            } catch (Exception e) {
                UserInterface.invalidOption();
            }
        }
    }

    private static SandwichSize getSandwichSize() {
        while(true) {
            UserInterface.printToConsole("\n⦿ BREAD SIZES:\n", Colors.GOLD);
            SandwichSize.getAllSizes();

            int sizeChoice = UserInterface.promptForNumber("\nSANDWICH SIZE ❯ ");

            SandwichSize selectedSize = Arrays.stream(SandwichSize.values())
                    .filter(size -> size.getDisplaySize() == sizeChoice)
                    .findFirst()
                    .orElse(null);

            if(selectedSize != null) {
                return selectedSize;
            }

            UserInterface.invalidOption();
        }
    }

    private static boolean getToasted() {
        return UserInterface.promptForInput("\nDo you want your sandwich toasted ❯ ").equalsIgnoreCase("yes");
    }

    private static void addSandwichToppings(Sandwich sandwich) {
        UserInterface.printToConsole("\n⦿ TOPPINGS:", Colors.GOLD);

        Arrays.stream(ToppingCategory.values())
                .forEach(category -> addToppingsByCategory(sandwich, category));
    }

    private static void addToppingsByCategory(Sandwich sandwich, ToppingCategory category) {
        while(true) {
            UserInterface.printDivider();
            SandwichToppings.displayToppings(category);

            String toppingChoice = UserInterface.promptForInput("ENTER TOPPING OR SAY SKIP ❯ ").toUpperCase();

            if(toppingChoice.equalsIgnoreCase("skip")) {
                break;
            }

            try {
                SandwichToppings selectedTopping = SandwichToppings.valueOf(toppingChoice);

                boolean isExtra = UserInterface.promptForInput("Do you want extra " + selectedTopping + " on your sandwich? ").equalsIgnoreCase("yes");

                sandwich.addTopping(new Topping<>(selectedTopping, isExtra));

                String finished = UserInterface.promptForInput("Are you done adding " + (category.name() + "s to your sandwich ❯ ").toLowerCase());

                if(finished.equalsIgnoreCase("yes")) {
                    break;
                }
            } catch (Exception e) {
                UserInterface.invalidOption();
            }
        }
    }

    public static Drink orderDrink() {
        UserInterface.printToConsole("\nCHOOSE A DRINK BELOW");

        UserInterface.printToConsole(DrinkFlavors.displayFlavors());

        DrinkFlavors flavor = DrinkFlavors.valueOf(UserInterface.promptForInput("Select flavor ❯ ").toUpperCase());

        UserInterface.printToConsole("\nCHOOSE A SIZE");

        UserInterface.printToConsole(DrinkSize.displayDrinkSizes());

        DrinkSize drinkSize = DrinkSize.valueOf(UserInterface.promptForInput("Select size ❯ ").toUpperCase());

        UserInterface.printToConsole("\n" + drinkSize + " " + flavor + " ADDED TO ORDER ✅", Colors.GREEN);

        return new Drink(flavor, drinkSize);
    }

    public static Chips orderChips() {
        UserInterface.printToConsole("\nWHAT CHIPS WOULD YOU LIKE");

        UserInterface.printToConsole(ChipFlavors.displayFlavors());

        ChipFlavors chips = ChipFlavors.valueOf(UserInterface.promptForInput("Select flavor ❯ ").toUpperCase());

        UserInterface.printToConsole("\n" + chips + " CHIPS ADDED TO ORDER ✅", Colors.GREEN);

        return new Chips(chips);
    }
}