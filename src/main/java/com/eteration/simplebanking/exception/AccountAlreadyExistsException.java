package com.eteration.simplebanking.exception;

public class AccountAlreadyExistsException extends Exception {
    public AccountAlreadyExistsException(String accountAlreadyExistsException){
        super(accountAlreadyExistsException);
    }
}
