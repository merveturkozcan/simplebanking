package com.eteration.simplebanking.services;

import com.eteration.simplebanking.Utilities.TransactionType;
import com.eteration.simplebanking.exceptions.InsufficientBalanceException;
import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.repository.AccountRepository;
import com.eteration.simplebanking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.eteration.simplebanking.Utilities.UtilityFunctions.generateApprovalCode;

@Service

public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public String updateAccountBalance(String accountNumber, Transaction transaction) {

        //save the transaction to the repository
        transaction.setAccountID(accountNumber);


        HttpStatus status;
        String approvalCode = "";

        Account temp = accountRepository.findByAccountNumber(accountNumber);

        if (transaction.getType() == TransactionType.DEPOSIT) {
            //update the account with the requested amount
            temp.setBalance(temp.getBalance() + transaction.getAmount());
            status = HttpStatus.OK;
            approvalCode = generateApprovalCode();

        } else if (transaction.getType() == TransactionType.WITHDRAW) {
            double amount = temp.getBalance() - transaction.getAmount();
            if (amount >= 0)
            {
                temp.setBalance(amount);
                status = HttpStatus.OK;
                approvalCode = generateApprovalCode();
            }
            else {
                status = HttpStatus.EXPECTATION_FAILED;
                throw new InsufficientBalanceException("Insufficient balance for withdrawal");
            }
        } else  //for BillPayment
        {
            double amount = temp.getBalance() - transaction.getAmount();
            if (amount >= 0)
            {
                temp.setBalance(amount);
                status = HttpStatus.OK;
                approvalCode = generateApprovalCode();
            }
            else {
                status = HttpStatus.EXPECTATION_FAILED;
                throw new InsufficientBalanceException("Insufficient balance for bill payment");
            }
        }

        transaction.setApprovalCode(approvalCode);
        transaction.setTransactionStatus(status);

        temp.setTransactions(getTransactionList(accountNumber));

        transactionRepository.save(transaction);
        accountRepository.save(temp);

        return transaction.toString();
    }

    @Override
    public List<Transaction> getTransactionList(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }
}
