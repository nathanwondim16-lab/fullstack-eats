package com.pluralsight.models;

import com.pluralsight.enums.ChipFlavors;
import com.pluralsight.exceptions.EmptyOrderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    public void addItemToOrder_ShouldAddItemToOrder() {
        // Arrange
        Order order = new Order();

        // Act
        order.addItemToOrder(new Chips(ChipFlavors.CHEETOS));

        // Assert
        assertEquals(1, order.getOrderItems().size());
    }

    @Test
    public void removeItemFromOrder_ShouldRemoveItemFrom() {
        // Arrange
        Order order = new Order();
        order.addItemToOrder(new Chips(ChipFlavors.DORITOS));

        // Act
        boolean isRemoved = order.removeItemFromOrder(1);

        // Assert
        assertTrue(isRemoved);
        assertTrue(order.isEmpty());
    }

    @Test
    public void validateOrder_ShouldThrowException_whenOrderIsEmpty() {
        // Arrange
        Order order = new Order();

        // Act & Assert
        assertThrows(EmptyOrderException.class, order::validateOrder);
    }

    @Test
    public void confirmOrder_ShouldSetOrderDate() {
        // Arrange
        Order order = new Order();

        // Act
        order.confirmOrder();

        // Assert
        assertNotNull(order.getOrderDate());
    }
}