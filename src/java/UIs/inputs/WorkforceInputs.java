package UIs.inputs;

import models.Workforce;
import utils.Parser;
import utils.Session;
import utils.Validator;
import utils.enums.InputType;

public class WorkforceInputs {

    public Workforce create() {
        String name = Validator.validateInput("\nEnter the workforce' name: ", InputType.STRING);
        double hourlyRate = Parser.parseDouble(
                Validator.validateInput("Enter the workforce' hourly rate: ", InputType.OPTION, 0));
        double workHours = Parser.parseDouble(
                Validator.validateInput("Enter the workforce' work hours: ", InputType.OPTION, 0));
        double productivityCoefficient = Parser.parseDouble(
                Validator.validateInput("Enter the workforce' productivity coefficient: ", InputType.OPTION, 1, 2));

        return new Workforce(name, hourlyRate, workHours, productivityCoefficient);
    }
}
