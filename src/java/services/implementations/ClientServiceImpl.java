package services.implementations;

import models.Client;
import repositories.interfaces.ClientRepository;
import services.interfaces.ClientService;

import java.sql.SQLException;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {
    private ClientRepository repository;
    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Client> findByName(String name) throws SQLException {
        return repository.findByName(name);
    }

    @Override
    public Optional<Integer> save(Client client) throws SQLException {
        Optional<Client> existingClient = repository.findByName(client.getName());
        if(existingClient.isPresent()) return Optional.of(existingClient.get().getId());
        return repository.save(client);
    }
}
