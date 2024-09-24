package repositories.interfaces;

import models.Project;
import utils.enums.ProjectStatus;

import java.sql.SQLException;
import java.util.List;

public interface ProjectRepository extends Repository<Project> {
    List<Project> getAll() throws SQLException;
    boolean updateStatus(String id, ProjectStatus status) throws SQLException;
}
