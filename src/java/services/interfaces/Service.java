package services.interfaces;

import models.Client;

import java.sql.SQLException;
import java.util.Optional;

public interface Service<T> {
    Optional<T> save(T t) throws SQLException;
}
