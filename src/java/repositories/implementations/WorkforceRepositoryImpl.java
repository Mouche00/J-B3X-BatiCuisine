package repositories.implementations;

import models.Client;
import models.Material;
import models.Project;
import models.Workforce;
import repositories.interfaces.ComponentRepository;
import utils.enums.ProjectStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorkforceRepositoryImpl extends RepositoryConstructor implements ComponentRepository<Workforce> {

    @Override
    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM workforces WHERE id = ?";
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(sql) > 0;
    }

    @Override
    public List<Workforce> findAll(String id) throws SQLException {
        List<Workforce> workforces = new ArrayList<>();
        String sql = "SELECT c.name as client_name, w.name as workforce_name, * FROM workforces w JOIN projects p ON w.project_id = p.id JOIN clients c ON c.id = p.client_id WHERE p.id = ?";
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

            String workforceName = rs.getString("workforce_name");
            double hourlyRate = rs.getDouble("hourly_rate");
            double workHours = rs.getDouble("work_hours");
            double productivityCoefficient = rs.getDouble("productivity_coeffecient");

            workforces.add(new Workforce(id, workforceName, project, hourlyRate, workHours, productivityCoefficient));
        }

        return workforces;
    }

    @Override
    public Optional<Workforce> save(Workforce workforce) throws SQLException {
        String sql = "INSERT INTO workforces VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, workforce.getId());
        pstmt.setString(2, workforce.getName());
        pstmt.setString(3, workforce.getProject().getId());
        pstmt.setDouble(4, workforce.getHourlyRate());
        pstmt.setDouble(5, workforce.getWorkHours());
        pstmt.setDouble(6, workforce.getProductivityCoefficient());

        if(pstmt.executeUpdate() > 0) return Optional.of(workforce);
        return Optional.empty();
    }
}
