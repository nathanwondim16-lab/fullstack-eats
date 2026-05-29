package com.pluralsight.ui;

import com.pluralsight.enums.*;
import com.pluralsight.exceptions.InvalidMenuSelectionException;
import com.pluralsight.exceptions.InvalidToppingException;
import com.pluralsight.formatters.ToppingFormatter;
import com.pluralsight.models.ChipsAndSalsa;
import com.pluralsight.models.Taco;
import com.pluralsight.models.Topping;

import java.util.Arrays;

public class TacoTruckScreen {

    public static Taco orderTaco() {
        UserInterface.printDivider();

        UserInterface.printToConsole("""
                                ______________________________________
                         ______/|                                      |\\
                        /______/|   TACO TRUCK                         | \\
                       |      | |______________________________________|  |
                       |  []  | |  _________________________________   |  |
                       |      | | |                                 |  |  |
                       |  🌮  | | |   TACOS • BURRITOS • SALSA      |  |  |
                       |  🌯  | | |_________________________________|  |  |
                       |      | |                                      |  |
                       |______|/_______________________________________|__|
                """, Colors.AMBER);

        TacoType tacoType = getTacoType();
        TacoChoices tacoChoice = getTacoChoice();
        boolean coveredInSalsaAndQueso = getCoveredInSalsaAndQueso();

        Taco taco = new Taco(tacoType, tacoChoice, coveredInSalsaAndQueso);

        addTacoToppings(taco);

        UserInterface.printToConsole("\nTACO ADDED TO ORDER ✅", Colors.GREEN);

        return taco;
    }

    private static TacoType getTacoType() {
        while(true) {
            try {
                UserInterface.printDivider();
                UserInterface.printToConsole("\n⦿ TACO TYPES:\n", Colors.GOLD);

                TacoType.getTacoOptions();

                String tacoSelection = UserInterface.promptForInput("\nSELECT TACO TYPE ❯ ");

                return Arrays.stream(TacoType.values())
                        .filter(type -> type.name().equalsIgnoreCase(tacoSelection))
                        .findFirst()
                        .orElseThrow(() -> new InvalidMenuSelectionException("Invalid taco type selected."));
            } catch (InvalidMenuSelectionException e) {
                UserInterface.handleException(e);
            }
        }
    }

    private static TacoChoices getTacoChoice() {
        while(true) {
            try {
                UserInterface.printDivider();
                UserInterface.printToConsole("\n⦿ TACO CHOICES:\n", Colors.GOLD);

                TacoChoices.getAllChoices();

                String tacoChoice = UserInterface.promptForInput("\nSELECT TACO CHOICE ❯ ");

                return Arrays.stream(TacoChoices.values())
                        .filter(choice -> choice.getDisplayName().equalsIgnoreCase(tacoChoice))
                        .findFirst()
                        .orElseThrow(() -> new InvalidMenuSelectionException("Invalid taco choice selected."));
            } catch (InvalidMenuSelectionException e) {
                UserInterface.handleException(e);
            }
        }
    }

    private static boolean getCoveredInSalsaAndQueso() {
        return UserInterface.promptForInput("\nDo you want it covered in salsa and queso ❯ ").equalsIgnoreCase("yes");
    }

    private static void addTacoToppings(Taco taco) {
        Arrays.stream(ToppingCategory.values())
                .forEach(category -> addToppingByCategory(taco, category));
    }

    private static void addToppingByCategory(Taco taco, ToppingCategory category) {
        while(true) {
            try {
                UserInterface.printDivider();

                ToppingFormatter.displayToppings(TacoToppings.class, category);

                String toppingChoice = UserInterface.promptForInput("\nENTER TOPPING OR SKIP ❯ ");

                if(toppingChoice.equalsIgnoreCase("skip")) {
                    break;
                }

                TacoToppings selectedTopping = Arrays.stream(TacoToppings.values())
                        .filter(topping -> topping.name().equalsIgnoreCase(toppingChoice))
                        .filter(topping -> topping.getCategory() == category)
                        .findFirst()
                        .orElseThrow(() -> new InvalidToppingException("Invalid taco topping selected."));

                Topping<TacoToppings> existingTopping = taco.getToppings().stream()
                        .filter(topping -> topping.getType() == selectedTopping)
                        .findFirst()
                        .orElse(null);

                if(existingTopping != null) {
                    if(existingTopping.isExtra()) {
                        throw new InvalidToppingException(selectedTopping + " is already added as extra.");
                    }

                    boolean upgradeToExtra = UserInterface.promptForInput(selectedTopping + " is already added. Upgrade it to extra? ❯ ").equalsIgnoreCase("yes");

                    if(upgradeToExtra) {
                        taco.getToppings().remove(existingTopping);
                        taco.addTopping(new Topping<>(selectedTopping, true));

                        UserInterface.printToConsole("\n" + selectedTopping + " UPGRADED TO EXTRA ✅", Colors.GREEN);
                    }
                    continue;
                }

                boolean isExtra = UserInterface.promptForInput("Do you want extra " + selectedTopping + " on your taco? ❯ ").equalsIgnoreCase("yes");

                taco.addTopping(new Topping<>(selectedTopping, isExtra));

                String finished = UserInterface.promptForInput("Are you done adding " + category.name().toLowerCase() + "s to your taco ❯ ");

                if(finished.equalsIgnoreCase("yes")) {
                    break;
                }
            } catch (InvalidToppingException e) {
                UserInterface.handleException(e);
            }
        }
    }

    public static ChipsAndSalsa orderChipsAndSalsa() {
        SalsaType salsaType = getSalsaType();

        UserInterface.printToConsole("\nCHIPS & " + salsaType.getDisplayName() + " ADDED TO ORDER ✅", Colors.GREEN);

        UserInterface.printDivider();

        return new ChipsAndSalsa(salsaType);
    }

    private static SalsaType getSalsaType() {
        while(true) {
            try {
                UserInterface.printDivider();

                UserInterface.printToConsole("\n⦿ SALSA OPTIONS:\n", Colors.GOLD);
                SalsaType.getSalsaOptions();

                String salsaChoice = UserInterface.promptForInput("\nSELECT SALSA ❯ ");

                return Arrays.stream(SalsaType.values())
                        .filter(salsa -> salsa.getDisplayName().equalsIgnoreCase(salsaChoice))
                        .findFirst()
                        .orElseThrow(() -> new InvalidMenuSelectionException("Invalid salsa selection."));
            } catch (InvalidMenuSelectionException e) {
                UserInterface.handleException(e);
            }
        }
    }
}