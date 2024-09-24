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

    public void getAll() {
        list(service.getAll());
    }

    public void update() {
        List<Project> projects = service.getAll();
        System.out.println("\nChoose a project:");
        list(projects);
        int option = Parser.parseInt(
                Validator.validateInput("> ", InputType.OPTION, 0, projects.size()-1));
        service.updateStatus(projects.get(option).getId(), ProjectStatus.CANCELLED);
    }

    public void delete(Project project) {
        service.updateStatus(project.getId(), ProjectStatus.CANCELLED);
    }

    public void find() {
        String id = Validator.validateInput("\nEnter the project' id: ", InputType.STRING);

        Session.setProject(service.get(id).get());
    }
}
