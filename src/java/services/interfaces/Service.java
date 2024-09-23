package services.interfaces;

import java.sql.SQLException;
import java.util.Optional;

public interface Service<T> {
    Optional<Integer> save(T t) throws SQLException;
}
