package com.eteration.simplebanking.services;


import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.Transaction;

import java.util.List;


public interface AccountService {

    public Account saveAccount(Account account);

    public List<Account> getAllAccounts();

    public Account findAccount(String accountNumber);

    public Account updateAccountBalance(double amount);

    //public Account post(Transaction transaction);

    // public void credit(Double amount);

    // public void debit (Double amount);


}
