package com.pluralsight.ui;

import com.pluralsight.enums.Colors;

public class HomeScreen {
    public void start() {
        UserInterface.printToConsole("Welcome to Crafted Bites", Colors.GOLD);

        while(true) {
            UserInterface.printDivider();

            int userChoice = UserInterface.promptForNumber("""
                    1) New Order
                    0) Exit
                    
                    Select Option ❯\s""");

            switch(userChoice) {
                case 1 -> OrderScreen.startOrder();
                case 0 -> UserInterface.endApplication("GOODBYE 👋🏾");

                default -> UserInterface.invalidOption();
            }
        }
    }
}