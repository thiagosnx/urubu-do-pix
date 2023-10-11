package com.urubu.domain;

import com.urubu.dtos.TransactionDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
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
    @JoinColumn(name="users_id")
    private User users; //user que fará a transação puxando direto da classe User

    private LocalDateTime date_time;

    private BigDecimal balance_before;

//    private String username;

    public Transaction(TransactionDTO transactionDTO) {
        this.amount = transactionDTO.amount();
        this.type = transactionDTO.type();

    }
}
