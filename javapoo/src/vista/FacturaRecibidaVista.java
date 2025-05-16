package vista;

import modelo.FacturaRecibida;

import java.util.List;
import java.util.Scanner;

public class FacturaRecibidaVista {
    private Scanner scanner = new Scanner(System.in);

    // Método para mostrar el menú de opciones
    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE FACTURAS RECIBIDAS ---");
        System.out.println("1. Listar facturas");
        System.out.println("2. Agregar factura");
        System.out.println("3. Modificar factura");
        System.out.println("4. Eliminar factura");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    // Método para solicitar los datos para agregar una factura
    public FacturaRecibida solicitarDatosFactura() {
        scanner.nextLine();  // Limpiar buffer
        System.out.println("\nIngrese los datos de la factura:");
        System.out.print("Proveedor: ");
        String proveedor = scanner.nextLine();
        System.out.print("Fecha de emisión (YYYY-MM-DD): ");
        String fechaEmision = scanner.nextLine();
        System.out.print("Monto total: ");
        double montoTotal = scanner.nextDouble();

        // Crear y devolver un objeto FacturaRecibida
        return new FacturaRecibida(proveedor, fechaEmision, montoTotal);
    }

    // Método para solicitar el ID de la factura (para modificaciones o eliminaciones)
    public int solicitarIdFactura() {
        System.out.print("Ingrese el ID de la factura: ");
        return scanner.nextInt();
    }

    // Método para mostrar las facturas listadas
    public void mostrarFacturas(List<FacturaRecibida> facturas) {
        System.out.println("\n--- LISTADO DE FACTURAS RECIBIDAS ---");
        for (FacturaRecibida factura : facturas) {
            System.out.println(factura);  // Asegúrate de que FacturaRecibida tenga un buen método toString()
        }
    }

    // Método para mostrar mensajes informativos
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Método para mostrar mensajes de error
    public void mostrarError(String mensaje) {
        System.err.println("ERROR: " + mensaje);
    }

    // Método para solicitar modificaciones en una factura existente
    public FacturaRecibida solicitarDatosModificacion(FacturaRecibida factura) {
        scanner.nextLine();  // Limpiar buffer
        System.out.println("\nModificando factura ID: " + factura.getIdFactura());
        
        // Solicitar nuevos datos
        System.out.print("Nuevo proveedor [" + factura.getProveedor() + "]: ");
        String proveedor = scanner.nextLine();
        if (!proveedor.isBlank()) factura.setProveedor(proveedor);
        
        System.out.print("Nueva fecha de emisión [" + factura.getFechaEmision() + "]: ");
        String fechaEmision = scanner.nextLine();
        if (!fechaEmision.isBlank()) factura.setFechaEmision(fechaEmision);

        System.out.print("Nuevo monto total [" + factura.getMontoTotal() + "]: ");
        double montoTotal = scanner.nextDouble();
        if (montoTotal > 0) factura.setMontoTotal(montoTotal);

        return factura;
    }
}


