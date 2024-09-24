package controllers;

import models.Project;
import services.interfaces.ClientService;
import services.interfaces.ProjectService;
import utils.ID;
import utils.Parser;
import utils.Session;
import utils.Validator;
import utils.enums.InputType;

import java.sql.SQLException;
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

    public void getAll() {
        try {
            service.getAll().forEach(System.out::println);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
