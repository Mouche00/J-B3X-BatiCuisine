package repositories.implementations;

import models.Material;
import repositories.interfaces.ComponentRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Optional;

public class MaterialRepositoryImpl extends RepositoryConstructor implements ComponentRepository<Material> {

    @Override
    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM materials WHERE id = ?";
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(sql) > 0;
    }

    @Override
    public Optional<Material> save(Material material) throws SQLException {
        String sql = "INSERT INTO materials VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, material.getId());
        pstmt.setString(2, material.getName());
        pstmt.setDouble(3, material.getVAT());
        pstmt.setString(4, material.getProject().getId());
        pstmt.setDouble(5, material.getPrice());
        pstmt.setDouble(6, material.getQuantity());
        pstmt.setDouble(7, material.getTransportationCost());
        pstmt.setDouble(8, material.getQualityCoefficient());

        if(pstmt.executeUpdate() > 0) return Optional.of(material);
        return Optional.empty();
    }
}
