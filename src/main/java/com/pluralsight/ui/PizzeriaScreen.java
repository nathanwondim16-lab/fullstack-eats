package com.pluralsight.ui;

import com.pluralsight.enums.*;
import com.pluralsight.exceptions.InvalidCrustException;
import com.pluralsight.exceptions.InvalidMenuSelectionException;
import com.pluralsight.exceptions.InvalidPizzaSizeException;
import com.pluralsight.exceptions.InvalidToppingException;
import com.pluralsight.formatters.ToppingFormatter;
import com.pluralsight.models.*;
import com.pluralsight.models.Knots;

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
                UserInterface.printDivider();

                UserInterface.printToConsole("⦿ CRUST OPTIONS:\n", Colors.GOLD);
                CrustType.getAllCrusts();

                String crustChoice = UserInterface.promptForInput("\nSELECT CRUST ❯ ");

                return Arrays.stream(CrustType.values())
                        .filter(crustType -> crustType.name().equalsIgnoreCase(crustChoice))
                        .findFirst()
                        .orElseThrow(() -> new InvalidCrustException("Invalid crust type selected."));

            } catch (InvalidCrustException e) {
                UserInterface.handleException(e);
            }
        }
    }

    private static PizzaSize getPizzaSize() {
        while(true) {
            try {
                UserInterface.printDivider();

                UserInterface.printToConsole("\n⦿ PIZZA SIZES:\n", Colors.GOLD);
                PizzaSize.getAllSizes();

                int sizeChoice = UserInterface.promptForNumber("\nPIZZA SIZE ❯ ");

                UserInterface.printDivider();

                return Arrays.stream(PizzaSize.values())
                        .filter(size -> size.getDisplaySize() == sizeChoice)
                        .findFirst()
                        .orElseThrow(() -> new InvalidPizzaSizeException("Invalid pizza size selected."));
            } catch (InvalidPizzaSizeException e) {
                UserInterface.handleException(e);
            }
        }
    }

    private static boolean getStuffed() {
        return UserInterface.promptForInput("\nDo you want stuffed crust? ❯ ").equalsIgnoreCase("yes");
    }

    private static void addPizzaToppings(Pizza pizza) {
        Arrays.stream(ToppingCategory.values())
                .forEach(category -> addToppingsByCategory(pizza, category));
    }

    private static void addToppingsByCategory(Pizza pizza, ToppingCategory category) {
        while(true) {
            try {
                UserInterface.printDivider();

                ToppingFormatter.displayToppings(PizzaToppings.class, category);

                String toppingChoice = UserInterface.promptForInput("ENTER TOPPING OR SAY SKIP ❯ ").toUpperCase();

                if(toppingChoice.equalsIgnoreCase("skip")) {
                    break;
                }

                PizzaToppings selectedTopping = Arrays.stream(PizzaToppings.values())
                        .filter(topping -> topping.name().equalsIgnoreCase(toppingChoice))
                        .filter(topping -> topping.getCategory() == category)
                        .findFirst()
                        .orElseThrow(() -> new InvalidToppingException("Invalid pizza topping selected."));

                boolean isExtra = UserInterface.promptForInput("Do you want extra " + selectedTopping + " on your pizza? ").equalsIgnoreCase("yes");

                pizza.addTopping(new Topping<>(selectedTopping, isExtra));

                String finished = UserInterface.promptForInput("Are you done adding " + (category.name() + "s to your pizza ❯ ").toLowerCase());

                if(finished.equalsIgnoreCase("yes")) {
                    break;
                }
            } catch (InvalidToppingException e) {
                UserInterface.handleException(e);
            }
        }
    }

    public static Knots orderKnots() {
        KnotsType knotsType = getKnotsType();

        UserInterface.printToConsole("\n" + knotsType + " KNOTS ADDED TO ORDER ✅", Colors.GREEN);

        return new Knots(knotsType);
    }

    private static KnotsType getKnotsType() {
        while(true) {
            try {
                UserInterface.printDivider();

                UserInterface.printToConsole("\nWHAT KNOTS WOULD YOU LIKE\n", Colors.GOLD);
                KnotsType.displayKnots();

                String knotsChoice = UserInterface.promptForInput("\nSelect knots ❯ ");

                return Arrays.stream(KnotsType.values())
                        .filter(knot -> knot.name().equalsIgnoreCase(knotsChoice))
                        .findFirst()
                        .orElseThrow(() -> new InvalidMenuSelectionException("Invalid knots selected"));

            } catch (InvalidMenuSelectionException e) {
                UserInterface.handleException(e);
            }
        }
    }
}