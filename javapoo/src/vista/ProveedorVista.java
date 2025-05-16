package vista;

import modelo.Proveedor;

import java.util.List;
import java.util.Scanner;

public class ProveedorVista {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE PROVEEDORES ---");
        System.out.println("1. Listar proveedores");
        System.out.println("2. Agregar proveedor");
        System.out.println("3. Modificar proveedor");
        System.out.println("4. Eliminar proveedor");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Proveedor solicitarDatosProveedor() {
        scanner.nextLine(); // Limpiar buffer
        System.out.println("\nIngrese los datos del proveedor:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine(); // Solicitamos la dirección
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        return new Proveedor(0, nombre, direccion, telefono); // Usamos el constructor adecuado
    }

    public int solicitarIdProveedor() {
        System.out.print("Ingrese el ID del proveedor: ");
        return scanner.nextInt();
    }

    public Proveedor solicitarDatosModificacion(Proveedor proveedor) {
        scanner.nextLine(); // Limpiar buffer
        System.out.println("\nModificando proveedor ID: " + proveedor.getIdProveedor());

        System.out.print("Nuevo nombre [" + proveedor.getNombre() + "]: ");
        String nombre = scanner.nextLine();
        if (!nombre.isBlank()) proveedor.setNombre(nombre);

        System.out.print("Nueva dirección [" + proveedor.getDireccion() + "]: ");
        String direccion = scanner.nextLine();
        if (!direccion.isBlank()) proveedor.setDireccion(direccion); // Solicitamos nueva dirección

        System.out.print("Nuevo teléfono [" + proveedor.getTelefono() + "]: ");
        String telefono = scanner.nextLine();
        if (!telefono.isBlank()) proveedor.setTelefono(telefono);

        return proveedor;
    }

    public void mostrarProveedores(List<Proveedor> proveedores) {
        System.out.println("\n--- LISTADO DE PROVEEDORES ---");
        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedor);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.err.println("ERROR: " + mensaje);
    }
}


