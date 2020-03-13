package com.kata.banking;

import com.kata.banking.com.kata.banking.service.api.OperationService;
import com.kata.banking.com.kata.banking.service.api.StatementService;
import com.kata.banking.com.kata.banking.service.impl.OperationServiceImpl;
import com.kata.banking.com.kata.banking.service.impl.StatementServiceImpl;
import com.kata.banking.model.Account;
import com.kata.banking.model.Operation;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class StatementServiceUnitTest {

    StatementService statementService;
    OperationService operationService;

    @Before
    public void createServices() {
        this.statementService = StatementServiceImpl.getInstance();
        this.operationService = OperationServiceImpl.getInstance();
    }

    private Account setupAccount() {
        Account account = new Account();
        String accountId = UUID.randomUUID().toString();
        account.setId(accountId);
        return account;
    }

    @SneakyThrows
    @Test
    public void testGetAccountOperationHistory() {
        //GIVEN
        Account account = setupAccount();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        //WHEN

        StringBuilder sb = new StringBuilder();
        operationService.deposit(account, BigDecimal.TEN);
        operationService.withdraw(account, BigDecimal.TEN);
        List<Operation> operationList = operationService.getAccountOperationHistory(account.getId());
        this.statementService.printStatement(account, ps);
        String result = baos.toString("UTF-8");
        String expected = " operation |                 date |     amount |    balance\n" +
                "   Deposit |  " + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(operationList.get(0).getDate()) + " |      10.00 |      10.00\n" +
                "  Withdraw |  " + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(operationList.get(1).getDate()) + " |      10.00 |       0.00\n" +
                "\n";
        ps.close();
        //THEN
        assertEquals(expected.trim(),result.trim());

    }

}
