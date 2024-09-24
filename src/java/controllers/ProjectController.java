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
        String title = Validator.validateInput("\nEnter the project' title: ", InputType.STRING);
        double margin = Parser.parseDouble(
                Validator.validateInput("Enter the project' margin: ", InputType.DOUBLE));
        double VAT = Parser.parseDouble(
                Validator.validateInput("Enter the project' VAT tax rate: ", InputType.DOUBLE));
        double discount = Parser.parseDouble(
                Validator.validateInput("Enter the project' discount: ", InputType.DOUBLE));

            Session.getClient().flatMap(client -> service.save(new Project(title, VAT, discount, margin, client))).ifPresent(Session::setProject);
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

    public void find() {
        String id = Validator.validateInput("\nEnter the project' id: ", InputType.STRING);

        Session.setProject(service.get(id).get());
    }
}
