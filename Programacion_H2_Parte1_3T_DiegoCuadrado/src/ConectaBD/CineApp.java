package ConectaBD;

import java.util.List;
import java.util.Scanner;

public class CineApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PeliculaDAO dao = new PeliculaDAO();
        int opcion;

        do {
            System.out.println("\n==== MENÚ CINE ====");
            System.out.println("1 - Ver películas");
            System.out.println("2 - Añadir película");
            System.out.println("3 - Eliminar película");
            System.out.println("4 - Modificar película");
            System.out.println("5 - Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    List<Pelicula> peliculas = dao.obtenerPeliculas();
                    System.out.printf("\n%-8s %-20s %-20s %-12s %-9s %-10s\n",
                            "Código", "Título", "Director", "Género", "Duración", "Sala");
                    for (Pelicula p : peliculas) {
                        System.out.printf("%-8s %-20s %-20s %-12s %-9d %-10s\n",
                                p.codigo, p.titulo, p.director, p.genero, p.duracion, p.idSala);
                    }
                }
                case 2 -> {
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Director: ");
                    String director = scanner.nextLine();
                    System.out.print("Género: ");
                    String genero = scanner.nextLine();
                    System.out.print("Duración (min): ");
                    int duracion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID de Sala: ");
                    String idSala = scanner.nextLine();

                    Pelicula p = new Pelicula(codigo, titulo, director, genero, duracion, idSala);
                    dao.insertarPelicula(p);
                }
                case 3 -> {
                    System.out.print("Código de la película a eliminar: ");
                    String codigo = scanner.nextLine();
                    dao.eliminarPelicula(codigo);
                }
                case 4 -> {
                    System.out.print("Código de la película a modificar: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nuevo título: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("Nuevo género: ");
                    String nuevoGenero = scanner.nextLine();
                    dao.modificarPelicula(codigo, nuevoTitulo, nuevoGenero);
                }
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
}




