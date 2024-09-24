package controllers;

import models.Workforce;
import services.interfaces.ComponentService;
import utils.Parser;
import utils.Session;
import utils.Validator;
import utils.enums.InputType;

public class WorkforceController {

    private final ComponentService<Workforce> service;
    public WorkforceController(ComponentService<Workforce> service) {
        this.service = service;
    }

    public void create() {
        String name = Validator.validateInput("\nEnter the workforce' name: ", InputType.STRING);
        double hourlyRate = Parser.parseDouble(
                Validator.validateInput("Enter the workforce' hourly rate: ", InputType.DOUBLE));
        double workHours = Parser.parseDouble(
                Validator.validateInput("Enter the workforce' work hours: ", InputType.DOUBLE));
        double productivityCoefficient = Parser.parseDouble(
                Validator.validateInput("Enter the workforce' productivity coefficient: ", InputType.DOUBLE));

        Session.getProject().ifPresent((project) -> {
            Workforce workforce = new Workforce(name, project, hourlyRate, workHours, productivityCoefficient);
            service.save(workforce);
            project.addWorkforce(workforce);
        });
    }
}
