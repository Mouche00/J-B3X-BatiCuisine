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

    public void create() {
        String name = Validator.validateInput("\nEnter the material' name: ", InputType.STRING);
        double price = Parser.parseDouble(
                Validator.validateInput("Enter the material' price by unit: ", InputType.DOUBLE));
        double quantity = Parser.parseDouble(
                Validator.validateInput("Enter the material' quantity: ", InputType.DOUBLE));
        double transportationCost = Parser.parseDouble(
                Validator.validateInput("Enter the material' transportation cost: ", InputType.DOUBLE));
        double qualityCoefficient = Parser.parseDouble(
                Validator.validateInput("Enter the material' quality coefficient: ", InputType.DOUBLE));

        Session.getProject().ifPresent((project) -> {
            Material material = new Material(name, project, price, quantity, transportationCost, qualityCoefficient);
            service.save(material);
            project.addMaterial(material);
        });
    }
}
