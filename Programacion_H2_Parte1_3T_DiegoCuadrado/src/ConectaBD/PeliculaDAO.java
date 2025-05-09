package ConectaBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    public List<Pelicula> obtenerPeliculas() {
        List<Pelicula> lista = new ArrayList<>();

        String sql = """
            SELECT p.codigo, p.titulo, p.director, p.genero, p.duracion, s.nombre, s.capacidad
            FROM peliculas p
            JOIN salas s ON p.id_sala = s.id_sala
        """;

        try (Connection conn = ConexionBasica.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pelicula p = new Pelicula(
                    rs.getString("codigo"),
                    rs.getString("titulo"),
                    rs.getString("director"),
                    rs.getString("genero"),
                    rs.getInt("duracion"),
                    rs.getString("nombre")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener películas: " + e.getMessage());
        }
        return lista;
    }

    public boolean peliculaExiste(String codigo) throws SQLException {
        String sql = "SELECT COUNT(*) FROM peliculas WHERE codigo = ?";
        try (Connection conn = ConexionBasica.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        }
    }

    public boolean salaExiste(String idSala) throws SQLException {
        String sql = "SELECT COUNT(*) FROM salas WHERE id_sala = ?";
        try (Connection conn = ConexionBasica.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idSala);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        }
    }

    public void insertarPelicula(Pelicula p) {
        String sql = "INSERT INTO peliculas VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBasica.conectar()) {

            if (peliculaExiste(p.codigo)) {
                System.out.println("Error: Ya existe una película con ese código.");
                return;
            }

            if (!salaExiste(p.idSala)) {
                System.out.println("Error: No existe la sala indicada.");
                return;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, p.codigo);
                stmt.setString(2, p.titulo);
                stmt.setString(3, p.director);
                stmt.setString(4, p.genero);
                stmt.setInt(5, p.duracion);
                stmt.setString(6, p.idSala);

                stmt.executeUpdate();
                System.out.println("Película añadida correctamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al añadir película: " + e.getMessage());
        }
    }

    public void eliminarPelicula(String codigo) {
        String sql = "DELETE FROM peliculas WHERE codigo = ?";

        try (Connection conn = ConexionBasica.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, codigo);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Película eliminada.");
            } else {
                System.out.println("No se encontró ninguna película con ese código.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar película: " + e.getMessage());
        }
    }

    public void modificarPelicula(String codigo, String nuevoTitulo, String nuevoGenero) {
        String sql = "UPDATE peliculas SET titulo = ?, genero = ? WHERE codigo = ?";

        try (Connection conn = ConexionBasica.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevoTitulo);
            stmt.setString(2, nuevoGenero);
            stmt.setString(3, codigo);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Película modificada.");
            } else {
                System.out.println("No se encontró ninguna película con ese código.");
            }

        } catch (SQLException e) {
            System.out.println("Error al modificar película: " + e.getMessage());
        }
    }
}


