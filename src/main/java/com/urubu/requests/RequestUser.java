package com.urubu.requests;

import java.math.BigDecimal;

public record RequestUser(String id, String username, BigDecimal balance) {
}
