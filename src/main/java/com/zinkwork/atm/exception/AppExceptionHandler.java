package com.zinkwork.atm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = InsufficientFunds.class)
    public ResponseEntity<StandardError> insufficientFunds(InsufficientFunds e, HttpServletRequest request){
        String errorDescription = e.getLocalizedMessage();
        if(errorDescription == null) errorDescription = e.toString();
        StandardError errorMessager = new StandardError(new Date(), errorDescription);
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(errorMessager);
    }

    @ExceptionHandler(value = InvalidValueException.class)
    public ResponseEntity<StandardError> invalidValueException(InvalidValueException e, HttpServletRequest request){
        String errorDescription = e.getLocalizedMessage();
        if(errorDescription == null) errorDescription = e.toString();
        StandardError errorMessager = new StandardError(new Date(), errorDescription);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessager);
    }

    @ExceptionHandler(value = NotEnoughBanknotesException.class)
    public ResponseEntity<StandardError> notEnoughBanknotesException(NotEnoughBanknotesException e, HttpServletRequest request){
        String errorDescription = e.getLocalizedMessage();
        if(errorDescription == null) errorDescription = e.toString();
        StandardError errorMessager = new StandardError(new Date(), errorDescription);
        return ResponseEntity.status(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS).body(errorMessager);
    }

    @ExceptionHandler(value = WrongPassword.class)
    public ResponseEntity<StandardError> wrongPassword(WrongPassword e, HttpServletRequest request){
        String errorDescription = e.getLocalizedMessage();
        if(errorDescription == null) errorDescription = e.toString();
        StandardError errorMessager = new StandardError(new Date(), errorDescription);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorMessager);
    }

    @ExceptionHandler(value = InactiveAccount.class)
    public ResponseEntity<StandardError> inactiveAccount(InactiveAccount e, HttpServletRequest request){
        String errorDescription = e.getLocalizedMessage();
        if(errorDescription == null) errorDescription = e.toString();
        StandardError errorMessager = new StandardError(new Date(), errorDescription);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessager);
    }

}
