package com.eteration.simplebanking.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "withdrawal_transaction")
public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction( double amount) {
        super(amount);
    }

    public WithdrawalTransaction() {
    }
}


