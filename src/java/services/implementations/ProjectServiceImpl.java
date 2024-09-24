package services.implementations;

import models.Material;
import models.Project;
import models.Workforce;
import repositories.interfaces.ComponentRepository;
import repositories.interfaces.ProjectRepository;
import services.interfaces.ProjectService;
import utils.enums.ProjectStatus;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;
    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Project> getAll() {
        List<Project> projects = new ArrayList<>();
        try {
            projects = repository.getAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return projects;
    }

    @Override
    public List<Project> getAllCancelled() {
        List<Project> projects = new ArrayList<>();
        try {
            projects = repository.getAllCancelled();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return projects;
    }

    @Override
    public Optional<Project> get(String id) {
        try {
            return repository.get(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public boolean updateStatus(String id, ProjectStatus status) {
        try {
            return repository.updateStatus(id, status);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Optional<Project> save(Project project) {
        try {
            return repository.save(project);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
}
