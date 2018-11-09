package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(
            "jdbc:mysql://localhost/helpdesk", "root", "968574");
        } catch (SQLException e){
                throw new RuntimeException (e);
        }
    }
}
