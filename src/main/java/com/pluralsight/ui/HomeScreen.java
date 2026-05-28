package com.pluralsight.ui;

import com.pluralsight.enums.Colors;

public class HomeScreen {
    public void start() {
        while(true) {
            UserInterface.printDivider();

            UserInterface.printToConsole("""
                
                 _   _                        _____                         \s
                | | | |                      /  ___|                        \s
                | |_| | ___  _ __ ___   ___  \\ `--.  ___ _ __ ___  ___ _ __ \s
                |  _  |/ _ \\| '_ ` _ \\ / _ \\  `--. \\/ __| '__/ _ \\/ _ \\ '_ \\\s
                | | | | (_) | | | | | |  __/ /\\__/ / (__| | |  __/  __/ | | |
                \\_| |_/\\___/|_| |_| |_|\\___| \\____/ \\___|_|  \\___|\\___|_| |_|
                """, Colors.GOLD);

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