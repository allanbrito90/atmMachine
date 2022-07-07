package com.zinkwork.atm.exception;

public class InvalidValueException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "The value must be multiple of 5";

    public InvalidValueException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidValueException(String message) {
        super(message);
    }
}
