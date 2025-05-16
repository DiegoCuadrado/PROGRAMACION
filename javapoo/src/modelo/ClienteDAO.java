package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Connection connection;

    // Constructor vacío para inicializar la conexión
    public ClienteDAO() {
        try {
            // Cambia estos datos de conexión según tu configuración
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapoo", "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean agregar(Cliente cliente) {
        String query = "INSERT INTO Clientes (nombre, email, telefono) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getTelefono());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Cliente> obtenerTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Clientes";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Cliente cliente = new Cliente(resultSet.getInt("id_cliente"), resultSet.getString("nombre"), 
                        resultSet.getString("email"), resultSet.getString("telefono"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public boolean modificar(Cliente cliente) {
        String query = "UPDATE Clientes SET nombre = ?, email = ?, telefono = ? WHERE id_cliente = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getTelefono());
            statement.setInt(4, cliente.getIdCliente());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int idCliente) {
        String query = "DELETE FROM Clientes WHERE id_cliente = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idCliente);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}







