package com.kata.banking.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Data
public class Operation {
    public enum OperationType {
        WITHDRAW("Withdraw"),
        DEPOSIT("Deposit");
        private String typeName;
        public String getTypeName(){
            return typeName;
        }
        OperationType(String type) {
            this.typeName = type;
        }
    }

    private String id;
    private LocalDateTime date = LocalDateTime.now();
    private OperationType type;
    private BigDecimal amount;
    private BigDecimal balance = new BigDecimal(0);
    private String accountId;


    @Override
    public String toString() {

        return type +
                " | " + date +
                " | " + amount +
                " | " + balance +
                " | '" + accountId + '\'' + '\n';
    }
}
