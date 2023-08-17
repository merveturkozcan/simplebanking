package com.eteration.simplebanking.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// This class is a place holder you can change the complete implementation

public class TransactionStatus {

    String status;


    public ResponseEntity<TransactionStatus> getStatus()
    {
        return new ResponseEntity<TransactionStatus>(HttpStatus.OK);
    }






}
