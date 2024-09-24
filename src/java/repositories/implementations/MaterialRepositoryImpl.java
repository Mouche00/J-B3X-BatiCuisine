package repositories.implementations;

import models.Client;
import models.Material;
import models.Project;
import repositories.interfaces.ComponentRepository;
import utils.enums.ProjectStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MaterialRepositoryImpl extends RepositoryConstructor implements ComponentRepository<Material> {

    @Override
    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM materials WHERE id = ?";
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(sql) > 0;
    }

    @Override
    public List<Material> findAll(String id) throws SQLException {
        List<Material> materials = new ArrayList<>();
        String sql = "SELECT c.name as client_name, m.name as material_name, * FROM materials m JOIN projects p ON m.project_id = p.id JOIN clients c ON c.id = p.client_id WHERE p.id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            String clientId = rs.getString("client_id");
            String clientName = rs.getString("client_name");
            String address = rs.getString("address");
            String phone  = rs.getString("phone");
            boolean isProfessional  = rs.getBoolean("is_professional");
            Client client = new Client(clientId, clientName, address, phone, isProfessional);

            String projectIid = rs.getString("project_id");
            String title = rs.getString("title");
            double VAT = rs.getDouble("VAT");
            double discount = rs.getDouble("discount");
            double margin = rs.getDouble("margin");
            ProjectStatus status = ProjectStatus.valueOf(rs.getString("status"));
            Project project = new Project(id, title, VAT, discount, margin, status, client);

            String materialName = rs.getString("material_name");
            double price = rs.getDouble("price");
            double quantity = rs.getDouble("quantity");
            double transportationCost = rs.getDouble("transportation_cost");
            double qualityCoefficient = rs.getDouble("quality_coeffecient");

            materials.add(new Material(id, materialName, project, price, quantity, transportationCost, qualityCoefficient));
        }

        return materials;
    }

    @Override
    public Optional<Material> save(Material material) throws SQLException {
        String sql = "INSERT INTO materials VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, material.getId());
        pstmt.setString(2, material.getName());
        pstmt.setString(3, material.getProject().getId());
        pstmt.setDouble(4, material.getPrice());
        pstmt.setDouble(5, material.getQuantity());
        pstmt.setDouble(6, material.getTransportationCost());
        pstmt.setDouble(7, material.getQualityCoefficient());

        if(pstmt.executeUpdate() > 0) return Optional.of(material);
        return Optional.empty();
    }
}
