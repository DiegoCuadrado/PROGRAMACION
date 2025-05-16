package Controlador;

import modelo.Proveedor;
import modelo.ProveedorDAO;
import vista.ProveedorVista;

import java.util.List;

public class ProveedorControlador {
    private ProveedorVista vista;
    private ProveedorDAO dao;

    public ProveedorControlador(ProveedorVista vista, ProveedorDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    public void gestionarProveedores() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    listarProveedores();
                    break;
                case 2:
                    agregarProveedor();
                    break;
                case 3:
                    modificarProveedor();
                    break;
                case 4:
                    eliminarProveedor();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    vista.mostrarError("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void listarProveedores() {
        List<Proveedor> proveedores = dao.obtenerTodos();
        if (proveedores.isEmpty()) {
            vista.mostrarMensaje("No hay proveedores registrados.");
        } else {
            vista.mostrarProveedores(proveedores);
        }
    }

    private void agregarProveedor() {
        Proveedor nuevoProveedor = vista.solicitarDatosProveedor();
        boolean exito = dao.agregar(nuevoProveedor);
        if (exito) {
            vista.mostrarMensaje("Proveedor agregado correctamente.");
        } else {
            vista.mostrarError("No se pudo agregar el proveedor.");
        }
    }

    private void modificarProveedor() {
        int idProveedor = vista.solicitarIdProveedor();
        Proveedor proveedorExistente = dao.obtenerPorId(idProveedor);
        if (proveedorExistente != null) {
            Proveedor proveedorModificado = vista.solicitarDatosModificacion(proveedorExistente);
            boolean exito = dao.modificar(proveedorModificado);
            if (exito) {
                vista.mostrarMensaje("Proveedor modificado correctamente.");
            } else {
                vista.mostrarError("No se pudo modificar el proveedor.");
            }
        } else {
            vista.mostrarError("El proveedor con ID " + idProveedor + " no existe.");
        }
    }

    private void eliminarProveedor() {
        int idProveedor = vista.solicitarIdProveedor();
        boolean exito = dao.eliminar(idProveedor);
        if (exito) {
            vista.mostrarMensaje("Proveedor eliminado correctamente.");
        } else {
            vista.mostrarError("No se pudo eliminar el proveedor.");
        }
    }
}

