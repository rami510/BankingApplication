package com.kata.banking.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private String id;
    private String name;
    private String clientId;
    private BigDecimal balance = new BigDecimal(0);
}
