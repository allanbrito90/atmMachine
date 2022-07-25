package com.zinkwork.atm.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StandardError {
    private Date currentDate;
    private String message;

    public StandardError() {
    }

    public StandardError(Date currentDate, String message) {
        this.currentDate = currentDate;
        this.message = message;
    }
}
