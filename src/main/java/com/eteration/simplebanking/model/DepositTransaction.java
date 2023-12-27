package com.eteration.simplebanking.model;

import com.eteration.simplebanking.exception.InsufficientBalanceException;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DepositTransaction extends Transaction{

    public DepositTransaction(){
        super();
    }

    public DepositTransaction(double amount) {
        super(amount);
    }

    public void execute(Account account){
        account.deposit(super.getAmount());
    }
}
