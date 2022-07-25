package com.zinkwork.atm.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsufficientFunds extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "Insufficient Funds";
    private static Logger LOGGER = LoggerFactory.getLogger(InsufficientFunds.class);

    public InsufficientFunds(String message) {
        super(message);
    }

    public InsufficientFunds() {
        super(DEFAULT_MESSAGE);
        LOGGER.error(DEFAULT_MESSAGE);
    }
}
