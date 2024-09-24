package services.implementations;

import models.Project;
import repositories.interfaces.ClientRepository;
import repositories.interfaces.ProjectRepository;
import services.interfaces.ProjectService;
import utils.enums.ProjectStatus;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;
    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Project> getAll() throws SQLException {
        return repository.getAll();
    }

    @Override
    public boolean updateStatus(String id, ProjectStatus status) throws SQLException {
        return repository.updateStatus(id, status);
    }

    @Override
    public Optional<Project> save(Project project) throws SQLException {
        return repository.save(project);
    }
}
