package com.urubu.controllers;

import com.urubu.domain.Transaction;
import com.urubu.repositories.TransactionRepository;
import com.urubu.requests.RequestTransaction;
import com.urubu.requests.RequestUser;
import com.urubu.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody RequestTransaction transaction, RequestUser username) throws Exception {
        Transaction newTransaction = this.transactionService.createTransaction(transaction, username);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }
}
