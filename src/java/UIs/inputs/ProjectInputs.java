package UIs.inputs;

import models.Project;
import utils.Parser;
import utils.Validator;
import utils.enums.InputType;

public class ProjectInputs {
    public Project create() {
        String title = Validator.validateInput("\nEnter the project' title: ", InputType.STRING);
        double margin = Parser.parseDouble(
                Validator.validateInput("Enter the project' margin: ", InputType.DOUBLE));
        double VAT = Parser.parseDouble(
                Validator.validateInput("Enter the project' VAT tax rate: ", InputType.DOUBLE));
        double discount = Parser.parseDouble(
                Validator.validateInput("Enter the project' discount: ", InputType.DOUBLE));

        return new Project(title, VAT, discount, margin);
    }
}
