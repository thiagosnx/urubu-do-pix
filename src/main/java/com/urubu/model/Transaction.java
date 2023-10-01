package com.urubu.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "urubu")

public class Transaction {
    @GeneratedValue(strategy = GenerationType.UUID)
    String orderId;

    String typeTransaction;

    Integer valueTransaction;

}
