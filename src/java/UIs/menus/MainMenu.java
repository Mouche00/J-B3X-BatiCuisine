package UIs.menus;

import UIs.inputs.*;
import controllers.*;
import models.Invoice;
import models.Material;
import models.Project;
import models.Workforce;
import repositories.implementations.*;
import repositories.interfaces.ClientRepository;
import repositories.interfaces.ComponentRepository;
import repositories.interfaces.InvoiceRepository;
import repositories.interfaces.ProjectRepository;
import services.implementations.*;
import services.interfaces.ClientService;
import services.interfaces.ComponentService;
import services.interfaces.InvoiceService;
import services.interfaces.ProjectService;
import utils.Parser;
import utils.Session;
import utils.Validator;
import utils.enums.InputType;

import java.util.List;
import java.util.Optional;

public class MainMenu extends Menu {
    ClientRepository clientRepository = new ClientRepositoryImpl();
    ClientService clientService = new ClientServiceImpl(clientRepository);
    ClientController clientController = new ClientController(clientService);
    ClientInputs clientInputs = new ClientInputs();

    ProjectRepository projectRepository = new ProjectRepositoryImpl();
    ProjectService projectService = new ProjectServiceImpl(projectRepository);
    ProjectController projectController = new ProjectController(projectService);
    ProjectInputs projectInputs = new ProjectInputs();

    ComponentRepository<Material> materialRepository = new MaterialRepositoryImpl();
    ComponentService<Material> materialService = new MaterialServiceImpl(materialRepository);
    MaterialController materialController = new MaterialController(materialService);
    MaterialInputs materialInputs = new MaterialInputs();

    ComponentRepository<Workforce> workforceRepository = new WorkforceRepositoryImpl();
    ComponentService<Workforce> workforceService = new WorkforceServiceImpl(workforceRepository);
    WorkforceController workforceController = new WorkforceController(workforceService);
    WorkforceInputs workforceInputs = new WorkforceInputs();

    InvoiceRepository invoiceRepository = new InvoiceRepositoryImpl();
    InvoiceService invoiceService = new InvoiceServiceImpl(invoiceRepository, materialRepository, workforceRepository);
    InvoiceController invoiceController = new InvoiceController(invoiceService);
    InvoiceInputs invoiceInputs = new InvoiceInputs();

    @Override
    public int prompt() {
        System.out.println("\n#-------------- Main Menu -------------#"
                + "\nSelect an option:"
                + "\n1 - Create a new project"
                + "\n2 - List all existing projects"
                + "\n3 - Calculate a project' costs"
                + "\n0 - Exit");
        System.out.print("> ");
        return Validator.validateInteger(scanner.nextLine());
    }

    @Override
    public void choice(int option) {
        switch (option) {
            case 0:
                break;
            case 1:
                String choice;
                do {
                    option = Parser.parseInt(
                            Validator.validateInput("\n#-------------- Choose a client -------------#" +
                            "\nSelect an option: " +
                            "\n1 - Search for a client" +
                            "\n2 - Add a new client" +
                            "\n> ", InputType.OPTION, 1, 2));

                    switch (option) {
                        case 1:
                            clientController.find(clientInputs.find());
                            break;
                        case 2:
                            clientController.create(clientInputs.create());
                            break;
                        default:
                            System.out.println("\n** Invalid choice **\n");
                    }

                    choice = Validator.validateInput("\nDo you want to continue? (y/n) ", InputType.STRING);
                } while (!Session.getClient().isPresent() || !choice.equals("y"));

                System.out.println("\n#-------------- Create a new project -------------#");
                projectController.create(projectInputs.create());

                System.out.println("\n#-------------- Add materials -------------#");
                do {
                    materialController.create(materialInputs.create());
                    choice = Validator.validateInput("\nDo you want to add a new material? (y/n) ", InputType.STRING);
                } while (!choice.equals("n"));

                System.out.println("\n#-------------- Add workforces -------------#");
                do {
                    workforceController.create(workforceInputs.create());
                    choice = Validator.validateInput("\nDo you want to add a new workforce? (y/n) ", InputType.STRING);
                } while (!choice.equals("n"));

                System.out.println("\n#-------------- Cost calculation -------------#");
                double cost = invoiceController.calculate();

                System.out.println("\n#-------------- Invoice Registration -------------#");
                Invoice invoice = invoiceInputs.create();
                if(Validator.validateInput("\nDo you want to save this invoice? (y/n) ", InputType.STRING).equals("y")) {
                    invoiceController.create(invoice, cost);
                } else {
                    Session.getProject().ifPresent(projectController::delete);
                }
                break;
            case 2:
                System.out.println("\n#-------------- Projects List --------------#");
                List<Project> projects = projectController.getAll();
                projectController.list(projects);
                if(Validator.validateInput("\nDo you want to mark a project as completed? (y/n) ", InputType.STRING).equals("y")) {
                    do {
                        int index = Parser.parseInt(
                                Validator.validateInput("\nEnter project index: " +
                                        "\n> ", InputType.OPTION, 0, projects.size()-1));
                        projectController.update(projects.get(index));
                    } while (Validator.validateInput("\nDo you want to mark another project? (y/n) ", InputType.STRING).equals("y"));
                }
                break;
            case 3:
                System.out.println("\n#-------------- Renew a Cancelled Project --------------#");
                List<Project> cancelledProjects = projectController.getAllCancelled();
                projectController.list(cancelledProjects);
                do {
                    int index = Parser.parseInt(
                            Validator.validateInput("\nEnter project index: " +
                                    "\n> ", InputType.OPTION, 0, cancelledProjects.size()-1));
                    Project project = cancelledProjects.get(index);
                    Session.setProject(project);
                    Session.setClient(project.getClient());
                    cost = invoiceController.calculate();
                    invoice = invoiceInputs.create();
                    if(Validator.validateInput("\nDo you want to save this invoice? (y/n) ", InputType.STRING).equals("y")) {
                        invoiceController.create(invoice, cost);
                        projectController.updateOngoing(project);
                    }
                } while (Validator.validateInput("\nDo you want to calculate another project' costs? (y/n) ", InputType.STRING).equals("y"));

                break;
            default:
                System.out.println("\nInvalid option!\n");
        }
    }
}
