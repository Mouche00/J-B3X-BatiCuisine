package repositories.implementations;

import utils.JdbcConnection;

import java.sql.Connection;

public class Repository {
    protected Connection conn;
    public Repository() {
        if(JdbcConnection.getConnection().isPresent()){
            this.conn = JdbcConnection.getConnection().get();
        }
    }
}
