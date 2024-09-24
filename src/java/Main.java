import controllers.*;
import models.Material;
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
import utils.Cache;
import utils.Session;

public class Main {
    public static void main(String[] args){
        ClientRepository clientRepository = new ClientRepositoryImpl();
        ClientService clientService = new ClientServiceImpl(clientRepository);
        ClientController clientController = new ClientController(clientService);

        ProjectRepository projectRepository = new ProjectRepositoryImpl();
        ProjectService projectService = new ProjectServiceImpl(projectRepository);
        ProjectController projectController = new ProjectController(projectService);

        ComponentRepository<Material> materialRepository = new MaterialRepositoryImpl();
        ComponentService<Material> materialService = new MaterialServiceImpl(materialRepository);
        MaterialController materialController = new MaterialController(materialService);

        ComponentRepository<Workforce> workforceRepository = new WorkforceRepositoryImpl();
        ComponentService<Workforce> workforceService = new WorkforceServiceImpl(workforceRepository);
        WorkforceController workforceController = new WorkforceController(workforceService);

        InvoiceRepository invoiceRepository = new InvoiceRepositoryImpl();
        InvoiceService invoiceService = new InvoiceServiceImpl(invoiceRepository, materialRepository, workforceRepository);
        InvoiceController invoiceController = new InvoiceController(invoiceService);

        clientController.find();
        projectController.find();
//        projectController.create();
//        materialController.create();
//        materialController.create();
//        workforceController.create();
        invoiceController.calculate();


    }
}
