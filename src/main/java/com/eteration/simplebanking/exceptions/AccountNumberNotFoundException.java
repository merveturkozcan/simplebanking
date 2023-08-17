package com.eteration.simplebanking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class AccountNumberNotFoundException extends ResponseStatusException {

        public AccountNumberNotFoundException(String accountNumber) {
            super(HttpStatus.NOT_FOUND, "Account number " + accountNumber + " not found");
        }
 }




