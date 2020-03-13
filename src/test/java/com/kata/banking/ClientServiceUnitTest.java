package com.kata.banking;

import com.kata.banking.com.kata.banking.service.api.ClientService;
import com.kata.banking.com.kata.banking.service.impl.ClientServiceImpl;
import com.kata.banking.model.Client;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class ClientServiceUnitTest {

    ClientService clientService;

    @Before
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
        assertEquals(filteredClient.getId(), actual.getId());
    }
}
