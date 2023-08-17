package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.AccountService;
import com.eteration.simplebanking.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eteration.simplebanking.exceptions.AccountNumberNotFoundException;
import com.eteration.simplebanking.exceptions.InsufficientBalanceException;

import java.util.*;

@RestController
@RequestMapping("/account/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;


    //to add bank account ( optional )
    @PostMapping()
    public ResponseEntity<String> add(@RequestBody Account account) {
        accountService.saveAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success");

    }

    //to get all accounts ( optional )
    @GetMapping()
    public List<Account> getAll() {
        return accountService.getAllAccounts();

    }

    //credit - deposit - para ekleme
    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<String> credit(@PathVariable String accountNumber, @RequestBody DepositTransaction transaction) {
        String status = transactionService.updateAccountBalance(accountNumber, transaction);
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }


    // debit (withdraw) para çekme
    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<String> debit(@PathVariable String accountNumber,
                                                   @RequestBody WithdrawalTransaction transaction) {
        String status = transactionService.updateAccountBalance(accountNumber, transaction);
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }


    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        Account temp = accountService.findAccount(accountNumber);
        if (temp == null)
            throw new AccountNumberNotFoundException(accountNumber);
        else
            return new ResponseEntity<Account>(temp, HttpStatus.OK);


    }


}