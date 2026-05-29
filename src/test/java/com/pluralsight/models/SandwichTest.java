package com.pluralsight.models;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.SandwichSize;
import com.pluralsight.enums.SandwichToppings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SandwichTest {

    @Test
    void getPrice_ShouldReturnBasePrice_WhenNoToppings() {

        // Arrange
        Sandwich sandwich = new Sandwich(BreadType.WHITE, SandwichSize.FOUR, false);

        // Act
        double actual = sandwich.getPrice();

        // Assert
        assertEquals(5.50, actual);
    }

    @Test
    void getPrice_ShouldIncludeMeatToppingPrice() {

        // Arrange
        Sandwich sandwich = new Sandwich(BreadType.WHITE, SandwichSize.FOUR, false);
        sandwich.addTopping(new Topping<>(SandwichToppings.STEAK, false));

        // Act
        double actual = sandwich.getPrice();

        // Assert
        assertEquals(6.50, actual);
    }

    @Test
    void getPrice_ShouldIncludeExtraMeatPrice() {

        // Arrange
        Sandwich sandwich = new Sandwich(BreadType.WHITE, SandwichSize.FOUR, false);
        sandwich.addTopping(new Topping<>(SandwichToppings.STEAK, true));

        // Act
        double actual = sandwich.getPrice();

        // Assert
        assertEquals(7.00, actual);
    }

    @Test
    void getPrice_ShouldIncludeCheeseToppingPrice() {

        // Arrange
        Sandwich sandwich = new Sandwich(BreadType.WHITE, SandwichSize.FOUR, false);
        sandwich.addTopping(new Topping<>(SandwichToppings.CHEDDAR, false));

        // Act
        double actual = sandwich.getPrice();

        // Assert
        assertEquals(6.25, actual);
    }

    @Test
    void getPrice_ShouldIncludeExtraCheesePrice() {

        // Arrange
        Sandwich sandwich = new Sandwich(BreadType.WHITE, SandwichSize.FOUR, false);
        sandwich.addTopping(new Topping<>(SandwichToppings.CHEDDAR, true));

        // Act
        double actual = sandwich.getPrice();

        // Assert
        assertEquals(6.55, actual);
    }

    @Test
    void getPrice_ShouldNotChargeForRegularToppings() {

        // Arrange
        Sandwich sandwich = new Sandwich(BreadType.WHITE, SandwichSize.FOUR, false);
        sandwich.addTopping(new Topping<>(SandwichToppings.LETTUCE, false));
        sandwich.addTopping(new Topping<>(SandwichToppings.MAYO, false));

        // Act
        double actual = sandwich.getPrice();

        // Assert
        assertEquals(5.50, actual);
    }

    @Test
    void getPrice_ShouldCalculateMultipleToppingsCorrectly() {

        // Arrange
        Sandwich sandwich = new Sandwich(BreadType.WHITE, SandwichSize.FOUR, false);
        sandwich.addTopping(new Topping<>(SandwichToppings.STEAK, true));
        sandwich.addTopping(new Topping<>(SandwichToppings.CHEDDAR, true));
        sandwich.addTopping(new Topping<>(SandwichToppings.LETTUCE, false));

        // Act
        double actual = sandwich.getPrice();

        // Assert
        assertEquals(8.05, actual);
    }

    @Test
    void toasted_ShouldNotAffectPrice() {

        // Arrange
        Sandwich plainSandwich = new Sandwich(BreadType.WHITE, SandwichSize.FOUR, false);
        Sandwich toastedSandwich = new Sandwich(BreadType.WHITE, SandwichSize.FOUR, true);

        // Act
        double plainPrice = plainSandwich.getPrice();
        double toastedPrice = toastedSandwich.getPrice();

        // Assert
        assertEquals(plainPrice, toastedPrice);
    }
}