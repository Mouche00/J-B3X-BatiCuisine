package controllers;

import utils.Cost;
import models.Client;
import models.Invoice;
import models.Project;
import services.interfaces.InvoiceService;
import utils.Session;

public class InvoiceController {
    private final InvoiceService service;
    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    public double calculate() {

        if(Session.getProject().isPresent() && Session.getClient().isPresent()) {
            Cost invoice = service.calculateCosts(Session.getProject().get());
            Project project = Session.getProject().get();
            Client client = Session.getClient().get();

            System.out.println("Project title: " + project.getTitle());
            System.out.println("Client name: " + client.getName());
            System.out.println("Worksite address: " + client.getAddress());

            System.out.println("\nCost Details: ");
            System.out.println("\tMaterials: ");
            project.getMaterials().forEach(material -> System.out.println("\t\t" + material.getName() + " " + invoice.getComponentCost(material.getName()) + " (" + material + ")"));
            System.out.println("\t- Total materials cost without VAT: " + invoice.getMaterialsTotalNoVAT() + "€");
            System.out.println("\t- Total materials cost with VAT: " + invoice.getMaterialsTotalWithVAT() + "€");

            System.out.println("\n\tWorkforces: ");
            project.getWorkforces().forEach(workforce -> System.out.println("\t\t" + workforce.getName() + " " + invoice.getComponentCost(workforce.getName()) + " (" + workforce + ")"));
            System.out.println("\t- Total workforces cost without VAT: " + invoice.getWorkforcesTotalNoVAT() + "€");
            System.out.println("\t- Total workforces cost with VAT: " + invoice.getWorkforcesTotalWithVAT() + "€");

            System.out.println("\n\t- Total cost without margin: " + invoice.getTotalCostNoMargin() + "€");
            System.out.println("\t- Margin (" + project.getMargin() + "%): " + invoice.getMargin() + "€");
            System.out.println("\t- Total cost: " + invoice.getTotalCost() + "€");

            return invoice.getTotalCost();
        }
        return 0;
    }

    public void create(Invoice invoice, double cost) {
        invoice.setOverallCost(cost);
        Session.getProject().ifPresent(invoice::setProject);
        service.save(invoice);
    }
}
