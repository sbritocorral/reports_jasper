/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasper.conecciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBPostgres {
    public static Connection getPostgresConnection()
            throws ClassNotFoundException, SQLException {
        String hostName = "104.131.30.77";
        String dbName = "sami_erp";
        String userName = "postgres";
        String password = "M3ga$0O1";
        return getPostgresConnection(hostName, dbName, userName, password);
    }

    public static Connection getPostgresConnection(String hostName, String dbName,
            String userName, String password) throws SQLException,
            ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String connectionURL = "jdbc:postgresql://104.131.30.77/sami_erp";
        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}
