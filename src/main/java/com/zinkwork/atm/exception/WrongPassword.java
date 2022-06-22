package com.zinkwork.atm.exception;

public class WrongPassword extends Exception{

    private static final String DEFAULT_MESSAGE = "Wrong Password";

    public WrongPassword(String message) {
        super(message);
    }

    public WrongPassword() {
        super(DEFAULT_MESSAGE);
    }
}
