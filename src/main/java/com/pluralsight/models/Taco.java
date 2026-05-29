package com.pluralsight.models;

import com.pluralsight.enums.*;
import com.pluralsight.ui.UserInterface;

import java.util.Arrays;

public class Taco extends Food<TacoToppings> {

    private TacoType tacoType;
    private TacoChoices tacoChoice;
    private boolean isCoveredInSalasAndQueso;

    public Taco(TacoType tacoType, TacoChoices tacoChoice, boolean isCoveredInSalasAndQueso) {
        this.tacoType = tacoType;
        this.tacoChoice = tacoChoice;
        this.isCoveredInSalasAndQueso = isCoveredInSalasAndQueso;
    }

    public TacoType getShellType() {
        return tacoType;
    }

    public TacoChoices getTacoChoice() {
        return tacoChoice;
    }

    public boolean isCoveredInSalasAndQueso() {
        return isCoveredInSalasAndQueso;
    }

    @Override
    public double getPrice() {
        return tacoChoice.getTacoChoicePrice()
                + getToppings().stream()
                .mapToDouble(tacoChoice::getToppingPrice)
                .sum();
    }

    @Override
    public void orderDetails() {
        UserInterface.printToConsoleFormatted("""
                ◦ Custom %s
                \t\t• %s
                """, tacoChoice, tacoType);

        displayToppings();

        UserInterface.printToConsoleFormatted("""
                \t\t%s
                """, isCoveredInSalasAndQueso ? "• Covered in Salsa and Queso" : "");

        UserInterface.printToConsole(String.format("""
                
                %-10s $%.2f""", "Price:", getPrice()), Colors.GREEN);
    }

    @Override
    public void editItem() {
        while(true) {
            UserInterface.printDivider();
            UserInterface.printToConsole("\nWHAT DO YOU WANT TO CHANGE ABOUT YOUR PIZZA?\n", Colors.GOLD);
            int option = UserInterface.promptForNumber("""
                    
                    1) Taco Size
                    2) Taco Type
                    3) Toppings
                    4) Covered in Salsa and Queso
                    0) Done
                    
                    Select Option ❯\s""");

            UserInterface.printDivider();

            switch(option) {
                case 1 -> changeTacoChoice();
                case 2 -> changeTacoType();
                case 3 -> editToppings(TacoToppings.class);
                case 4 -> changeCoveredInSalsaAndQuesoStatus();
                case 0 -> {
                    UserInterface.printToConsole("\nCHANGES TO YOUR PIZZA HAVE BEEN SAVED ✅", Colors.GREEN);
                    return;
                }

                default -> UserInterface.invalidOption();
            }
        }
    }

    private void changeTacoChoice() {
        UserInterface.printToConsole("\nWHICH TACO SIZE DO YOU WANT TO SWITCH TO?", Colors.GOLD);

        TacoChoices.getAllChoices();

        String tacoSelection = UserInterface.promptForInput("\nTACO SIZE ❯ ");

        TacoChoices selectedChoice = Arrays.stream(TacoChoices.values())
                .filter(size -> size.getDisplayName().equalsIgnoreCase(tacoSelection))
                .findFirst()
                .orElse(null);

        if(selectedChoice == null) {
            UserInterface.invalidOption();
            return;
        }

        tacoChoice = selectedChoice;

        UserInterface.printToConsole("\nSIZE HAS BEEN CHANGED ✅", Colors.GREEN);
    }

    private void changeTacoType() {
        UserInterface.printToConsole("\nWHICH TACO OPTION DO YOU WANT TO SWITCH TO?", Colors.GOLD);

        TacoType.getTacoOptions();

        try {
           tacoType = TacoType.valueOf(UserInterface.promptForInput("\nSELECT TACO OPTION ❯ ").toUpperCase());

            UserInterface.printToConsole("\nTACO OPTION HAS BEEN CHANGED ✅", Colors.GREEN);
        } catch (Exception e) {
            UserInterface.invalidOption();
        }
    }

    private void changeCoveredInSalsaAndQuesoStatus() {
        isCoveredInSalasAndQueso = !isCoveredInSalasAndQueso;

        UserInterface.printToConsole("\n" + tacoChoice.getDisplayName() + (isCoveredInSalasAndQueso ? " IS COVERED IN SALSA AND QUESO ✅"
                : " IS NOT COVERED IN SALSA AND QUESO ❌"), Colors.GREEN);
    }
}