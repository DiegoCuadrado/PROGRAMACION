package vista;

import modelo.Articulo;

import java.util.List;
import java.util.Scanner;

public class ArticuloVista {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE ARTÍCULOS ---");
        System.out.println("1. Listar artículos");
        System.out.println("2. Agregar artículo");
        System.out.println("3. Modificar artículo");
        System.out.println("4. Eliminar artículo");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Articulo solicitarDatosArticulo() {
        scanner.nextLine(); // Limpiar buffer
        System.out.println("\nIngrese los datos del artículo:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio unitario: ");
        double precio = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();

        return new Articulo(0, nombre, precio, stock);
    }

    public int solicitarIdArticulo() {
        System.out.print("Ingrese el ID del artículo: ");
        return scanner.nextInt();
    }

    public Articulo solicitarDatosModificacion(Articulo articulo) {
        scanner.nextLine(); // Limpiar buffer
        System.out.println("\nModificando artículo: " + articulo.getIdArticulo());
        System.out.print("Nuevo nombre [" + articulo.getNombre() + "]: ");
        String nombre = scanner.nextLine();
        if (!nombre.isBlank()) articulo.setNombre(nombre);

        System.out.print("Nuevo precio unitario [" + articulo.getPrecioUnitario() + "]: ");
        String precioStr = scanner.nextLine();
        if (!precioStr.isBlank()) articulo.setPrecioUnitario(Double.parseDouble(precioStr));

        System.out.print("Nuevo stock [" + articulo.getStock() + "]: ");
        String stockStr = scanner.nextLine();
        if (!stockStr.isBlank()) articulo.setStock(Integer.parseInt(stockStr));

        return articulo;
    }

    public void mostrarArticulos(List<Articulo> articulos) {
        System.out.println("\n--- LISTADO DE ARTÍCULOS ---");
        for (Articulo a : articulos) {
            System.out.println(a);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.err.println("ERROR: " + mensaje);
    }
}

