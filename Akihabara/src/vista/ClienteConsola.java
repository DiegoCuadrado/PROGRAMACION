package vista;

import modelo.ClienteOtaku;
import modelo.ClienteDAO;

import java.util.List;
import java.util.Scanner;

public class ClienteConsola {

    private ClienteDAO clienteDAO;
    private Scanner scanner;

    public ClienteConsola() {
        clienteDAO = new ClienteDAO();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenuClientes() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Añadir nuevo cliente");
            System.out.println("2. Consultar cliente por ID");
            System.out.println("3. Ver todos los clientes");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1 -> agregarCliente();
                case 2 -> consultarPorId();
                case 3 -> mostrarTodos();
                case 4 -> actualizarCliente();
                case 5 -> eliminarCliente();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void agregarCliente() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        ClienteOtaku cliente = new ClienteOtaku(nombre, email, telefono);
        clienteDAO.agregarCliente(cliente);
        System.out.println("Cliente agregado.");
    }

    private void consultarPorId() {
        System.out.print("ID del cliente: ");
        int id = scanner.nextInt();
        ClienteOtaku cliente = clienteDAO.obtenerClientePorId(id);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private void mostrarTodos() {
        List<ClienteOtaku> lista = clienteDAO.obtenerTodosLosClientes();
        for (ClienteOtaku c : lista) {
            System.out.println(c);
        }
    }

    private void actualizarCliente() {
        System.out.print("ID del cliente a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        ClienteOtaku existente = clienteDAO.obtenerClientePorId(id);
        if (existente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (" + existente.getNombre() + "): ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo email (" + existente.getEmail() + "): ");
        String email = scanner.nextLine();
        System.out.print("Nuevo teléfono (" + existente.getTelefono() + "): ");
        String telefono = scanner.nextLine();

        ClienteOtaku actualizado = new ClienteOtaku(id,
                nombre.isEmpty() ? existente.getNombre() : nombre,
                email.isEmpty() ? existente.getEmail() : email,
                telefono.isEmpty() ? existente.getTelefono() : telefono);

        clienteDAO.actualizarCliente(actualizado);
        System.out.println("Cliente actualizado.");
    }

    private void eliminarCliente() {
        System.out.print("ID del cliente a eliminar: ");
        int id = scanner.nextInt();
        if (clienteDAO.eliminarCliente(id)) {
            System.out.println("Cliente eliminado.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
    }
}

