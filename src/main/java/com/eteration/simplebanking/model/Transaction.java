package com.eteration.simplebanking.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "transaction_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private double amount;

    public Transaction() {
    }

    public Transaction(double amount) {
        this.date = new Date();
        this.amount = amount;
    }
}
