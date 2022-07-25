package com.zinkwork.atm.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WrongPassword extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "Wrong Account or Password";

    private static Logger LOGGER = LoggerFactory.getLogger(WrongPassword.class);

    public WrongPassword(String message) {
        super(message);
    }

    public WrongPassword() {
        super(DEFAULT_MESSAGE);
        LOGGER.error(DEFAULT_MESSAGE);
    }
}
