package ConectaBD;

import ConectaBD.ConexionBasica;
import java.sql.*;
import java.util.Scanner;

public class CineApp {

    
    static class Pelicula {
        String codigo, titulo, director, genero;
        int duracion;
        String salaNombre;
        int salaCapacidad;

        public Pelicula(String codigo, String titulo, String director, String genero, int duracion, String salaNombre, int salaCapacidad) {
            this.codigo = codigo;
            this.titulo = titulo;
            this.director = director;
            this.genero = genero;
            this.duracion = duracion;
            this.salaNombre = salaNombre;
            this.salaCapacidad = salaCapacidad;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			int opcion;

			do {
			    System.out.println("===== MENÚ CINE =====");
			    System.out.println("1 - Ver películas");
			    System.out.println("2 - Salir");
			    System.out.print("Selecciona una opción: ");
			    opcion = scanner.nextInt();

			    switch (opcion) {
			        case 1:
			            mostrarPeliculas();
			            break;
			        case 2:
			            System.out.println("Saliendo...");
			            break;
			        default:
			            System.out.println("Opción no válida.");
			    }

			} while (opcion != 2);
		}
    }

    public static void mostrarPeliculas() {
        String sql = """
                SELECT p.codigo, p.titulo, p.director, p.genero, p.duracion, 
                       s.nombre AS nombre_sala, s.capacidad
                FROM peliculas p
                JOIN salas s ON p.id_sala = s.id_sala
                """;

        try (Connection conn = ConexionBasica.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.printf("\n%-8s %-20s %-20s %-12s %-9s %-15s %-10s\n", 
                "Código", "Título", "Director", "Género", "Duración", "Sala", "Capacidad");
            System.out.println("-------------------------------------------------------------------------------------");

            while (rs.next()) {
                Pelicula peli = new Pelicula(
                    rs.getString("codigo"),
                    rs.getString("titulo"),
                    rs.getString("director"),
                    rs.getString("genero"),
                    rs.getInt("duracion"),
                    rs.getString("nombre_sala"),
                    rs.getInt("capacidad")
                );

                System.out.printf("%-8s %-20s %-20s %-12s %-9d %-15s %-10d\n",
                        peli.codigo, peli.titulo, peli.director, peli.genero, 
                        peli.duracion, peli.salaNombre, peli.salaCapacidad);
            }

        } catch (SQLException e) {
            System.out.println("Error al mostrar películas: " + e.getMessage());
        }
    }
}


