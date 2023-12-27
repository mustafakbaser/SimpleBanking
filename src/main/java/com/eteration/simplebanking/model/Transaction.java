package com.eteration.simplebanking.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Alternative: Using InheritanceType.TABLE_PER_CLASS for separate tables per subclass, allowing custom fields in addition to shared attributes.
@DiscriminatorColumn(name = "transaction_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "approval_code")
    private String approvalCode;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Transaction() {
    }

    public Transaction(String type, LocalDateTime date, Account account, double amount, String approvalCode) {
        this.approvalCode = approvalCode;
        this.type = type;
        this.date = date;
        this.account = account;
        this.amount = amount;
    }

    public Transaction(double amount) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", account=" + account +
                ", approvalCode="+approvalCode +
                '}';
    }
}
