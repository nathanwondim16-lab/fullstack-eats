package com.pluralsight.models;

import com.pluralsight.enums.Colors;
import com.pluralsight.enums.SalsaType;
import com.pluralsight.interfaces.Chargeable;
import com.pluralsight.ui.UserInterface;

public class ChipsAndSalsa implements Chargeable {

    private final SalsaType salsaType;

    public ChipsAndSalsa(SalsaType salsaType) {
        this.salsaType = salsaType;
    }

    public SalsaType getSalsaType() {
        return salsaType;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public void orderDetails() {
        UserInterface.printToConsoleFormatted("""
  
                Tortilla Chips & %s
                """, salsaType.getDisplayName());

        UserInterface.printToConsole(String.format("""
                
                %-10s $%.2f""", "Price:", getPrice()), Colors.GREEN);
    }

    @Override
    public void editItem() {
        UserInterface.printDivider();

        UserInterface.printToConsole("WHAT SALSA DO YOU WANT TO SWITCH TO");

        SalsaType.getSalsaOptions();
    }
}