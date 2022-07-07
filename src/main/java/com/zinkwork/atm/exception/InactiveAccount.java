package com.zinkwork.atm.exception;

public class InactiveAccount extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "Inactive account";

    public InactiveAccount(String message) {
        super(message);
    }

    public InactiveAccount() {
        super(DEFAULT_MESSAGE);
    }
}
