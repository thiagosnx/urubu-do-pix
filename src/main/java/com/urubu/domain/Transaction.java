package com.urubu.domain;

import com.urubu.requests.RequestTransaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
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
    private String order_id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(nullable = false)
    private BigDecimal amount;

    @ManyToOne
    private User users;

    private LocalDateTime timenow;

    public Transaction(RequestTransaction requestTransaction) {
        this.amount = requestTransaction.amount();
        this.type = requestTransaction.type();

    }
}
