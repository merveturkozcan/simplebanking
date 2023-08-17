package com.eteration.simplebanking.model;

import com.eteration.simplebanking.Utilities.TransactionType;

import java.time.LocalDateTime;

public class BillPaymentTransaction extends WithdrawalTransaction {

    String payee;
    String description;

    public BillPaymentTransaction(String payee, String description, double amount) {
        this.amount = amount;
        this.type = TransactionType.BILLPAYMENT;

    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
