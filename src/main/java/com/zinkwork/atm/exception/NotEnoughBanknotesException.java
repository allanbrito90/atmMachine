package com.zinkwork.atm.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotEnoughBanknotesException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "Not enough Banknotes available";

    private static Logger LOGGER = LoggerFactory.getLogger(NotEnoughBanknotesException.class);

    private String message;

    public NotEnoughBanknotesException() {
        super(DEFAULT_MESSAGE);
        LOGGER.error(DEFAULT_MESSAGE);
    }

    public NotEnoughBanknotesException(String message) {
        super(message);
    }
}
