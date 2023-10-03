package com.urubu.controllers;

import com.urubu.domain.Transaction;
import com.urubu.repositories.TransactionRepository;
import com.urubu.requests.RequestTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public ResponseEntity getTransactions(){
        return ResponseEntity.ok(transactionRepository.findAll());
    }

    @PostMapping
    public ResponseEntity registerTransaction(@RequestBody @Validated RequestTransaction data){
        Transaction newTransaction = new Transaction(data);
        transactionRepository.save(newTransaction);
        return ResponseEntity.ok("Transferência concluída.");
    }
}
