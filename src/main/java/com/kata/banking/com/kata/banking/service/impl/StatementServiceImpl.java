package com.kata.banking.com.kata.banking.service.impl;

import com.kata.banking.com.kata.banking.service.api.OperationService;
import com.kata.banking.com.kata.banking.service.api.StatementService;
import com.kata.banking.model.Account;
import com.kata.banking.model.Operation;

import java.io.PrintStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class StatementServiceImpl implements StatementService {
    private StatementServiceImpl() {
    }

    private static StatementService instance;

    public static StatementService getInstance() {
        if (isNull(instance))
            instance = new StatementServiceImpl();
        return instance;
    }

    public static final String STATEMENT_HEADER = String.format("%10s | %20s | %10s | %10s\n","operation","date","amount","balance");

    OperationService operationService = OperationServiceImpl.getInstance();

    @Override
    public void printStatement(Account account, PrintStream stream) {
        StringBuilder builder = new StringBuilder();
        List<Operation> operationList = operationService.getAccountOperationHistory(account.getId());
        builder.append(STATEMENT_HEADER);
        builder.append(operationList.stream().map(operation ->
                String.format("%10s | %20s | %10.2f | %10.2f\n",
                        operation.getType().getTypeName(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(operation.getDate()),
                        operation.getAmount(),
                        operation.getBalance())
        ).collect(Collectors.joining()));
        stream.println(builder.toString());
    }
}