package com.pluralsight.formatters;

import com.pluralsight.enums.Colors;
import com.pluralsight.enums.ToppingCategory;
import com.pluralsight.interfaces.OrganizeToppings;
import com.pluralsight.ui.UserInterface;

import java.util.Arrays;

public class ToppingFormatter {

    public static <T extends Enum<T> & OrganizeToppings> void displayToppings(Class<T> toppingEnum, ToppingCategory category) {
        int width = Arrays.stream(toppingEnum.getEnumConstants())
                .filter(t -> t.getCategory() == category)
                .map(Enum::toString)
                .mapToInt(String::length)
                .max()
                .orElse(category.toString().length());

        String tableTitle = category + "S";
        width = Math.max(width, tableTitle.length());

        createTable(width, tableTitle);

        int finalWidth = width;

        Arrays.stream(toppingEnum.getEnumConstants())
                .filter(topping -> topping.getCategory() == category)
                .forEach(topping -> {
                    String row = String.format("║ %-" + finalWidth + "s ║", topping);
                    UserInterface.printToConsole(row, Colors.LIGHT_BLUE);
                });

        String bottomBox = "╚" + repeat(width + 2) + "╝";
        UserInterface.printToConsole(bottomBox, Colors.LIGHT_BLUE);
    }

    private static void createTable(int width, String tableName) {
        String topBox = "╔" + repeat(width + 2) + "╗";

        String middleBox = "╠" + repeat(width + 2) + "╣";

        String headerFormat = "║ %-" + width + "s ║";

        UserInterface.printToConsole("\n⦿ TOPPINGS:", Colors.GOLD);
        UserInterface.printToConsole(topBox, Colors.LIGHT_BLUE);
        UserInterface.printToConsole(String.format(headerFormat, tableName), Colors.LIGHT_BLUE);
        UserInterface.printToConsole(middleBox, Colors.LIGHT_BLUE);

    }

    private static String repeat(int boxAmount) {
        return "═".repeat(boxAmount);
    }
}