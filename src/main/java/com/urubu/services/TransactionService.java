package com.urubu.services;

import com.urubu.domain.Transaction;
import com.urubu.domain.TransactionType;
import com.urubu.domain.User;
import com.urubu.repositories.TransactionRepository;
import com.urubu.requests.RequestTransaction;
import com.urubu.requests.RequestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UserService userService;

    public Transaction createTransaction(RequestTransaction transaction) throws Exception {
        User user = this.userService.findUserById(transaction.userId());

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.amount());
        newTransaction.setUsers(user);
        newTransaction.setTimenow(LocalDateTime.now());

        if(transaction.type() == TransactionType.DEPOSIT) {
            user.setBalance(user.getBalance().add(transaction.amount()));
        }
        if(transaction.type() == TransactionType.WITHDRAW){
            user.setBalance(user.getBalance().subtract(transaction.amount()));
        }

        this.repository.save(newTransaction);
        this.userService.saveUser(user);

        return newTransaction;

    }

}
