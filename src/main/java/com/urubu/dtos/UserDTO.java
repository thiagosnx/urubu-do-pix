package com.urubu.dtos;

import java.math.BigDecimal;

public record UserDTO(String id, String username, BigDecimal balance) {
}
