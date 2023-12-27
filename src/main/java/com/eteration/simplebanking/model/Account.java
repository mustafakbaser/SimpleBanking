package com.eteration.simplebanking.model;

import com.eteration.simplebanking.controller.AccountController;
import com.eteration.simplebanking.exception.InsufficientBalanceException;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
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

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactionList = new ArrayList<>();


    // Default constructor for JPA
    public Account(){
    }

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionList = new ArrayList<Transaction>();
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

    public List<Transaction> getTransactions() {
        return transactionList;
    }

    public void setTransactions(List<Transaction> transactionList) {
        this.transactionList = transactionList;
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

    public void setDepositTransactions(List<DepositTransaction> depositTransactions) {
        this.depositTransactions = depositTransactions;
    }

    public void setPhoneBillPaymentTransactions(List<PhoneBillPaymentTransaction> phoneBillPaymentTransactions) {
        this.phoneBillPaymentTransactions = phoneBillPaymentTransactions;
    }

    public void setBillPaymentTransactions(List<BillPaymentTransaction> billPaymentTransactions) {
        this.billPaymentTransactions = billPaymentTransactions;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > this.balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal");
        }
        this.balance -= amount;
    }

    public void debit(double amount)  {
        if (amount > 0 ) {
            balance += amount;
        }
    }

    public void post(Transaction transactions) throws InsufficientBalanceException {
        if(transactions == null) return;

        if(transactions instanceof DepositTransaction){
            debit(transactions.getAmount());
        } else if (transactions instanceof WithdrawalTransaction) {
            withdraw(transactions.getAmount());
        }
        this.transactionList.add(transactions);
    }
}


