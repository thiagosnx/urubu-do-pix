package com.urubu.repositories;

import com.urubu.domain.Transaction;
import com.urubu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserById(String id);

//    Optional<User> findUserByUsername(String username);

}
