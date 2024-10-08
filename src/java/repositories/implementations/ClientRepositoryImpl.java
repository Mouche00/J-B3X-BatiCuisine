package repositories.implementations;

import models.Client;
import repositories.interfaces.ClientRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ClientRepositoryImpl extends RepositoryConstructor implements ClientRepository {

    @Override
    public Optional<Client> findByName(String name) throws SQLException {
        String sql = "SELECT * FROM clients WHERE name = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        Optional<Client> client = Optional.empty();
        if(rs.next()) {
            String id = rs.getString("id");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            boolean isProfessional = rs.getBoolean("is_professional");
            client = Optional.of(new Client(id, name, address, phone, isProfessional));
        }
        return client;
    }

    @Override
    public Optional<Client> save(Client client) throws SQLException{
        String sql = "INSERT INTO clients VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, client.getId());
        pstmt.setString(2, client.getName());
        pstmt.setString(3, client.getAddress());
        pstmt.setString(4, client.getPhone());
        pstmt.setBoolean(5, client.getIsProfessional());

        if(pstmt.executeUpdate() > 0) return Optional.of(client);
        return Optional.empty();
    }
}
