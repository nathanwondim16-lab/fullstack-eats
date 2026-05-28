package com.pluralsight.exceptions;

public class InvalidTacoType extends RuntimeException {
    public InvalidTacoType(String message) {
        super(message);
    }
}
