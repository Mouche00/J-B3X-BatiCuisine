package controllers;

import models.Material;
import services.interfaces.ComponentService;
import services.interfaces.ProjectService;
import utils.Parser;
import utils.Session;
import utils.Validator;
import utils.enums.InputType;

import java.sql.SQLException;

public class MaterialController {

    private final ComponentService<Material> service;
    public MaterialController(ComponentService<Material> service) {
        this.service = service;
    }

    public void create(Material material) {
        Session.getProject().ifPresent((project) -> {
            material.setProject(project);
            service.save(material);
            project.addMaterial(material);
        });
    }
}
