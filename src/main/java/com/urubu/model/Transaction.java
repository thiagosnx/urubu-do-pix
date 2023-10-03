package com.urubu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "urubu")

public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    String orderId;

    String typeTransaction;

    Integer valueTransaction;

}
