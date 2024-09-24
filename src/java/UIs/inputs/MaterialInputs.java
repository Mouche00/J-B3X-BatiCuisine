package UIs.inputs;

import models.Material;
import utils.Parser;
import utils.Session;
import utils.Validator;
import utils.enums.InputType;

public class MaterialInputs {
    public Material create() {
        String name = Validator.validateInput("\nEnter the material' name: ", InputType.STRING);
        double price = Parser.parseDouble(
                Validator.validateInput("Enter the material' price by unit: ", InputType.OPTION, 0));
        double quantity = Parser.parseDouble(
                Validator.validateInput("Enter the material' quantity: ", InputType.OPTION, 0));
        double transportationCost = Parser.parseDouble(
                Validator.validateInput("Enter the material' transportation cost: ", InputType.OPTION, 0));
        double qualityCoefficient = Parser.parseDouble(
                Validator.validateInput("Enter the material' quality coefficient: ", InputType.OPTION, 1 ,2));

         return new Material(name, price, quantity, transportationCost, qualityCoefficient);
    }
}
