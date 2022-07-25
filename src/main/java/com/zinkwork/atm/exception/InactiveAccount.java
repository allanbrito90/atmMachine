package com.zinkwork.atm.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InactiveAccount extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "Inactive account";

    private static Logger LOGGER = LoggerFactory.getLogger(InactiveAccount.class);

    public InactiveAccount(String message) {
        super(message);
    }

    public InactiveAccount() {
        super(DEFAULT_MESSAGE);
        LOGGER.error(DEFAULT_MESSAGE);
    }
}
