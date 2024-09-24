package repositories.implementations;

import models.Invoice;
import repositories.interfaces.InvoiceRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class InvoiceRepositoryImpl extends RepositoryConstructor implements InvoiceRepository {
    @Override
    public Optional<Invoice> findByProjectId(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Invoice> save(Invoice invoice) throws SQLException {
        String sql = "INSERT INTO invoices VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, invoice.getId());
        pstmt.setDouble(2, invoice.getOverallCost());
        pstmt.setObject(3, invoice.getIssuedAt());
        pstmt.setObject(4, invoice.getValidatedAt());
        pstmt.setString(5, invoice.getProject().getId());

        if(pstmt.executeUpdate() > 0) return Optional.of(invoice);
        return Optional.empty();
    }
}
