package com.urubu.controllers;

import com.urubu.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;
}
