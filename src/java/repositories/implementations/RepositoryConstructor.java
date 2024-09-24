package repositories.implementations;

import utils.JdbcConnection;

import java.sql.Connection;

public class RepositoryConstructor {
    protected Connection conn;
    public RepositoryConstructor() {
        if(JdbcConnection.getConnection().isPresent()){
            this.conn = JdbcConnection.getConnection().get();
        }
    }
}
