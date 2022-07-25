package com.zinkwork.atm.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidValueException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "The value must be multiple of 5";

    private static Logger LOGGER = LoggerFactory.getLogger(InvalidValueException.class);

    public InvalidValueException() {
        super(DEFAULT_MESSAGE);
        LOGGER.error(DEFAULT_MESSAGE);
    }

    public InvalidValueException(String message) {
        super(message);
    }
}
