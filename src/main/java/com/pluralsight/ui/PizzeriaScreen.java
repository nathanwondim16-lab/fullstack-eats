package com.pluralsight.ui;

import com.pluralsight.enums.*;
import com.pluralsight.models.*;

import java.util.Arrays;

public class PizzeriaScreen {

    public static Pizza orderPizza() {

        UserInterface.printDivider();

        UserInterface.printToConsoleFormatted("""
                         🍕 FULLSTACK PIZZERIA 🍕
                ╔══════════════════════════════════════╗
                ║      WOOD FIRED • HAND TOSSED        ║
                ╚══════════════════════════════════════╝
        
        
                           __________________
                          /_________________/|
                         |                 | |
                         |   🔥🔥🔥🔥🔥   | |
                         |   🍕  🍕  🍕   | |
                         |                 | |
                         |~~~~~~~~~~~~~~~~~| |
                         |                 | |
                         |      OVEN       | /
                         |_________________|/
        
                                 ||
                            ____/  \\____
                           /            \\
                      ____/______________\\____
                     /   HOT • FRESH • FAST   \\
                    /__________________________\\
                     """, Colors.CRIMSON);

        CrustType crustChoice = getCrustType();
        PizzaSize pizzaSize = getPizzaSize();
        boolean isCrustStuffed = getStuffed();

        Pizza pizza = new Pizza(crustChoice, pizzaSize, isCrustStuffed);

        addPizzaToppings(pizza);

        UserInterface.printToConsole("\nPIZZA ADDED TO ORDER ✅", Colors.GREEN);

        return pizza;
    }



    private static CrustType getCrustType() {
        while(true) {
            try {
                UserInterface.printToConsole("⦿ CRUST OPTIONS:\n", Colors.GOLD);
                CrustType.getAllCrusts();

                return CrustType.valueOf(UserInterface.promptForInput("\nSELECT CRUST ❯ ").toUpperCase());
            } catch (Exception e) {
                UserInterface.invalidOption();
            }
        }
    }

    private static PizzaSize getPizzaSize() {
        while(true) {
            UserInterface.printToConsole("\n⦿ PIZZA SIZES:\n", Colors.GOLD);
            PizzaSize.getAllSizes();

            int sizeChoice = UserInterface.promptForNumber("\nPIZZA SIZE ❯ ");

            PizzaSize selectedSize = Arrays.stream(PizzaSize.values())
                    .filter(size -> size.getDisplaySize() == sizeChoice)
                    .findFirst()
                    .orElse(null);

            if(selectedSize != null) {
                return selectedSize;
            }

            UserInterface.invalidOption();
        }
    }

    private static boolean getStuffed() {
        return UserInterface.promptForInput("\nDo you want your pizza's crust stuffed ❯ ").equalsIgnoreCase("yes");
    }

    private static void addPizzaToppings(Pizza pizza) {
        UserInterface.printToConsole("\n⦿ TOPPINGS:", Colors.GOLD);

        Arrays.stream(ToppingCategory.values())
                .forEach(category -> addToppingsByCategory(pizza, category));
    }

    private static void addToppingsByCategory(Pizza pizza, ToppingCategory category) {
        while(true) {
            UserInterface.printDivider();

            ToppingFormatter.displayToppings(PizzaToppings.class, category);

            String toppingChoice = UserInterface.promptForInput("ENTER TOPPING OR SAY SKIP ❯ ").toUpperCase();

            if(toppingChoice.equalsIgnoreCase("skip")) {
                break;
            }

            try {
                PizzaToppings selectedTopping = PizzaToppings.valueOf(toppingChoice);

                boolean isExtra = UserInterface.promptForInput("Do you want extra " + selectedTopping + " on your pizza? ").equalsIgnoreCase("yes");

                pizza.addTopping(new Topping<>(selectedTopping, isExtra));

                String finished = UserInterface.promptForInput("Are you done adding " + (category.name() + "s to your pizza ❯ ").toLowerCase());

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

    public static GarlicKnots orderKnots() {
        UserInterface.printToConsole("\nWHAT KNOTS WOULD YOU LIKE");

        UserInterface.printToConsole(Knots.displayKnots());

        Knots knots = Knots.valueOf(UserInterface.promptForInput("Select knots ❯ ").toUpperCase());

        UserInterface.printToConsole("\n" + knots + " ADDED TO ORDER ✅", Colors.GREEN);

        return new GarlicKnots(knots);
    }
}
