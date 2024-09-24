package services.interfaces;

import models.Project;
import utils.enums.ProjectStatus;

import java.sql.SQLException;
import java.util.List;

public interface ProjectService extends Service<Project> {
    List<Project> getAll() throws SQLException;
    boolean updateStatus(String id, ProjectStatus status) throws SQLException;
}
