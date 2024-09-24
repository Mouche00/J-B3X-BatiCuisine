package repositories.interfaces;

import models.Invoice;

import java.util.Optional;

public interface InvoiceRepository extends Repository<Invoice> {
    Optional<Invoice> findByProjectId(String projectId);
}
