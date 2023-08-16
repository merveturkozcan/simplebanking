package com.eteration.simplebanking.services;


import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.Account;

import java.util.List;

// This class is a place holder you can change the complete implementation
public interface TransactionService {

    public TransactionStatus updateAccountBalance(String accountNumber, Transaction transaction);

    public List<Transaction> getTransactionList(String accountNumber);

}
