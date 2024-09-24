package controllers;

import models.Client;
import services.interfaces.ClientService;
import utils.ID;
import utils.Session;
import utils.enums.InputType;
import utils.Validator;

import java.sql.SQLException;
import java.util.Optional;

public class ClientController {
    private final ClientService service;
    public ClientController(ClientService service) {
        this.service = service;
    }

    public void create(Client client) {
        service.save(client).ifPresent((c) -> {
            Session.setClient(c);
            System.out.println("\n** Client retrieved successfully **\n");
        });
    }

    public void find(String name) {
        Optional<Client> client = service.findByName(name);
        client.ifPresent((c) -> {
            System.out.println("\n** Client retrieved successfully **\n");
            Session.setClient(c);
            System.out.println(c);
        });
    }
}
