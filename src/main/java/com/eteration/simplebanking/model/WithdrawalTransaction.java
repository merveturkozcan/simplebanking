package com.eteration.simplebanking.model;


import com.eteration.simplebanking.Utilities.TransactionType;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity

// This class is a place holder you can change the complete implementation
public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction() {
        this.date = LocalDateTime.now();
        this.type = TransactionType.WITHDRAW;
    }

    public WithdrawalTransaction(double amount) {
        this.date = LocalDateTime.now();
        this.type = TransactionType.WITHDRAW;
        this.amount = amount;
    }

}


