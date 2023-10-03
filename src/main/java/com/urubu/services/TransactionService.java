package com.urubu.services;

import com.urubu.domain.Transaction;
import com.urubu.domain.User;
import com.urubu.repositories.TransactionRepository;
import com.urubu.requests.RequestTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UserService userService;

    public void createTransaction(RequestTransaction transaction) throws Exception {
        User user = this.userService.findUserById(transaction.users().getId());

        Transaction newTransaction = new Transaction();
        newTransaction.setUsers(user);
        newTransaction.setAmount(transaction.amount());
        newTransaction.setTimenow(LocalDateTime.now());

        user.setBalance(user.getBalance().add(transaction.amount()));

        repository.save(newTransaction);
        userService.saveUser(user);

    }

}
