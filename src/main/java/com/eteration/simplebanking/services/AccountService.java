package com.eteration.simplebanking.services;

import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.exception.AccountAlreadyExistsException;
import com.eteration.simplebanking.exception.AccountNotFoundException;
import com.eteration.simplebanking.exception.InsufficientBalanceException;
import com.eteration.simplebanking.model.Account;

public interface AccountService {

    Account findAccount(String accountNumber);

    Account createAccount(Account account) throws AccountAlreadyExistsException;

    TransactionStatus credit(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException;

    TransactionStatus debit(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException;
}
