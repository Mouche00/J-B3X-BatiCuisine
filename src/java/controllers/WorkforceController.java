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

    public void create(Workforce workforce) {

        Session.getProject().ifPresent((project) -> {
            workforce.setProject(project);
            service.save(workforce);
            project.addWorkforce(workforce);
        });
    }
}
