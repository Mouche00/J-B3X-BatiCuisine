package repositories.interfaces;

import java.sql.SQLException;
import java.util.Optional;

public interface Repository<T> {
    Optional<Integer> save(T t) throws SQLException;
}
