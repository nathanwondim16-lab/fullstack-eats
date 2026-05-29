package com.pluralsight.models;

import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.PizzaSize;
import com.pluralsight.enums.PizzaToppings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    @Test
    public void getPrice_ShouldReturnBasePrice_whenNoToppingsOnPizza() {
        // Arrange
        Pizza pizza = new Pizza(CrustType.REGULAR, PizzaSize.EIGHT, false);

        // Act
        double actual = pizza.getPrice();

        // Assert
        assertEquals(8.50, actual);
    }

    @Test
    public void getPrice_ShouldIncludeMeatToppingPrice() {
        // Arrange
        Pizza pizza = new Pizza(CrustType.REGULAR, PizzaSize.EIGHT, false);
        pizza.addTopping(new Topping<>(PizzaToppings.PEPPERONI, false));

        // Act
        double actual = pizza.getPrice();

        // Assert
        assertEquals(9.50, actual);
    }

    @Test
    public void getPrice_ShouldIncludeExtraMeatPrice() {
        // Arrange
        Pizza pizza = new Pizza(CrustType.REGULAR, PizzaSize.EIGHT, false);
        pizza.addTopping(new Topping<>(PizzaToppings.PEPPERONI, true));

        // Act
        double actual = pizza.getPrice();

        // Assert
        assertEquals(10.00, actual);
    }

    @Test
    public void getPrice_ShouldIncludeCheesePrice() {
        // Arrange
        Pizza pizza = new Pizza(CrustType.REGULAR, PizzaSize.EIGHT, false);
        pizza.addTopping(new Topping<>(PizzaToppings.MOZZARELLA, false));

        // Act
        double actual = pizza.getPrice();

        // Assert
        assertEquals(9.25, actual);
    }

    @Test
    public void getPrice_ShouldCalculateMultipleToppings() {
        // Arrange
        Pizza pizza = new Pizza(CrustType.REGULAR, PizzaSize.EIGHT, false);
        pizza.addTopping(new Topping<>(PizzaToppings.MOZZARELLA, true));
        pizza.addTopping(new Topping<>(PizzaToppings.PEPPERONI, true));

        // Act
        double actual = pizza.getPrice();

        // Assert
        assertEquals(11.05, actual);
    }

    @Test
    public void stuffedCrust_ShouldNotAffectPrice() {
        // Arrange
        Pizza regularPizza = new Pizza(CrustType.REGULAR, PizzaSize.EIGHT, false);
        Pizza stuffedPizza = new Pizza(CrustType.REGULAR, PizzaSize.EIGHT, true);

        // Act
        double regularPizzaPrice = regularPizza.getPrice();
        double stuffedPizzaPrice = stuffedPizza.getPrice();

        // Assert
        assertEquals(regularPizzaPrice, stuffedPizzaPrice);
    }
}