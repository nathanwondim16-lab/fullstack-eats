package com.pluralsight.ui;

import com.pluralsight.enums.*;
import com.pluralsight.exceptions.InvalidBreadTypeException;
import com.pluralsight.exceptions.InvalidMenuSelectionException;
import com.pluralsight.exceptions.InvalidSandwichSizeException;
import com.pluralsight.exceptions.InvalidToppingException;
import com.pluralsight.formatters.ToppingFormatter;
import com.pluralsight.models.*;
import java.util.Arrays;

public class DeliScreen {

    public static Sandwich orderSandwich() {

        UserInterface.printDivider();

        UserInterface.printToConsoleFormatted("""
                   ________________________
                  /|                     /|
                 / |   🥪 DELI SHOP 🥪  / |
                /__|___________________/  |
                |  |                   |  |
                |  |   🍞 FRESH BREAD  |  |
                |  |   🥓 HOT GRILL    |  |
                |  |   🧀 MELT STATION |  |
                |  |                   |  |
                |  |   [  OPEN  ]      |  |
                |  |      ____         |  |
                |  |     |    |        |  |
                |  |_____|____|________| /
                | /____________________|/
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
                UserInterface.printDivider();

                UserInterface.printToConsole("\n⦿ BREAD OPTIONS:\n", Colors.GOLD);
                BreadType.getAllBreads();

                String breadChoice = UserInterface.promptForInput("\nSELECT BREAD ❯ ");

                return Arrays.stream(BreadType.values())
                        .filter(breadType -> breadType.name().equalsIgnoreCase(breadChoice))
                        .findFirst()
                        .orElseThrow(() -> new InvalidBreadTypeException("Invalid bread type selected."));

            } catch (InvalidBreadTypeException e) {
                UserInterface.handleException(e);
            }
        }
    }

    private static SandwichSize getSandwichSize() {
        while(true) {

            try {
                UserInterface.printDivider();

                UserInterface.printToConsole("\n⦿ SANDWICH SIZES:\n", Colors.GOLD);
                SandwichSize.getAllSizes();

                int sizeChoice = UserInterface.promptForNumber("\nSANDWICH SIZE ❯ ");

                UserInterface.printDivider();

                return Arrays.stream(SandwichSize.values())
                        .filter(size -> size.getDisplaySize() == sizeChoice)
                        .findFirst()
                        .orElseThrow(() -> new InvalidSandwichSizeException("Invalid sandwich size selected."));
            } catch (InvalidSandwichSizeException e) {
                UserInterface.handleException(e);
            }
        }
    }

    private static boolean getToasted() {
        return UserInterface.promptForInput("\nDo you want your sandwich toasted? ❯ ").equalsIgnoreCase("yes");
    }

    private static void addSandwichToppings(Sandwich sandwich) {
        Arrays.stream(ToppingCategory.values())
                .forEach(category -> addToppingsByCategory(sandwich, category));
    }

    private static void addToppingsByCategory(Sandwich sandwich, ToppingCategory category) {
        while(true) {

            try {
                UserInterface.printDivider();

                ToppingFormatter.displayToppings(SandwichToppings.class, category);

                String toppingChoice = UserInterface.promptForInput("\nENTER TOPPING OR SAY SKIP ❯ ").toUpperCase();

                if(toppingChoice.equalsIgnoreCase("skip")) {
                    break;
                }

                SandwichToppings selectedTopping = Arrays.stream(SandwichToppings.values())
                        .filter(topping -> topping.name().equalsIgnoreCase(toppingChoice))
                        .filter(topping -> topping.getCategory() == category)
                        .findFirst()
                        .orElseThrow(() -> new InvalidToppingException("Invalid topping selected."));

                boolean isExtra = UserInterface.promptForInput("Do you want extra " + selectedTopping + " on your sandwich? ").equalsIgnoreCase("yes");

                sandwich.addTopping(new Topping<>(selectedTopping, isExtra));

                String finished = UserInterface.promptForInput("Are you done adding " + (category.name() + "s to your sandwich ❯ ").toLowerCase());

                if(finished.equalsIgnoreCase("yes")) {
                    break;
                }

                UserInterface.printDivider();
            } catch (InvalidToppingException e) {
                UserInterface.handleException(e);
            }
        }
    }

    public static Drink orderDrink() {
        DrinkFlavors flavor = getDrinkFlavor();
        DrinkSize drinkSize = getDrinkSize();

        UserInterface.printToConsole("\n" + drinkSize + " " + flavor.getFlavor().toUpperCase() + " ADDED TO ORDER ✅", Colors.GREEN);

        return new Drink(flavor, drinkSize);
    }

    private static DrinkFlavors getDrinkFlavor() {
        while(true) {
            try {

                UserInterface.printToConsole("\nCHOOSE A DRINK BELOW\n", Colors.GOLD);
                DrinkFlavors.displayFlavors();

                String flavorChoice = UserInterface.promptForInput("\nSelect flavor ❯ ");

                UserInterface.printDivider();

                return Arrays.stream(DrinkFlavors.values())
                        .filter(flavor -> flavor.getFlavor().equalsIgnoreCase(flavorChoice))
                        .findFirst()
                        .orElseThrow(() -> new InvalidMenuSelectionException("Invalid drink flavor selected."));

            } catch (InvalidMenuSelectionException e) {
                UserInterface.handleException(e);
            }
        }
    }

    private static DrinkSize getDrinkSize() {
        while(true) {
            try {
                UserInterface.printDivider();

                UserInterface.printToConsole("\nCHOOSE A SIZE\n", Colors.GOLD);
                DrinkSize.displayDrinkSizes();

                String drinkSize = UserInterface.promptForInput("\nSelect size ❯ ");

                UserInterface.printDivider();

                return Arrays.stream(DrinkSize.values())
                        .filter(size -> size.name().equalsIgnoreCase(drinkSize))
                        .findFirst()
                        .orElseThrow(() -> new InvalidMenuSelectionException("Invalid drink size selected."));
            } catch (InvalidMenuSelectionException e) {
                UserInterface.handleException(e);
            }
        }
    }

    public static Chips orderChips() {
        ChipFlavors chips = getChipFlavor();

        UserInterface.printToConsole("\n" + chips.getDisplayName() + " CHIPS ADDED TO ORDER ✅", Colors.GREEN);

        return new Chips(chips);
    }

    private static ChipFlavors getChipFlavor() {
        while(true) {
            try {
                UserInterface.printDivider();

                UserInterface.printToConsole("\nWHAT CHIPS WOULD YOU LIKE\n", Colors.GOLD);
                ChipFlavors.displayFlavors();

                String chipFlavor = (UserInterface.promptForInput("\nSelect flavor ❯ "));

                UserInterface.printDivider();

                return Arrays.stream(ChipFlavors.values())
                        .filter(chips -> chips.getDisplayName().equalsIgnoreCase(chipFlavor))
                        .findFirst()
                        .orElseThrow(() -> new InvalidMenuSelectionException("Invalid chip flavor selected."));
            } catch (InvalidMenuSelectionException e) {
                UserInterface.handleException(e);
            }
        }
    }
}