package jasper.conecciones;

import java.sql.Connection;
import java.sql.SQLException;
 
public class conexion {
     public static Connection getConnection() throws SQLException,
            ClassNotFoundException {
        return DBPostgres.getPostgresConnection();
    }
 
    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {
 
        System.out.println("Get connection ... ");
 
        // Get a Connection object
        Connection conn = conexion.getConnection();
 
        System.out.println("Get connection " + conn);
 
        System.out.println("Done!");
    }
}