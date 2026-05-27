package com.pluralsight.enums;

import com.pluralsight.ui.UserInterface;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum SandwichToppings {

    /*
    PREMIUM

                            Meats:
     */
    STEAK(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    HAM(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    SALAMI(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    ROAST_BEEF(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    CHICKEN(ToppingCategory.MEAT, ToppingTier.PREMIUM),
    BACON(ToppingCategory.MEAT, ToppingTier.PREMIUM),

    //                      Cheeses
    AMERICAN(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    PROVOLONE(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    CHEDDAR(ToppingCategory.CHEESE, ToppingTier.PREMIUM),
    SWISS(ToppingCategory.CHEESE, ToppingTier.PREMIUM),

    /*
    REGULAR


                         Other toppings
     */
    LETTUCE(ToppingCategory.OTHER, ToppingTier.REGULAR),
    PEPPERS(ToppingCategory.OTHER, ToppingTier.REGULAR),
    ONIONS(ToppingCategory.OTHER, ToppingTier.REGULAR),
    TOMATOES(ToppingCategory.OTHER, ToppingTier.REGULAR),
    JALAPENOS(ToppingCategory.OTHER, ToppingTier.REGULAR),
    CUCUMBERS(ToppingCategory.OTHER, ToppingTier.REGULAR),
    PICKLES(ToppingCategory.OTHER, ToppingTier.REGULAR),
    GUACAMOLE(ToppingCategory.OTHER, ToppingTier.REGULAR),
    MUSHROOMS(ToppingCategory.OTHER, ToppingTier.REGULAR),

    //                       Sauces
    MAYO(ToppingCategory.SAUCE, ToppingTier.REGULAR),
    MUSTARD(ToppingCategory.SAUCE, ToppingTier.REGULAR),
    KETCHUP(ToppingCategory.SAUCE, ToppingTier.REGULAR),
    RANCH(ToppingCategory.SAUCE, ToppingTier.REGULAR),
    THOUSAND_ISLANDS(ToppingCategory.SAUCE, ToppingTier.REGULAR),
    VINAIGRETTE(ToppingCategory.SAUCE, ToppingTier.REGULAR);


    private final ToppingCategory category;
    private final ToppingTier tier;

    SandwichToppings(ToppingCategory category, ToppingTier tier) {
        this.category = category;
        this.tier = tier;
    }

    public ToppingCategory getCategory() {
        return category;
    }

    public ToppingTier getTier() {
        return tier;
    }

    public static String getAllToppings() {
        return Arrays.stream(SandwichToppings.values()).map(Enum::toString).collect(Collectors.joining(", "));
    }

    public static void displayToppings(ToppingCategory category) {
        int width = Arrays.stream(SandwichToppings.values())
                .filter(topping -> topping.getCategory() == category)
                .map(Enum::toString)
                .mapToInt(String::length)
                .max()
                .orElse(category.toString().length());

        String tableTitle = category + "S";
        width = Math.max(width, tableTitle.length());

        createTable(width, tableTitle);

        int finalWidth = width;

        Arrays.stream(SandwichToppings.values())
                .filter(topping -> topping.getCategory() == category)
                .forEach(topping -> {
                    String row = String.format("║ %-" + finalWidth + "s ║", topping);
                    UserInterface.printToConsole(row, Colors.LIGHT_BLUE);
                });

        String bottomBox = "╚" + repeat("═", width + 2) + "╝";
        UserInterface.printToConsole(bottomBox, Colors.LIGHT_BLUE);
    }

//    public static void displayToppingsByCategory() {
//
//        for(ToppingCategory category : ToppingCategory.values()) {
//
//            int width = Arrays.stream(SandwichToppings.values())
//                    .filter(topping -> topping.getCategory() == category)
//                    .map(Enum::toString)
//                    .mapToInt(String::length)
//                    .max()
//                    .orElse(category.toString().length());
//
//            String tableTitle = category + "S";
//            width = Math.max(width, tableTitle.length());
//
//            createTable(width, tableTitle);
//
//            int finalWidth = width;
//
//            Arrays.stream(SandwichToppings.values())
//                    .filter(topping -> topping.getCategory() == category)
//                    .forEach(topping -> {
//                        String row = String.format("║ %-" + finalWidth + "s ║", topping);
//                        UserInterface.printToConsole(row, Colors.LIGHT_BLUE);
//                    });
//
//            String bottomBox = "╚" + repeat("═", width + 2) + "╝";
//            UserInterface.printToConsole(bottomBox, Colors.LIGHT_BLUE);
//
//        }
//    }

    private static void createTable(int width, String tableName) {
        String topBox = "╔" + repeat("═", width + 2) + "╗";

        String middleBox = "╠" + repeat("═", width + 2) + "╣";

        String headerFormat = "║ %-" + width + "s ║";

        UserInterface.printToConsole(topBox, Colors.LIGHT_BLUE);
        UserInterface.printToConsole(String.format(headerFormat, tableName), Colors.LIGHT_BLUE);
        UserInterface.printToConsole(middleBox, Colors.LIGHT_BLUE);

    }

    private static String repeat(String text, int boxAmount) {
        return text.repeat(boxAmount);
    }
}