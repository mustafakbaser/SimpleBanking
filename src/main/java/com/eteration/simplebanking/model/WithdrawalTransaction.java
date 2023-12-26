package com.eteration.simplebanking.model;


import javax.persistence.Entity;

@Entity
public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction() { // Default constructor for JPA
    }

    public WithdrawalTransaction(double amount) {
        super(amount);
    }
}


