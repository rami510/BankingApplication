package com.kata.banking;

import com.kata.banking.com.kata.banking.service.api.ClientService;
import com.kata.banking.com.kata.banking.service.impl.ClientServiceImpl;
import com.kata.banking.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientServiceUnitTest {

    ClientService clientService;

    @BeforeEach
    public void createServices() {
        this.clientService = new ClientServiceImpl();
    }

    @Test
    public void testClientCreationAndFind() {
        Client actual = new Client();
        String clientId = UUID.randomUUID().toString();
        actual.setId(clientId);
        clientService.createClient(actual);
        Client filteredClient = clientService.findClient(clientId);
        assertEquals(filteredClient.getId(),actual.getId());
    }
}
