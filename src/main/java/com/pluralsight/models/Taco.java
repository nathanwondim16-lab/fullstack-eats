package com.pluralsight.models;

import com.pluralsight.enums.TacoType;
import com.pluralsight.enums.TacoChoices;
import com.pluralsight.enums.TacoToppings;
import com.pluralsight.ui.UserInterface;

public class Taco extends Food<TacoToppings> {

    private final TacoType tacoType;
    private final TacoChoices tacoChoice;
    private final boolean isCoveredInSalasAndQueso;

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
    }

    @Override
    public void editItem() {

    }

    @Override
    public String preparingMessage() {
        return "🌮Preparing Tacos";
    }
}