package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO {
    private Connection connection;

    public ArticuloDAO(Connection connection) {
        this.connection = connection;
    }
    public ArticuloDAO() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapoo", "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean agregar(Articulo articulo) {
        String sql = "INSERT INTO articulos (nombre, precio_unitario, stock) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, articulo.getNombre());
            stmt.setDouble(2, articulo.getPrecioUnitario());
            stmt.setInt(3, articulo.getStock());
            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Articulo> obtenerTodos() {
        List<Articulo> articulos = new ArrayList<>();
        String sql = "SELECT * FROM articulos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int idArticulo = rs.getInt("id_articulo");
                String nombre = rs.getString("nombre");
                double precioUnitario = rs.getDouble("precio_unitario");
                int stock = rs.getInt("stock");

                articulos.add(new Articulo(idArticulo, nombre, precioUnitario, stock));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articulos;
    }

    public Articulo obtenerPorId(int idArticulo) {
        String sql = "SELECT * FROM articulos WHERE id_articulo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idArticulo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    double precioUnitario = rs.getDouble("precio_unitario");
                    int stock = rs.getInt("stock");
                    return new Articulo(idArticulo, nombre, precioUnitario, stock);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean modificar(Articulo articulo) {
        String sql = "UPDATE articulos SET nombre = ?, precio_unitario = ?, stock = ? WHERE id_articulo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, articulo.getNombre());
            stmt.setDouble(2, articulo.getPrecioUnitario());
            stmt.setInt(3, articulo.getStock());
            stmt.setInt(4, articulo.getIdArticulo());
            int filasModificadas = stmt.executeUpdate();
            return filasModificadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int idArticulo) {
        String sql = "DELETE FROM articulos WHERE id_articulo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idArticulo);
            int filasEliminadas = stmt.executeUpdate();
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}









