package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    private Connection connection;

    public ProveedorDAO() {
        try {
            // Asegúrate de colocar la URL, usuario y contraseña correctos de tu base de datos
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapoo", "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los proveedores
    public List<Proveedor> obtenerTodos() {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores"; // Cambia 'proveedores' por el nombre de tu tabla

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                proveedores.add(new Proveedor(id, nombre, direccion, telefono)); // Aquí cambiamos la instancia de Proveedor
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedores;
    }
    public Proveedor obtenerPorId(int idProveedor) {
        String sql = "SELECT * FROM proveedores WHERE id_proveedor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProveedor);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                return new Proveedor(idProveedor, nombre, direccion, telefono);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // Método para agregar un nuevo proveedor
    public boolean agregar(Proveedor proveedor) {
        String sql = "INSERT INTO proveedores (nombre, direccion, telefono) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getDireccion());
            stmt.setString(3, proveedor.getTelefono());
            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para modificar un proveedor
    public boolean modificar(Proveedor proveedor) {
        String sql = "UPDATE proveedores SET nombre = ?, direccion = ?, telefono = ? WHERE id_proveedor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, proveedor.getNombre());
            stmt.setString(2, proveedor.getDireccion());
            stmt.setString(3, proveedor.getTelefono());
            stmt.setInt(4, proveedor.getIdProveedor());
            int filasModificadas = stmt.executeUpdate();
            return filasModificadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un proveedor
    public boolean eliminar(int idProveedor) {
        String sql = "DELETE FROM proveedores WHERE id_proveedor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProveedor);
            int filasEliminadas = stmt.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}






