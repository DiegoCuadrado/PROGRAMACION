package vista;

import modelo.Venta;

import java.util.List;
import java.util.Scanner;

public class VentaVista {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE VENTAS ---");
        System.out.println("1. Listar ventas");
        System.out.println("2. Agregar venta");
        System.out.println("3. Modificar venta");
        System.out.println("4. Eliminar venta");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Venta solicitarDatosVenta() {
        scanner.nextLine(); // Limpiar buffer
        System.out.println("\nIngrese los datos de la venta:");
        System.out.print("ID Cliente: ");
        int idCliente = scanner.nextInt();
        System.out.print("ID Artículo: ");
        int idArticulo = scanner.nextInt();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        System.out.print("Fecha de la venta (YYYY-MM-DD): ");
        String fechaVenta = scanner.next();

        return new Venta(0, idCliente, idArticulo, cantidad, java.sql.Date.valueOf(fechaVenta));
    }

    public int solicitarIdVenta() {
        System.out.print("Ingrese el ID de la venta: ");
        return scanner.nextInt();
    }

    public Venta solicitarDatosModificacion(Venta venta) {
        scanner.nextLine(); // Limpiar buffer
        System.out.println("\nModificando venta ID: " + venta.getIdVenta());

        System.out.print("Nuevo ID Cliente [" + venta.getIdCliente() + "]: ");
        int idCliente = scanner.nextInt();
        if (idCliente != 0) venta.setIdCliente(idCliente);

        System.out.print("Nuevo ID Artículo [" + venta.getIdArticulo() + "]: ");
        int idArticulo = scanner.nextInt();
        if (idArticulo != 0) venta.setIdArticulo(idArticulo);

        System.out.print("Nueva cantidad [" + venta.getCantidad() + "]: ");
        int cantidad = scanner.nextInt();
        if (cantidad != 0) venta.setCantidad(cantidad);

        System.out.print("Nueva fecha de venta [" + venta.getFechaVenta() + "]: ");
        String fechaVenta = scanner.next();
        if (!fechaVenta.isBlank()) venta.setFechaVenta(java.sql.Date.valueOf(fechaVenta));

        return venta;
    }

    public void mostrarVentas(List<Venta> ventas) {
        System.out.println("\n--- LISTADO DE VENTAS ---");
        for (Venta venta : ventas) {
            System.out.println(venta);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.err.println("ERROR: " + mensaje);
    }
}

