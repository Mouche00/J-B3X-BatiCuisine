package services.interfaces;

import models.Client;

import java.sql.SQLException;
import java.util.Optional;

public interface ClientService extends Service<Client> {
    Optional<Client> findByName(String name);
}
