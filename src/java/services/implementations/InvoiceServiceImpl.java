package services.implementations;

import utils.Cost;
import models.Invoice;
import models.Material;
import models.Project;
import models.Workforce;
import repositories.interfaces.ComponentRepository;
import repositories.interfaces.InvoiceRepository;
import services.interfaces.InvoiceService;

import java.sql.SQLException;
import java.util.Optional;

public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository repository;
    private final ComponentRepository<Material> materialRepository;
    private final ComponentRepository<Workforce> workforceRepository;

    public InvoiceServiceImpl(InvoiceRepository repository, ComponentRepository<Material> materialRepository, ComponentRepository<Workforce> workforceRepository) {
        this.repository = repository;
        this.materialRepository = materialRepository;
        this.workforceRepository = workforceRepository;
    }

    @Override
    public Cost calculateCosts(Project project) {
        if(project.getMaterials().isEmpty()) {
            try {
                project.setMaterials(materialRepository.findAll(project.getId()));
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if(project.getWorkforces().isEmpty()) {
            try {
                project.setWorkforces(workforceRepository.findAll(project.getId()));
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        Cost invoiceDTO = new Cost();

        double materialsTotal = 0;
        for (Material material : project.getMaterials()) {
            double itemTotal = material.getPrice() * material.getQuantity() * material.getQualityCoefficient() + material.getTransportationCost();
            invoiceDTO.addComponentCost(material.getName(), itemTotal);
            materialsTotal += itemTotal;
        }
        invoiceDTO.setMaterialsTotalNoVAT(materialsTotal);
        invoiceDTO.setMaterialsTotalWithVAT(materialsTotal + (materialsTotal * (project.getVAT() / 100)));

        double workforcesTotal = 0;
        for (Workforce workforce : project.getWorkforces()) {
            double itemTotal = workforce.getHourlyRate() * workforce.getWorkHours() * workforce.getProductivityCoefficient();
            invoiceDTO.addComponentCost(workforce.getName(), itemTotal);
            workforcesTotal += itemTotal;
        }
        invoiceDTO.setWorkforcesTotalNoVAT(workforcesTotal);
        invoiceDTO.setWorkforcesTotalWithVAT(workforcesTotal + (workforcesTotal * (project.getVAT() / 100)));

        invoiceDTO.setTotalCostNoMargin(workforcesTotal + materialsTotal);
        invoiceDTO.setMargin(invoiceDTO.getTotalCostNoMargin() * (project.getMargin() / 100));
        invoiceDTO.setTotalCost(invoiceDTO.getTotalCostNoMargin() + invoiceDTO.getMargin());

        return invoiceDTO;
    }

    @Override
    public Optional<Invoice> findByProjectId(String projectId) {
        return Optional.empty();
    }

    @Override
    public Optional<Invoice> save(Invoice invoice) {
        try {
            return repository.save(invoice);
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return Optional.empty();
    }
}
