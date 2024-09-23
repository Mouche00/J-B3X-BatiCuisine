package controllers;

import models.Client;
import services.interfaces.ClientService;
import utils.Session;
import utils.enums.InputType;
import utils.Validator;

import java.sql.SQLException;
import java.util.Optional;

public class ClientController {
    private ClientService service;
    public ClientController(ClientService service) {
        this.service = service;
    }

    public void create() {
        String name = Validator.validateInput("Enter the client' name:", InputType.STRING);
        String address = Validator.validateInput("Enter the client' address:", InputType.STRING);
        String phone = Validator.validateInput("Enter the client' phone number:", InputType.INTEGER);

        String isProfessionalOption = Validator.validateInput("Choose the client' professional status:" +
                "\n\t0 - Professional" +
                "\n\t1 - Non-professional", InputType.OPTION, 0, 1);
        boolean isProfessional = isProfessionalOption.equals("0");

        Client client = new Client(name, address, phone, isProfessional);

        try {
            Optional<Integer> generatedId = service.save(client);
            generatedId.ifPresent(client::setId);
            Session.setClient(client);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void find() {
        String name = Validator.validateInput("Enter the client' name:", InputType.STRING);

        try {
            service.findByName(name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
