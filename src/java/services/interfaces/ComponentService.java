package services.interfaces;

import models.Component;

public interface ComponentService<T extends Component> extends Service<T> {
    boolean update(T t);
    boolean delete(String id);
}
