package ConectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBasica {

    private static final String URL = "jdbc:mysql://localhost:3306/cine";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "1234";

   
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }

    public static void main(String[] args) {
        try (Connection conexion = conectar()) {
            System.out.println("¡Conexión exitosa!");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}

