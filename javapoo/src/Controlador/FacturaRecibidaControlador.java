package Controlador;

import modelo.FacturaRecibida;
import modelo.FacturaRecibidaDAO;
import vista.FacturaRecibidaVista;

import java.util.List;

public class FacturaRecibidaControlador {
    private FacturaRecibidaVista vista;
    private FacturaRecibidaDAO dao;

    // Constructor que recibe la vista y el DAO para la factura recibida
    public FacturaRecibidaControlador(FacturaRecibidaVista vista, FacturaRecibidaDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    // Método principal para gestionar las facturas recibidas
    public void gestionarFacturasRecibidas() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();  // Muestra el menú de opciones
            switch (opcion) {
                case 1:
                    listarFacturas();  // Lista todas las facturas
                    break;
                case 2:
                    agregarFactura();  // Agrega una nueva factura
                    break;
                case 3:
                    modificarFactura();  // Modifica una factura existente
                    break;
                case 4:
                    eliminarFactura();  // Elimina una factura
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");  // Opción de salir
                    break;
                default:
                    vista.mostrarError("Opción no válida.");  // Si la opción es inválida
            }
        } while (opcion != 0);  // Repite hasta que se elija la opción 0
    }

    // Método para listar las facturas
    private void listarFacturas() {
        List<FacturaRecibida> facturas = dao.obtenerTodas();  // Obtiene todas las facturas del DAO
        if (facturas.isEmpty()) {
            vista.mostrarMensaje("No hay facturas registradas.");
        } else {
            vista.mostrarFacturas(facturas);  // Muestra las facturas en la vista
        }
    }

    // Método para agregar una nueva factura
    private void agregarFactura() {
        FacturaRecibida nuevaFactura = vista.solicitarDatosFactura();  // Solicita los datos de la nueva factura
        boolean exito = dao.agregar(nuevaFactura);  // Intenta agregar la factura al DAO
        if (exito) {
            vista.mostrarMensaje("Factura agregada correctamente.");
        } else {
            vista.mostrarError("No se pudo agregar la factura.");
        }
    }

    // Método para modificar una factura
    private void modificarFactura() {
        int idFactura = vista.solicitarIdFactura();  // Solicita el ID de la factura a modificar
        FacturaRecibida facturaExistente = dao.obtenerPorId(idFactura);  // Obtiene la factura existente por ID
        if (facturaExistente != null) {
            FacturaRecibida facturaModificada = vista.solicitarDatosModificacion(facturaExistente);  // Solicita los nuevos datos
            boolean exito = dao.modificar(facturaModificada);  // Intenta modificar la factura en el DAO
            if (exito) {
                vista.mostrarMensaje("Factura modificada correctamente.");
            } else {
                vista.mostrarError("No se pudo modificar la factura.");
            }
        } else {
            vista.mostrarError("La factura con ID " + idFactura + " no existe.");
        }
    }

    // Método para eliminar una factura
    private void eliminarFactura() {
        int idFactura = vista.solicitarIdFactura();  // Solicita el ID de la factura a eliminar
        boolean exito = dao.eliminar(idFactura);  // Intenta eliminar la factura en el DAO
        if (exito) {
            vista.mostrarMensaje("Factura eliminada correctamente.");
        } else {
            vista.mostrarError("No se pudo eliminar la factura.");
        }
    }
}


