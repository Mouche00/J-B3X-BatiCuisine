package services.interfaces;

import models.Component;

public interface ComponentService<T extends Component> extends Service<T> {
    boolean delete(String id);
}
