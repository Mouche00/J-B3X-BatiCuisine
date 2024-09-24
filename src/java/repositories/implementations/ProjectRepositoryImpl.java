package repositories.implementations;

import models.Client;
import models.Project;
import repositories.interfaces.ProjectRepository;
import repositories.interfaces.Repository;
import utils.enums.ProjectStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectRepositoryImpl extends RepositoryConstructor implements ProjectRepository {

    @Override
    public Optional<Project> save(Project project) throws SQLException {
        String sql = "INSERT INTO projects VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, project.getId());
        pstmt.setString(2, project.getTitle());
        pstmt.setDouble(3, project.getVAT());
        pstmt.setDouble(4, project.getDiscount());
        pstmt.setDouble(5, project.getMargin());
        pstmt.setObject(6, project.getStatus(), Types.OTHER);
        pstmt.setString(7, project.getClient().getId());

        if(pstmt.executeUpdate() > 0) return Optional.of(project);
        return Optional.empty();
    }

    @Override
    public List<Project> getAll() throws SQLException {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT p.*, c.* FROM projects p JOIN clients c ON p.client_id = c.id";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String clientId = rs.getString("client_id");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String phone  = rs.getString("phone");
            boolean isProfessional  = rs.getBoolean("is_professional");
            Client client = new Client(clientId, name, address, phone, isProfessional);

            String id = rs.getString("id");
            String title = rs.getString("title");
            double VAT = rs.getDouble("VAT");
            double discount = rs.getDouble("discount");
            double margin = rs.getDouble("margin");
            ProjectStatus status = ProjectStatus.valueOf(rs.getString("status"));

            projects.add(new Project(id, title, VAT, discount, margin, status, client));
        }

        return projects;
    }

    @Override
    public Optional<Project> get(String id) throws SQLException {
        String sql = "SELECT * FROM projects p JOIN clients c ON p.client_id = c.id WHERE p.id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        Optional<Project> project = Optional.empty();
        if(rs.next()) {
            String clientId = rs.getString("client_id");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String phone  = rs.getString("phone");
            boolean isProfessional  = rs.getBoolean("is_professional");
            Client client = new Client(clientId, name, address, phone, isProfessional);

            String title = rs.getString("title");
            double VAT = rs.getDouble("VAT");
            double discount = rs.getDouble("discount");
            double margin = rs.getDouble("margin");
            ProjectStatus status = ProjectStatus.valueOf(rs.getString("status"));

            project = Optional.of(new Project(id, title, VAT, discount, margin, status, client));
        }
        return project;
    }

    @Override
    public boolean updateStatus(String id, ProjectStatus status) throws SQLException {
        String sql = "UPDATE projects SET status = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setObject(1, status, Types.OTHER);
        pstmt.setString(2, id);
        return pstmt.executeUpdate() > 0;
    }
}
