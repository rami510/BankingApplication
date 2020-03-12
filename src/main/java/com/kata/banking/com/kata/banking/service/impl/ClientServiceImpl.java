package com.kata.banking.com.kata.banking.service.impl;

import com.kata.banking.com.kata.banking.service.api.ClientService;
import com.kata.banking.model.Client;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class ClientServiceImpl implements ClientService {

    // we should delegate data input output to a repository layer (no database is needed on our case we chose to make it simple)
    private List<Client> clientList = new ArrayList<Client>();


    @Override
    public void createClient(Client client) {
        Client existingClient = this.findClient(client.getId());
        if (isNull(existingClient))
            this.clientList.add(client);
    }

    @Override
    public Client findClient(String clientId) {
        return this.clientList.stream().filter((a) -> a.getId().equals(clientId)).findFirst().orElse(null);
    }
}
