package com.eteration.simplebanking.services;

import com.eteration.simplebanking.Utilities.TransactionType;
import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.repository.AccountRepository;
import com.eteration.simplebanking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionStatus updateAccountBalance(String accountNumber, Transaction transaction) {

        //save the transaction to the repository
        transaction.setAccountID(accountNumber);
        transactionRepository.save(transaction);

        Account temp = accountRepository.findByAccountNumber(accountNumber);

        if (transaction.getType() == TransactionType.DEPOSIT) {
            //update the account with the requested amount
            temp.setBalance(temp.getBalance() + transaction.getAmount());

        } else if (transaction.getType() == TransactionType.WITHDRAW) {
            double amount = temp.getBalance() - transaction.getAmount();
            if (amount >= 0)
                temp.setBalance(amount);
            else
                System.out.println("exception: amount less than zero");
        }
        temp.setTransactions(getTransactionList(accountNumber));
        accountRepository.save(temp);

        return new TransactionStatus();
    }

    @Override
    public List<Transaction> getTransactionList(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }
}
