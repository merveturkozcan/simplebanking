package com.eteration.simplebanking;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.BillPaymentTransaction;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);


        //For the task#1
//        Account account = new Account("Jim", "12345");
//        account.post(new DepositTransaction(1000));
//        account.post(new WithdrawalTransaction(200));
//        account.post(new BillPaymentTransaction("Vodafone", "5423345566", 96.50));
//        System.out.println(account.getBalance());

    }

}
