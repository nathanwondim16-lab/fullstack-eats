package com.pluralsight.ui;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.SandwichSize;
import com.pluralsight.enums.SandwichToppings;

public class Deli {

    public static void orderSandwich() {

        UserInterface.printDivider("=");

        UserInterface.printToConsole("\nCHOOSE A BREAD 🍞");

        UserInterface.printOnSameLine(BreadType.getAllBreads());

        String breadChoice = UserInterface.promptForInput("\nSelect bread ❯ ");

        UserInterface.printToConsole("\nCHOOSE SANDWICH SIZE 📏");

        UserInterface.printOnSameLine(SandwichSize.getAllSizes());

        String sandwichSize = UserInterface.promptForInput("\nSelect size ❯ ");

        UserInterface.printToConsole("\nTOPPINGS 🍗🌶️🧀🍅");


        UserInterface.printOnSameLine(SandwichToppings.getAllToppings());

        UserInterface.printToConsole("");

        SandwichToppings.displayToppingsByCategory();


    }
}
