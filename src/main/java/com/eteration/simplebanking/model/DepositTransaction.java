package com.eteration.simplebanking.model;


import com.eteration.simplebanking.Utilities.TransactionType;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity

// This class is a place holder you can change the complete implementation
public class DepositTransaction extends Transaction {

    public DepositTransaction() {
        this.date = LocalDateTime.now();
        this.type = TransactionType.DEPOSIT;
    }

    public DepositTransaction(double amount) {
        this.date = LocalDateTime.now();
        this.type = TransactionType.DEPOSIT;
        this.amount = amount;
    }

}
