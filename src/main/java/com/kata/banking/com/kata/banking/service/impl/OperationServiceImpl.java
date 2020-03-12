package com.kata.banking.com.kata.banking.service.impl;

import com.kata.banking.com.kata.banking.service.api.OperationService;
import com.kata.banking.model.Account;
import com.kata.banking.model.Operation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OperationServiceImpl implements OperationService {

    private List<Operation> operationList = new ArrayList<>();

    private void registerOperation(Account account, Operation operation) {
        operation.setAccountId(account.getId());
        operationList.add(operation);
    }

    @Override
    public void withdraw(Account account, BigDecimal amount) {
        if (account.getBalance().compareTo(amount) == 1) {
            Operation withdrawal = new Operation();
            BigDecimal balance = account.getBalance().subtract(amount);
            withdrawal.setAmount(amount);
            withdrawal.setBalance(balance);
            withdrawal.setType(Operation.OperationType.WITHDRAW);
            account.setBalance(balance);
            registerOperation(account, withdrawal);
        }
    }

    @Override
    public void deposit(Account account, BigDecimal amount) {
        Operation deposition = new Operation();
        BigDecimal balance = account.getBalance().add(amount);
        deposition.setAmount(amount);
        deposition.setBalance(balance);
        deposition.setType(Operation.OperationType.DEPOSIT);
        account.setBalance(balance);
        registerOperation(account, deposition);
    }

    @Override
    public List<Operation> getAccountOperationHistory(String accountId) {
        return operationList.stream().filter((operation) -> operation.getAccountId().equals(accountId)).sorted((a, b) -> a.getDate().compareTo(b.getDate())).collect(Collectors.toList());
    }
}
