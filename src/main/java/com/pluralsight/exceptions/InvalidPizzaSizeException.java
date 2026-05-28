package com.pluralsight.exceptions;

public class InvalidPizzaSizeException extends RuntimeException {
    public InvalidPizzaSizeException(String message) {
        super(message);
    }
}
