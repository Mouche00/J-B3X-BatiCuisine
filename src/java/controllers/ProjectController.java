package controllers;

import models.Project;
import services.interfaces.ClientService;
import services.interfaces.ProjectService;
import utils.ID;
import utils.Parser;
import utils.Session;
import utils.Validator;
import utils.enums.InputType;
import utils.enums.ProjectStatus;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProjectController {
    private final ProjectService service;
    public ProjectController(ProjectService service) {
        this.service = service;
    }

    public void create(Project project) {
        Session.getClient().flatMap(client -> {
            project.setClient(client);
            return service.save(project);
        }).ifPresent(p -> {
            System.out.println("\n** Project added successfully **");
            Session.setProject(p);
        });
    }

    public void list(List<Project> projects) {
        Validator.listIsEmpty(projects);

        int pos = 0;
        for(Project project : projects) {
            System.out.println("\n#" + pos++ + ": "
                    + "\n\t" + project);
        }
    }

    public List<Project> getAll() {
        return service.getAll();
    }

    public List<Project> getAllCancelled() {
        return service.getAllCancelled();
    }

    public void update(Project project) {
        service.updateStatus(project.getId(), ProjectStatus.COMPLETED);
    }

    public void updateOngoing(Project project) {
        service.updateStatus(project.getId(), ProjectStatus.ONGOING);
    }

    public void delete(Project project) {
        service.updateStatus(project.getId(), ProjectStatus.CANCELLED);
    }
}
