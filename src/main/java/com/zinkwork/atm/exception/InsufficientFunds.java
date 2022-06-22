package com.zinkwork.atm.exception;

public class InsufficientFunds extends Exception{

    private static final String DEFAULT_MESSAGE = "Insufficient Funds";

    public InsufficientFunds(String message) {
        super(message);
    }

    public InsufficientFunds() {
        super(DEFAULT_MESSAGE);
    }
}
