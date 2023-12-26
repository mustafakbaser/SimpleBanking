package com.eteration.simplebanking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="id")
    private Integer id;

    //@Column(name="account_number")
    private String account_number;

    //@Column(name="owner")
    private String owner;

    //@Column(name="balance")
    private double balance;

    // List Transaction
    /*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    @JsonIgnoreProperties({"account"})
    private List<Transaction> transactionList;
    */

    public Account(){
    }

    public Account(String owner, String account_number){
        this.owner = owner;
        this.account_number = account_number;
        //this.transactionList = new ArrayList<Transaction>();
        this.balance = 0.0;
    }

    public Account(Integer id, String account_number, String owner, double balance, List<Transaction> transactionList) {
        this.id = id;
        this.account_number = account_number;
        this.owner = owner;
        this.balance = balance;
        //this.transactionList = transactionList;
    }
}


