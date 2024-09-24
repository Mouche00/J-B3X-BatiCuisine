package repositories.implementations;

import models.Material;
import models.Workforce;
import repositories.interfaces.ComponentRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class WorkforceRepositoryImpl extends RepositoryConstructor implements ComponentRepository<Workforce> {

    @Override
    public boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM workforces WHERE id = ?";
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(sql) > 0;
    }

    @Override
    public Optional<Workforce> save(Workforce workforce) throws SQLException {
        String sql = "INSERT INTO workforces VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, workforce.getId());
        pstmt.setString(2, workforce.getName());
        pstmt.setDouble(3, workforce.getVAT());
        pstmt.setString(4, workforce.getProject().getId());
        pstmt.setDouble(5, workforce.getHourlyRate());
        pstmt.setDouble(6, workforce.getWorkHours());

        if(pstmt.executeUpdate() > 0) return Optional.of(workforce);
        return Optional.empty();
    }
}
