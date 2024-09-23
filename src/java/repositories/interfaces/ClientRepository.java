package repositories.interfaces;

import models.Client;

import java.sql.SQLException;
import java.util.Optional;

public interface ClientRepository extends Repository<Client> {
    Optional<Client> findByName(String name) throws SQLException;
}
