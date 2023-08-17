package com.eteration.simplebanking.services;


import com.eteration.simplebanking.model.Transaction;

import java.util.List;

public interface TransactionService {

    public String updateAccountBalance(String accountNumber, Transaction transaction);

    public List<Transaction> getTransactionList(String accountNumber);

}
