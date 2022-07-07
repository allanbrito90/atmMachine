package com.zinkwork.atm.exception;

public class NotEnoughBanknotesException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "Not enough Banknotes available";

    private String message;

    public NotEnoughBanknotesException() {
        super(DEFAULT_MESSAGE);
    }

    public NotEnoughBanknotesException(String message) {
        super(message);
    }
}
