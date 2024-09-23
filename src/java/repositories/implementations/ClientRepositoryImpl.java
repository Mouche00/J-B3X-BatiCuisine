package repositories.implementations;

import models.Client;
import repositories.interfaces.ClientRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class ClientRepositoryImpl extends Repository implements ClientRepository {

    @Override
    public Optional<Client> findByName(String name) throws SQLException {
        String sql = "SELECT * FROM client WHERE name = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        Optional<Client> client = Optional.empty();
        if(rs.next()) {
            int id = rs.getInt("id");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            boolean isProfessional = rs.getBoolean("is_professional");
            client = Optional.of(new Client(id, name, address, phone, isProfessional));
        }
        return client;
    }

    @Override
    public Optional<Integer> save(Client client) throws SQLException{
        String sql = "INSERT INTO clients (name, address, phone, is_professional) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, client.getName());
        pstmt.setString(2, client.getAddress());
        pstmt.setString(3, client.getPhone());
        pstmt.setBoolean(4, client.getIsProfessional());

        if(pstmt.executeUpdate() > 0) {
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if(generatedKeys.next()) {
                    return Optional.of(generatedKeys.getInt(1));
                }
            }
        }

        return Optional.empty();
    }
}
