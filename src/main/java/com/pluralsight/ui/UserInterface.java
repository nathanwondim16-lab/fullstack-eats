package com.pluralsight.ui;

import com.pluralsight.enums.Colors;

import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printToConsole(String message) {
        System.out.println(message);
    }

    public static void printToConsole(String message, Colors color) {
        printToConsole(color.colorize(message));
    }

    public static void printOnSameLine(String message) {
        System.out.print(message);
    }

    public static String promptForInput(String message) {
        printOnSameLine(message);
        return scanner.nextLine().strip();
    }

    public static int promptForNumber(String message) {
        printOnSameLine(message);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void printDivider() {
        printToConsole("\n" + "=".repeat(100), Colors.TRON);
    }

    public static void invalidOption() {
        printToConsole("\nINVALID OPTION. PLEASE CHOOSE A VALID OPTION\n", Colors.CRIMSON);
    }

    public static void endApplication(String message) {
        printToConsole("\n\n" + message);
        System.exit(0);
    }

    public static void printToConsoleFormatted(String text, Object... values) {
        System.out.printf(text, values);
    }

    public static void printToConsoleFormatted(String text, Colors colors, Object... values) {
        System.out.printf(colors.colorize(text), values);
    }

    public static void confirmOrder() {
        UserInterface.printDivider();
        String[] confirmationMessage = {
                "[ SYSTEM ] Creating Customer Ticket...",
                "[ SYSTEM ] Syncing Order Database...",
                "[ SYSTEM ] Reserving Inventory...",
                "[ SYSTEM ] Sending Order To Kitchen...",
                "[ SYSTEM ] Printing Receipt..."
        };

        Arrays.stream(confirmationMessage).forEach(message -> {
            UserInterface.printOnSameLine(Colors.LIGHT_BLUE.colorize("\r" + message));
            pauseProgram(1000);
        });

        UserInterface.printToConsole("\r ");

        int totalBars = 20;

        String filledBar = Colors.GREEN.colorize("█");
        String transparentBar = Colors.MUTED_GRAY.colorize("▓");

        for (int i = 0; i <= totalBars; i++) {
            String progressBar = filledBar.repeat(i) + transparentBar.repeat(totalBars - i);

            int percent = i * 100 / totalBars;

            UserInterface.printOnSameLine(Colors.GREEN.colorize("\rSaving Order Details: " + progressBar + " " + percent + "%"));

            pauseProgram(150);
        }

        UserInterface.printToConsole("\r ");


        UserInterface.printToConsole("[ COMPLETE ] ORDER SAVED ✅\n", Colors.GREEN);
    }

    private static void pauseProgram(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public static void handleException(Throwable throwable) {
        printDivider();

        printToConsole("ERROR ❌ " + throwable.getMessage(), Colors.CRIMSON);

        printDivider();
    }
}