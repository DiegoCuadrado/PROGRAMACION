package Controlador;

import modelo.Venta;
import modelo.VentaDAO;
import vista.VentaVista;

import java.util.List;

public class VentaControlador {
    private VentaVista vista;
    private VentaDAO dao;

    public VentaControlador(VentaVista vista, VentaDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    public void gestionarVentas() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    listarVentas();
                    break;
                case 2:
                    agregarVenta();
                    break;
                case 3:
                    modificarVenta();
                    break;
                case 4:
                    eliminarVenta();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    vista.mostrarError("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void listarVentas() {
        List<Venta> ventas = dao.obtenerTodas();
        if (ventas.isEmpty()) {
            vista.mostrarMensaje("No hay ventas registradas.");
        } else {
            vista.mostrarVentas(ventas);
        }
    }

    private void agregarVenta() {
        Venta nuevaVenta = vista.solicitarDatosVenta();
        boolean exito = dao.agregar(nuevaVenta);
        if (exito) {
            vista.mostrarMensaje("Venta agregada correctamente.");
        } else {
            vista.mostrarError("No se pudo agregar la venta.");
        }
    }

    private void modificarVenta() {
        int idVenta = vista.solicitarIdVenta();
        Venta ventaExistente = dao.obtenerPorId(idVenta);
        if (ventaExistente != null) {
            Venta ventaModificada = vista.solicitarDatosModificacion(ventaExistente);
            boolean exito = dao.modificar(ventaModificada);
            if (exito) {
                vista.mostrarMensaje("Venta modificada correctamente.");
            } else {
                vista.mostrarError("No se pudo modificar la venta.");
            }
        } else {
            vista.mostrarError("La venta con ID " + idVenta + " no existe.");
        }
    }

    private void eliminarVenta() {
        int idVenta = vista.solicitarIdVenta();
        boolean exito = dao.eliminar(idVenta);
        if (exito) {
            vista.mostrarMensaje("Venta eliminada correctamente.");
        } else {
            vista.mostrarError("No se pudo eliminar la venta.");
        }
    }
}

