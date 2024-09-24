package repositories.interfaces;

import models.Component;

public interface ComponentRepository<T extends Component> extends Repository<T> {
    boolean update(T t);
    boolean delete(String id);
}
