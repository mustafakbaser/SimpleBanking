package com.eteration.simplebanking.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PhoneBillPaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phoneNumber;

    private Double amount;

    private String approvalCode;

    private String type;

    private LocalDateTime date;

    private String payee;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public PhoneBillPaymentTransaction() {
    }

    public PhoneBillPaymentTransaction(String phoneNumber, Double amount, String approvalCode, String type, LocalDateTime date, String payee, Account account) {
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.approvalCode = approvalCode;
        this.type = type;
        this.date = date;
        this.payee = payee;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
