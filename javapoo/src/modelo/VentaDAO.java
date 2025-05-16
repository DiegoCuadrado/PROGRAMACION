package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    private Connection connection;

    public VentaDAO() {
        try {
            // Cambia estos valores según tu configuración
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javapoo", 
                    "root", 
                    "1234"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    


    public List<Venta> obtenerTodas() {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM ventas";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int idVenta = rs.getInt("id_venta");
                int idCliente = rs.getInt("id_cliente");
                int idArticulo = rs.getInt("id_articulo");
                int cantidad = rs.getInt("cantidad");
                Date fecha = rs.getDate("fecha_venta");

                ventas.add(new Venta(idVenta, idCliente, idArticulo, cantidad, fecha));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }
    
    public List<Venta> obtenerVentasPorCliente(int idCliente) {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM ventas WHERE id_cliente=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ventas.add(new Venta(
                    rs.getInt("id_venta"),
                    rs.getInt("id_cliente"),
                    rs.getInt("id_articulo"),
                    rs.getInt("cantidad"),
                    rs.getDate("fecha_venta")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }


    public boolean agregar(Venta venta) {
        String sql = "INSERT INTO ventas (id_cliente, id_articulo, cantidad, fecha) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, venta.getIdCliente());
            stmt.setInt(2, venta.getIdArticulo());
            stmt.setInt(3, venta.getCantidad());
            stmt.setDate(4, new java.sql.Date(venta.getFechaVenta().getTime()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificar(Venta venta) {
        String sql = "UPDATE ventas SET id_cliente = ?, id_articulo = ?, cantidad = ?, fecha = ? WHERE id_venta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, venta.getIdCliente());
            stmt.setInt(2, venta.getIdArticulo());
            stmt.setInt(3, venta.getCantidad());
            stmt.setDate(4, new java.sql.Date(venta.getFechaVenta().getTime()));
            stmt.setInt(5, venta.getIdVenta());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int idVenta) {
        String sql = "DELETE FROM ventas WHERE id_venta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idVenta);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Venta obtenerPorId(int idVenta) {
        String sql = "SELECT * FROM ventas WHERE id_venta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idVenta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                int idArticulo = rs.getInt("id_articulo");
                int cantidad = rs.getInt("cantidad");
                Date fecha = rs.getDate("fecha");

                return new Venta(idVenta, idCliente, idArticulo, cantidad, fecha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}




