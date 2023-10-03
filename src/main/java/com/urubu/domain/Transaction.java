package com.urubu.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transactions")
@Table(name = "transactions")
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String orderId;

    @Enumerated(EnumType.STRING)
    private TransactionType typeTransaction;

    @Column(nullable = false)
    private Integer valueTransaction;

    @ManyToOne
    private User username;

    private LocalDateTime timestamp;

}
