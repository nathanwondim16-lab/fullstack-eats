package com.pluralsight.ui;

import com.pluralsight.enums.Colors;

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

    public static void printDivider(String symbol) {
        printToConsole("\n" + symbol.repeat(100), Colors.TRON);
    }

    public static void invalidOption() {
        printToConsole("\nINVALID OPTION. PLEASE CHOOSE A VALID OPTION", Colors.CRIMSON);
    }

    public static void endApplication(String message) {
        printToConsole("\n\n" + message);
        System.exit(0);
    }
}