package com.urubu.domain;


import com.urubu.requests.RequestUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "urubu")
@Table(name = "urubu")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String username;

    private BigDecimal balance;


    public User(RequestUser requestUser) {
        this.username = requestUser.username();
        this.balance = requestUser.balance();
    }
}
