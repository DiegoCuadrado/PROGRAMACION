package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaRecibidaDAO {
    private Connection connection;

    public FacturaRecibidaDAO() {
        // Conectar a la base de datos
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapoo", "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para agregar una nueva factura
    public boolean agregar(FacturaRecibida factura) {
        String sql = "INSERT INTO facturas_recibidas (id_proveedor, fecha_emision, monto_total) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, factura.getProveedor());
            stmt.setString(2, factura.getFechaEmision());
            stmt.setDouble(3, factura.getMontoTotal());
            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener todas las facturas
    public List<FacturaRecibida> obtenerTodas() {
        List<FacturaRecibida> facturas = new ArrayList<>();
        String sql = "SELECT * FROM facturas_recibidas";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id_factura");
                String proveedor = rs.getString("proveedor");
                String fechaEmision = rs.getString("fecha_emision");
                double montoTotal = rs.getDouble("monto_total");
                facturas.add(new FacturaRecibida(id, proveedor, fechaEmision, montoTotal));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facturas;
    }

    // Método para obtener una factura por ID
    public FacturaRecibida obtenerPorId(int idFactura) {
        FacturaRecibida factura = null;
        String sql = "SELECT * FROM facturas_recibidas WHERE id_factura = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idFactura);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String proveedor = rs.getString("proveedor");
                String fechaEmision = rs.getString("fecha_emision");
                double montoTotal = rs.getDouble("monto_total");
                factura = new FacturaRecibida(idFactura, proveedor, fechaEmision, montoTotal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return factura;
    }

    // Método para modificar una factura
    public boolean modificar(FacturaRecibida factura) {
        String sql = "UPDATE facturas_recibidas SET proveedor = ?, fecha_emision = ?, monto_total = ? WHERE id_factura = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, factura.getProveedor());
            stmt.setString(2, factura.getFechaEmision());
            stmt.setDouble(3, factura.getMontoTotal());
            stmt.setInt(4, factura.getIdFactura());
            int filasModificadas = stmt.executeUpdate();
            return filasModificadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar una factura por ID
    public boolean eliminar(int idFactura) {
        String sql = "DELETE FROM facturas_recibidas WHERE id_factura = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idFactura);
            int filasEliminadas = stmt.executeUpdate();  // Corregido el error aquí
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}





       


