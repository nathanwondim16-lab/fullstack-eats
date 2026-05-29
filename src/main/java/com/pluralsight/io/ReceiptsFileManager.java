package com.pluralsight.io;

import com.pluralsight.enums.Colors;
import com.pluralsight.exceptions.ReceiptNotFoundException;
import com.pluralsight.formatters.ReceiptFormatter;
import com.pluralsight.interfaces.FileRepository;
import com.pluralsight.models.Order;
import com.pluralsight.ui.UserInterface;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;


public class ReceiptsFileManager implements FileRepository<Order> {
    private static final DateTimeFormatter FILE_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");

    @Override
    public Path save(Order order) {
        try {
            String fileName = order.getOrderDate().format(FILE_DATE_FORMAT) + ".txt";

            Path receiptsFolder = Path.of("data", "Receipts");
            Files.createDirectories(receiptsFolder);

            Path receiptPath = receiptsFolder.resolve(fileName);

            try (PrintWriter writer = new PrintWriter(receiptPath.toFile())) {
                writer.println(ReceiptFormatter.format(order));
            }
            return receiptPath;
        } catch (Exception e) {
            UserInterface.handleException(e);
            return null;
        }
    }

    public void printReceipt(Path path) {
        if(path == null) {
            UserInterface.handleException(new ReceiptNotFoundException("Receipt file could not be found."));
            return;
        }

        try {
            UserInterface.printToConsole(Files.readString(path), Colors.WHITE);
        } catch (IOException e) {
            UserInterface.handleException(e);
        }
    }
}