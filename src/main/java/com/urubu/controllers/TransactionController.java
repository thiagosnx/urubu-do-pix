package com.urubu.controllers;

import com.urubu.domain.Transaction;
import com.urubu.domain.User;
import com.urubu.repositories.TransactionRepository;
import com.urubu.dtos.TransactionDTO;
import com.urubu.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransaction = this.transactionService.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransactions(){
        List<Transaction> allTransactions = this.transactionService.getTransactions();
        return new ResponseEntity<>(allTransactions, HttpStatus.OK);
    }

    @GetMapping ("/{order_id}")
    public ResponseEntity<Transaction> findById(@PathVariable String order_id) throws Exception {
        Transaction transactionsByOrderId = this.transactionService.findById(order_id);
        return new ResponseEntity<>(transactionsByOrderId,HttpStatus.OK);

    }
}
