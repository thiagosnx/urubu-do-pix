package com.urubu.requests;

import com.urubu.domain.Transaction;
import com.urubu.domain.TransactionType;
import com.urubu.domain.User;

import java.math.BigDecimal;

public record RequestTransaction(String order_id, TransactionType type, BigDecimal amount, String userId) {

}
