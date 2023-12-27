package com.eteration.simplebanking.exception;

public class TransactionFailedException extends Exception{
    public TransactionFailedException(String transactionFailedException) {
        super(transactionFailedException);
    }
}
