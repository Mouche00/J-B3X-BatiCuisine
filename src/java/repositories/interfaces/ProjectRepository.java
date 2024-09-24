package repositories.interfaces;

import models.Project;
import utils.enums.ProjectStatus;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends Repository<Project> {
    List<Project> getAll() throws SQLException;
    Optional<Project> get(String id) throws SQLException;
    boolean updateStatus(String id, ProjectStatus status) throws SQLException;
}
