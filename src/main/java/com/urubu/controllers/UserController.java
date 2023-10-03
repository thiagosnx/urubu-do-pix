package com.urubu.controllers;


import com.urubu.domain.User;
import com.urubu.repositories.UserRepository;
import com.urubu.requests.RequestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity getUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping
    public ResponseEntity registerUser(@RequestBody @Validated RequestUser data){
        User newUser = new User(data);
        userRepository.save(newUser);

        return ResponseEntity.ok("Vítima cadastrada com sucesso!");
    }


}
