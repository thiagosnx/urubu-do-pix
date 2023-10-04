package com.urubu.services;

import com.urubu.domain.Transaction;
import com.urubu.domain.TransactionType;
import com.urubu.domain.User;
import com.urubu.repositories.TransactionRepository;
import com.urubu.dtos.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UserService userService;

    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        User user = this.userService.findUserById(transaction.userId());
        //criando um user para usar um User que será mapeado pelo Id dele

        Transaction newTransaction = new Transaction();//instanciando a classe para setar o body
        newTransaction.setAmount(transaction.amount());
        newTransaction.setType(transaction.type());
        newTransaction.setUsers(user);
        newTransaction.setTimenow(LocalDateTime.now());

        if(transaction.type() == TransactionType.DEPOSIT) {
            user.setBalance(user.getBalance().add(transaction.amount()));
            //adiciona o amount do body ao balance do user
        }
        if(transaction.type() == TransactionType.WITHDRAW){
            user.setBalance(user.getBalance().subtract(transaction.amount()));
            //subtrai o amount do body do balance do user
            //fazer exception para saque maior q o saldo
        }

        this.repository.save(newTransaction);//salva a transação
        this.userService.saveUser(user);//salva o usuario atrelado a transação

        return newTransaction; // retorna a transação e suas informações

    }

}
