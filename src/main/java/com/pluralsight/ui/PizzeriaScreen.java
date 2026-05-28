package com.pluralsight.ui;

import com.pluralsight.enums.*;
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

            try {
                int sizeChoice = Integer.parseInt(UserInterface.promptForInput("\nPIZZA SIZE ❯ "));

                PizzaSize selectedSize = Arrays.stream(PizzaSize.values())
                        .filter(size -> size.getDisplaySize() == sizeChoice)
                        .findFirst()
                        .orElse(null);

                if(selectedSize != null) {
                    return selectedSize;
                }

                UserInterface.invalidOption();

            } catch (Exception e) {
                UserInterface.invalidOption();
            }
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

    public static Knots orderKnots() {
        UserInterface.printToConsole("\nWHAT KNOTS WOULD YOU LIKE");

        UserInterface.printToConsole(com.pluralsight.enums.Knots.displayKnots());

        com.pluralsight.enums.Knots knots = com.pluralsight.enums.Knots.valueOf(UserInterface.promptForInput("Select knots ❯ ").toUpperCase());

        UserInterface.printToConsole("\n" + knots + " ADDED TO ORDER ✅", Colors.GREEN);

        return new Knots(knots);
    }
}