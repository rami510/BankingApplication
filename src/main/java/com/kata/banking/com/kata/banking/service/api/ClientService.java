package com.kata.banking.com.kata.banking.service.api;

import com.kata.banking.model.Client;

public interface ClientService {

    public void createClient(Client client);

    public Client findClient(String clientId);
}
