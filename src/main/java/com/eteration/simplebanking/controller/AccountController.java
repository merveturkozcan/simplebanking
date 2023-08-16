package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.AccountService;
import com.eteration.simplebanking.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/account/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;

    //to add bank account
    @PostMapping()
    public ResponseEntity<String> add(@RequestBody Account account) {
        accountService.saveAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body("approvalCode");

    }

    //to get all accounts
    @GetMapping()
    public List<Account> getAll() {
        return accountService.getAllAccounts();

    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        Account temp = accountService.findAccount(accountNumber);
        if (temp == null)
            return new ResponseEntity<Account>(temp, HttpStatus.NOT_FOUND);
        return new ResponseEntity<Account>(temp, HttpStatus.OK);
    }


    //credit - account number
    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber,
                                                    @RequestBody DepositTransaction transaction) {
        TransactionStatus status = transactionService.updateAccountBalance(accountNumber, transaction);
        if (status == null)
            return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
        return new ResponseEntity<TransactionStatus>(status, HttpStatus.OK);
    }

    // debit - account number
    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber,
                                                   @RequestBody WithdrawalTransaction transaction) {
        TransactionStatus status = transactionService.updateAccountBalance(accountNumber, transaction);
        if (status == null)
            return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
        return new ResponseEntity<TransactionStatus>(status, HttpStatus.OK);
    }


}