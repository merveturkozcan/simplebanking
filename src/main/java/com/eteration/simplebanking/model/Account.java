package com.eteration.simplebanking.model;

import com.eteration.simplebanking.Utilities.TransactionType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Account {

    @Id
    private String accountNumber;
    private String owner;
    private Double balance = 0.0;
    LocalDateTime createDate;
    @OneToMany(targetEntity = Transaction.class)
    private List<Transaction> transactions;

    //default constructor
    public Account() {
        this.createDate = LocalDateTime.now();
    }

    //overloaded the constructor to have owner and account number on initialization and set balance to 0.0
    public Account(String _owner, String _accountNumber) {
        setOwner(_owner);
        setAccountNumber(_accountNumber);
        setBalance(0.0);
        this.createDate=LocalDateTime.now();

    }

    //this function I saw on the tests, that is why I added
    public void deposit(double amount) {
        setBalance(balance + amount);
    }

    //this function I saw on the tests, that is why I added
    public void withdraw(double amount) {
        setBalance(balance - amount);
    }

    //this function is for task#1
    public void post(Transaction transaction) {
        //used only for task#1 in DemoApplication
        if (transaction.getType() == TransactionType.DEPOSIT) {
            this.setBalance(this.getBalance() + transaction.getAmount());
        } else if (transaction.getType() == TransactionType.WITHDRAW) {
            this.setBalance(this.getBalance() - transaction.getAmount());
        } else { //in case of bill payment
            this.setBalance(this.getBalance() - transaction.getAmount());
        }
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }


}
