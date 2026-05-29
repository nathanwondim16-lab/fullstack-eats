package com.pluralsight.io;

import com.pluralsight.enums.ChipFlavors;
import com.pluralsight.models.Chips;
import com.pluralsight.ui.UserInterface;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.pluralsight.models.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class ReceiptsFileManagerTest {


    @Test
    @Disabled
    public void savingOrder_ShouldCreateReceiptFile() {
        // Arrange
        Order order = new Order("Nathan");
        order.confirmOrder();
        ReceiptsFileManager manager = new ReceiptsFileManager();

        // Act
        Path receiptLocation = manager.save(order);

        // Assert
        assertNotNull(receiptLocation);
        assertTrue(Files.exists(receiptLocation));
    }

    @Test
    @Disabled
    public void savingOrder_ShouldReturnFile() {
        // Arrange
        Order order = new Order("Nathan");
        order.confirmOrder();
        ReceiptsFileManager manager = new ReceiptsFileManager();

        // Act
        Path receiptLocation = manager.save(order);

        // Assert
        assertTrue(receiptLocation.toString().endsWith(".txt"));
    }

    @Test
    @Disabled
    public void savingOrder_ShouldWriteCustomerName() {
        // Arrange
        Order order = new Order("Nathan");
        order.confirmOrder();
        ReceiptsFileManager manager = new ReceiptsFileManager();

        // Act
        Path receiptLocation = manager.save(order);
        String receiptContents = "";

        try {
            receiptContents = Files.readString(receiptLocation);
        } catch (IOException e) {
            UserInterface.handleException(e);
        }

        // Assert
        assertTrue(receiptContents.contains("Nathan"));
    }

    @Test
    @Disabled
    public void savingOrder_ShouldWriteTotal() {
        // Arrange
        Order order = new Order("Nathan");
        order.confirmOrder();
        ReceiptsFileManager manager = new ReceiptsFileManager();

        // Act
        Path receiptLocation = manager.save(order);
        String receiptContents = "";

        try {
            receiptContents = Files.readString(receiptLocation);
        } catch (IOException e) {
            UserInterface.handleException(e);
        }

        // Assert
        assertTrue(receiptContents.contains("TOTAL"));
    }

    @Test
    @Disabled
    public void savingOrder_ShouldWriteOrderItems() {
        // Arrange
        Order order = new Order("Nathan");
        order.addItemToOrder(new Chips(ChipFlavors.SUN_CHIPS));
        order.confirmOrder();
        ReceiptsFileManager manager = new ReceiptsFileManager();

        // Act
        Path receiptLocation = manager.save(order);
        String receiptContents = "";

        try {
            receiptContents = Files.readString(receiptLocation);
        } catch (IOException e) {
            UserInterface.handleException(e);
        }

        // Assert
        assertTrue(receiptContents.contains("Chips"));
    }
}