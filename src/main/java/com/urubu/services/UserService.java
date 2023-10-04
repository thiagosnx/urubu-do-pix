package com.urubu.services;

import com.urubu.domain.User;
import com.urubu.repositories.UserRepository;
import com.urubu.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User findUserById(String id)throws Exception{
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }


    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);

        return newUser;
    }
    public void saveUser(User user){
        this.repository.save(user);
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }
}
