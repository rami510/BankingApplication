package com.kata.banking.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class Operation {
    public enum OperationType {
        WITHDRAW("Withdraw"),
        DEPOSIT("Deposit");
        private String typeName;

        OperationType(String type) {
            this.typeName = type;
        }
    }

    private String id;
    private Instant date = Instant.now();
    private OperationType type;
    private BigDecimal amount;
    private BigDecimal balance = new BigDecimal(0);
    private String accountId;


    @Override
    public String toString() {
        return date +
                ", " + type +
                ", " + amount +
                ", " + balance +
                ", '" + accountId + '\'' + '\n';
    }
}
