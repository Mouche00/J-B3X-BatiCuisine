package UIs.inputs;

import models.Client;
import utils.Validator;
import utils.enums.InputType;

public class ClientInputs {

    public String find(){
        return Validator.validateInput("\nEnter the client' name: ", InputType.STRING);
    }

    public Client create() {
        String name = Validator.validateInput("\nEnter the client' name: ", InputType.STRING);
        String address = Validator.validateInput("Enter the client' address: ", InputType.STRING);
        String phone = Validator.validateInput("Enter the client' phone number: ", InputType.INTEGER);

        String isProfessionalOption = Validator.validateInput("Choose the client' professional status: " +
                "\n\t0 - Professional" +
                "\n\t1 - Non-professional" +
                "\n> ", InputType.OPTION, 0, 1);
        boolean isProfessional = isProfessionalOption.equals("0");

        return new Client(name, address, phone, isProfessional);
    }
}
