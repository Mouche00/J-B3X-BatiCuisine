import controllers.ClientController;
import controllers.MaterialController;
import controllers.ProjectController;
import models.Material;
import repositories.implementations.ClientRepositoryImpl;
import repositories.implementations.MaterialRepositoryImpl;
import repositories.implementations.ProjectRepositoryImpl;
import repositories.interfaces.ClientRepository;
import repositories.interfaces.ComponentRepository;
import repositories.interfaces.ProjectRepository;
import services.implementations.ClientServiceImpl;
import services.implementations.MaterialServiceImpl;
import services.implementations.ProjectServiceImpl;
import services.interfaces.ClientService;
import services.interfaces.ComponentService;
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

        clientController.find();
        projectController.create();
        materialController.create();

    }
}
