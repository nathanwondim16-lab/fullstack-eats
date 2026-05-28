package com.pluralsight.exceptions;

public class InvalidBreadTypeException extends RuntimeException {
    public InvalidBreadTypeException(String message) {
        super(message);
    }
}
