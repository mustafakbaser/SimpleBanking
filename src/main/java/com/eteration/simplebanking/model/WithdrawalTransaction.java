package com.eteration.simplebanking.model;

import com.eteration.simplebanking.exception.InsufficientBalanceException;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "withdrawal_transaction")
public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction( double amount) {
        super(amount);
    }

    public WithdrawalTransaction() {
    }

    public void execute(Account account) throws InsufficientBalanceException {
        account.withdraw(super.getAmount());
    }
}


