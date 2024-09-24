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
        String sql = "SELECT * FROM workforces WHERE project_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            String name = rs.getString("name");
            double hourlyRate = rs.getDouble("hourly_rate");
            double workHours = rs.getDouble("work_hours");
            double productivityCoefficient = rs.getDouble("productivity_coeffecient");

            workforces.add(new Workforce(id, name, hourlyRate, workHours, productivityCoefficient));
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
