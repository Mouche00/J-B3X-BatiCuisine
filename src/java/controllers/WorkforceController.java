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
        double VAT = Parser.parseDouble(
                Validator.validateInput("Enter the workforce' VAT tax rate: ", InputType.DOUBLE));
        double hourlyRate = Parser.parseDouble(
                Validator.validateInput("Enter the workforce' hourly rate: ", InputType.DOUBLE));
        double workHours = Parser.parseDouble(
                Validator.validateInput("Enter the workforce' work hours: ", InputType.DOUBLE));

        Session.getProject().ifPresent((project) -> {
            service.save(new Workforce(name, VAT, project, hourlyRate, workHours));
        });
    }
}
