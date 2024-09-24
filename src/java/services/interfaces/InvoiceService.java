package services.interfaces;

import utils.Cost;
import models.Invoice;
import models.Project;

import java.util.Optional;

public interface InvoiceService extends Service<Invoice> {
    Cost calculateCosts(Project project);
    Optional<Invoice> findByProjectId(String projectId);
}
