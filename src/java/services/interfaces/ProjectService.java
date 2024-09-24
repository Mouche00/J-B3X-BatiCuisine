package services.interfaces;

import models.Project;
import utils.enums.ProjectStatus;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProjectService extends Service<Project> {
    List<Project> getAll();
    Optional<Project> get(String id);
    boolean updateStatus(String id, ProjectStatus status);
}
