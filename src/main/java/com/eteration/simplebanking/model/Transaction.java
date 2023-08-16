package com.eteration.simplebanking.model;


import com.eteration.simplebanking.Utilities.TransactionType;

import javax.persistence.*;
import java.time.LocalDateTime;


// This class is a place holder you can change the complete implementation
@Entity

public abstract class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    LocalDateTime date;
    Double amount;
    TransactionType type;
    String approvalCode;
    String accountNumber;

    public Transaction() {

    }


    @Override
    public String toString() {
        return "Transaction{" +
                " amount='" + amount.toString() + '\'' +
                '}';
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getAccountID() {
        return accountNumber;
    }

    public void setAccountID(String accountNumber) {
        this.accountNumber = accountNumber;
    }


}
