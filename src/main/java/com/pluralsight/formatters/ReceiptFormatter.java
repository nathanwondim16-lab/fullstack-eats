package com.pluralsight.formatters;

import com.pluralsight.models.Order;

import java.time.format.DateTimeFormatter;

public class ReceiptFormatter {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("hh:mm a");
    private static final int ID_WIDTH = 2;
    private static final int MIN_ITEM_WIDTH = 26;
    private static final int MIN_PRICE_WIDTH = 9;

    public static String format(Order order) {
        StringBuilder receipt = new StringBuilder();

        int itemWidth = getItemWidth(order);
        int priceWidth = getPriceWidth(order);

        int receiptWidth = ID_WIDTH + itemWidth + priceWidth + 8;

        receipt.append(topBorder(receiptWidth));
        receipt.append(centerRow("RECEIPT", receiptWidth));
        receipt.append(middleBorder(receiptWidth));

        receipt.append(infoRow("Customer: " + order.getCustomerName(), receiptWidth));
        receipt.append(infoRow("Order ID: " + order.getOrderID(), receiptWidth));
        receipt.append(infoRow("Date: " + order.getOrderDate().format(DATE_FORMAT), receiptWidth));
        receipt.append(infoRow("Time: " + order.getOrderDate().format(TIME_FORMAT), receiptWidth));

        receipt.append(tableTopBorder(itemWidth, priceWidth));

        receipt.append(String.format("║ %-" + ID_WIDTH + "s ║ %-" + itemWidth + "s ║ %-" + priceWidth + "s ║%n", "ID", "Item", "Price"));

        receipt.append(tableMiddleBorder(itemWidth, priceWidth));

        order.getOrderItems().forEach(item -> {
            String itemName = item.getItem().getClass().getSimpleName();
            String price = String.format("$%.2f", item.getItem().getPrice());

            receipt.append(String.format("║ %-" + ID_WIDTH + "d ║ %-" + itemWidth + "s ║ %-" + priceWidth + "s ║%n",
                    item.getItemID(), itemName, price
            ));
        });

        receipt.append(tableBottomBorder(itemWidth, priceWidth));
        receipt.append(infoRow(String.format("TOTAL: $%.2f", order.getTotal()), receiptWidth));
        receipt.append(bottomBorder(receiptWidth));

        return receipt.toString();
    }

    private static int getItemWidth(Order order) {
        int largestItemName = order.getOrderItems().stream()
                .map(item -> item.getItem().getClass().getSimpleName())
                .mapToInt(String::length)
                .max()
                .orElse("Item".length());

        return Math.max(MIN_ITEM_WIDTH, largestItemName);
    }

    private static int getPriceWidth(Order order) {
        int largestPrice = order.getOrderItems().stream()
                .map(item -> String.format("$%.2f", item.getItem().getPrice()))
                .mapToInt(String::length)
                .max()
                .orElse("Price".length());

        return Math.max(MIN_PRICE_WIDTH, largestPrice);
    }

    private static String topBorder(int width) {
        return "╔" + repeat(width) + "╗\n";
    }

    private static String middleBorder(int width) {
        return "╠" + repeat(width) + "╣\n";
    }

    private static String bottomBorder(int width) {
        return "╚" + repeat(width) + "╝\n";
    }

    private static String centerRow(String text, int width) {
        int leftPadding = (width - text.length()) / 2;
        int rightPadding = width - text.length() - leftPadding;

        return "║" + " ".repeat(leftPadding) + text + " ".repeat(rightPadding) + "║\n";
    }

    private static String infoRow(String text, int width) {
        return String.format("║ %-" + (width - 2) + "s ║%n", text);
    }

    private static String tableTopBorder(int itemWidth, int priceWidth) {
        return "╠" + repeat(ID_WIDTH + 2) + "╦" + repeat(itemWidth + 2) + "╦" + repeat(priceWidth + 2) + "╣\n";
    }

    private static String tableMiddleBorder(int itemWidth, int priceWidth) {
        return "╠" + repeat(ID_WIDTH + 2) + "╬" + repeat(itemWidth + 2) + "╬" + repeat(priceWidth + 2) + "╣\n";
    }

    private static String tableBottomBorder(int itemWidth, int priceWidth) {
        return "╠" + repeat(ID_WIDTH + 2) + "╩" + repeat(itemWidth + 2) + "╩" + repeat(priceWidth + 2) + "╣\n";
    }

    private static String repeat(int amount) {
        return "═".repeat(amount);
    }
}