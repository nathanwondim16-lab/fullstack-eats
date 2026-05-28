package com.pluralsight.exceptions;

public class InvalidSandwichSizeException extends RuntimeException {
    public InvalidSandwichSizeException(String message) {
        super(message);
    }
}
