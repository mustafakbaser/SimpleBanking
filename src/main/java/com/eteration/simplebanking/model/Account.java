package com.eteration.simplebanking.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String owner;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    private Double balance;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<DepositTransaction> depositTransactions = new ArrayList<>();


    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<PhoneBillPaymentTransaction> phoneBillPaymentTransactions = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<BillPaymentTransaction> billPaymentTransactions = new ArrayList<>();


    // Default constructor for JPA
    public Account(){
    }

    public Account(String owner, String accountNumber, Double balance) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<DepositTransaction> getDepositTransactions() {
        return depositTransactions;
    }

    public List<PhoneBillPaymentTransaction> getPhoneBillPaymentTransactions() {
        return phoneBillPaymentTransactions;
    }

    public List<BillPaymentTransaction> getBillPaymentTransactions() {
        return billPaymentTransactions;
    }

    /*
    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal");
        }
        this.balance -= amount;
    }
    */
}


