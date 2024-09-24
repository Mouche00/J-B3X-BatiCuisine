package repositories.interfaces;

import models.Component;

import java.sql.SQLException;

public interface ComponentRepository<T extends Component> extends Repository<T> {
    boolean update(T t);
    boolean delete(String id) throws SQLException;
}
