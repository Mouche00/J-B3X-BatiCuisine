package services.implementations;

import models.Client;
import repositories.interfaces.ClientRepository;
import services.interfaces.ClientService;
import utils.Cache;

import java.sql.SQLException;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Client> findByName(String name) {
        Optional<Client> client = Cache.getClient(name);
        if(client.isPresent()) return client;
        try {
            client = repository.findByName(name);
            Cache.setClient(name, client);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return client;
    }

    @Override
    public Optional<Client> save(Client client) {
        Optional<Client> existingClient = Optional.empty();
        try {
            existingClient = repository.findByName(client.getName());
            if(existingClient.isPresent()) return existingClient;
            return repository.save(client);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return existingClient;
    }
}
