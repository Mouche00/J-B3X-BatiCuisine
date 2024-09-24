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

    public void create() {
        String title = Validator.validateInput("Enter the project' title: ", InputType.STRING);
        double margin = Parser.parseDouble(
                Validator.validateInput("Enter the project' margin: ", InputType.DOUBLE));

            Session.getClient().ifPresent((c) -> {
                try {
                    service.save(new Project(ID.generate(), title, margin, c)).ifPresent(Session::setProject);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            });
    }

    public void list(List<Project> projects) {
        Validator.listIsEmpty(projects);

        int pos = 0;
        for(Project project : projects) {
            System.out.println("\n#" + pos++ + ": "
                    + "\t" + project);
        }
    }

    public void getAll() {
        System.out.println("#-------- Projects List -------#");
        try {
            list(service.getAll());
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update() {
        try {
            List<Project> projects = service.getAll();
            System.out.println("Choose a project:");
            list(projects);
            int option = Parser.parseInt(
                    Validator.validateInput("> ", InputType.OPTION, 0, projects.size()-1));
            service.updateStatus(projects.get(option).getId(), ProjectStatus.CANCELLED);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
