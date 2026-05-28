package com.pluralsight.models;

import com.pluralsight.enums.ShellType;
import com.pluralsight.enums.TacoChoices;
import com.pluralsight.enums.TacoToppings;
import com.pluralsight.ui.UserInterface;

public class Taco extends Food<TacoToppings> {

    private final ShellType shellType;
    private final TacoChoices tacoChoice;
    private final boolean isCoveredInSalasAndQueso;

    public Taco(ShellType shellType, TacoChoices tacoChoice, boolean isCoveredInSalasAndQueso) {
        this.shellType = shellType;
        this.tacoChoice = tacoChoice;
        this.isCoveredInSalasAndQueso = isCoveredInSalasAndQueso;
    }

    public ShellType getShellType() {
        return shellType;
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
                """, tacoChoice, shellType);

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