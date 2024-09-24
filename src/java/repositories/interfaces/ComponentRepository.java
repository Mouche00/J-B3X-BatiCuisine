package repositories.interfaces;

import models.Component;

import java.sql.SQLException;
import java.util.List;

public interface ComponentRepository<T extends Component> extends Repository<T> {
    boolean delete(String id) throws SQLException;
    List<T> findAll(String id) throws SQLException;
}
