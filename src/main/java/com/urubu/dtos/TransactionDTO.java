package com.urubu.dtos;

import com.urubu.domain.TransactionType;

import java.math.BigDecimal;

public record TransactionDTO(String order_id, TransactionType type, BigDecimal amount, String userId) {

}
