package Controlador;

import modelo.Cliente;
import modelo.ClienteDAO;
import vista.ClienteVista;
import vista.Utilidades;

import java.util.List;

public class ClienteControlador {

    private ClienteDAO clienteDAO;
    private ClienteVista clienteVista;

    // Constructor con parámetros (para que funcione con Main.java)
    public ClienteControlador(ClienteVista clienteVista, ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
        this.clienteVista = clienteVista;
    }

    // Método para gestionar menú de clientes
    public void gestionarClientes() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Listar clientes");
            System.out.println("2. Agregar cliente");
            System.out.println("3. Modificar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = Utilidades.leerInt();

            switch (opcion) {
                case 1:
                    listarClientes();
                    break;
                case 2:
                    agregarCliente();
                    break;
                case 3:
                    modificarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    public void agregarCliente() {
        String nombre = clienteVista.leerNombre();
        String email = clienteVista.leerEmail();
        String telefono = clienteVista.leerTelefono();

        Cliente cliente = new Cliente(nombre, email, telefono);

        if (clienteDAO.agregar(cliente)) {
            clienteVista.mostrarMensaje("Cliente agregado correctamente.");
        } else {
            clienteVista.mostrarMensaje("Error al agregar el cliente.");
        }
    }

    public void listarClientes() {
        List<Cliente> clientes = clienteDAO.obtenerTodos();
        clienteVista.mostrarClientes(clientes);
    }

    public void modificarCliente() {
        int idCliente = clienteVista.leerIdCliente();
        String nombre = clienteVista.leerNombre();
        String email = clienteVista.leerEmail();
        String telefono = clienteVista.leerTelefono();

        Cliente cliente = new Cliente(idCliente, nombre, email, telefono);

        if (clienteDAO.modificar(cliente)) {
            clienteVista.mostrarMensaje("Cliente modificado correctamente.");
        } else {
            clienteVista.mostrarMensaje("Error al modificar el cliente.");
        }
    }

    public void eliminarCliente() {
        int idCliente = clienteVista.leerIdCliente();

        if (clienteDAO.eliminar(idCliente)) {
            clienteVista.mostrarMensaje("Cliente eliminado correctamente.");
        } else {
            clienteVista.mostrarMensaje("Error al eliminar el cliente.");
        }
    }
}






