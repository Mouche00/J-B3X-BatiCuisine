package services.interfaces;

import DTOs.InvoiceDTO;
import models.Invoice;
import models.Project;

import java.util.Optional;

public interface InvoiceService extends Service<Invoice> {
    InvoiceDTO calculateCosts(Project project);
    Optional<Invoice> findByProjectId(String projectId);
}
