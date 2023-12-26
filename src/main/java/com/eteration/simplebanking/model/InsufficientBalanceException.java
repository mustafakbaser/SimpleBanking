package com.eteration.simplebanking.model;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String insufficientBalanceForDebit) {
        super(insufficientBalanceForDebit);
    }
}
