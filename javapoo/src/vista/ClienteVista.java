package vista;

import modelo.Cliente;

import java.util.List;
import java.util.Scanner;

public class ClienteVista {

    private Scanner scanner;

    public ClienteVista() {
        this.scanner = new Scanner(System.in);
    }

    // Mostrar el menú de opciones
    public int mostrarMenu() {
        System.out.println("---- Menú de Gestión de Clientes ----");
        System.out.println("1. Listar Clientes");
        System.out.println("2. Agregar Cliente");
        System.out.println("3. Modificar Cliente");
        System.out.println("4. Eliminar Cliente");
        System.out.println("0. Volver al menú principal");
        System.out.print("Selecciona una opción: ");
        return scanner.nextInt();
    }

    // Métodos para leer los datos del cliente desde la consola
    public String leerNombre() {
        System.out.print("Introduce el nombre del cliente: ");
        return scanner.next();
    }

    public String leerEmail() {
        System.out.print("Introduce el email del cliente: ");
        return scanner.next();
    }

    public String leerTelefono() {
        System.out.print("Introduce el teléfono del cliente: ");
        return scanner.next();
    }

    public int leerIdCliente() {
        System.out.print("Introduce el ID del cliente: ");
        return scanner.nextInt();
    }

    // Métodos para mostrar los resultados
    public void mostrarClientes(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("---- Lista de Clientes ----");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    // Mostrar mensajes
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}



