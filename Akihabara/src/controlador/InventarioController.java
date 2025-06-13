package controlador;

import modelo.ProductoDAO;
import modelo.ProductoOtaku;
import vista.InterfazConsola;

import java.util.List;

public class InventarioController {

    private final InterfazConsola vista;
    private final ProductoDAO dao;

    public InventarioController() {
        this.vista = new InterfazConsola();
        this.dao = new ProductoDAO();
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            int opcion = vista.mostrarMenuPrincipal();

            switch (opcion) {
                case 1 -> verTodosLosProductos();
                case 2 -> consultarProductoPorId();
                case 3 -> agregarNuevoProducto();
                case 4 -> actualizarProducto();
                case 5 -> eliminarProducto();
                case 6 -> usarAsistenteIA(); // módulo 3
                case 7 -> {
                    vista.mostrarMensaje("¡Gracias por usar Akihabara Market!");
                    salir = true;
                }
                default -> vista.mostrarError("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void verTodosLosProductos() {
        List<ProductoOtaku> productos = dao.obtenerTodosLosProductos();
        vista.mostrarListaProductos(productos);
    }

    private void consultarProductoPorId() {
        try {
            int id = vista.solicitarIdProducto();
            ProductoOtaku producto = dao.obtenerProductoPorId(id);

            if (producto != null) {
                vista.mostrarProducto(producto);
            } else {
                vista.mostrarMensaje("No se encontró un producto con ese ID.");
            }
        } catch (NumberFormatException e) {
            vista.mostrarError("ID inválido.");
        }
    }

    private void agregarNuevoProducto() {
        try {
            ProductoOtaku nuevo = vista.solicitarDatosProducto();
            dao.agregarProducto(nuevo);
            vista.mostrarMensaje("Producto agregado correctamente.");
        } catch (Exception e) {
            vista.mostrarError("Error al agregar producto: " + e.getMessage());
        }
    }

    private void actualizarProducto() {
        try {
            int id = vista.solicitarIdProducto();
            ProductoOtaku producto = dao.obtenerProductoPorId(id);

            if (producto != null) {
                ProductoOtaku actualizado = vista.solicitarDatosActualizados(producto);
                boolean ok = dao.actualizarProducto(actualizado);
                if (ok) {
                    vista.mostrarMensaje("Producto actualizado correctamente.");
                } else {
                    vista.mostrarError("Error al actualizar el producto.");
                }
            } else {
                vista.mostrarMensaje("No existe un producto con ese ID.");
            }
        } catch (Exception e) {
            vista.mostrarError("Error al actualizar producto: " + e.getMessage());
        }
    }

    private void eliminarProducto() {
        try {
            int id = vista.solicitarIdProducto();
            boolean eliminado = dao.eliminarProducto(id);

            if (eliminado) {
                vista.mostrarMensaje("Producto eliminado correctamente.");
            } else {
                vista.mostrarMensaje("No se encontró producto con ese ID.");
            }
        } catch (Exception e) {
            vista.mostrarError("Error al eliminar producto: " + e.getMessage());
        }
    }

    private void usarAsistenteIA() {
        vista.mostrarMensaje("Funcionalidad de IA aún no implementada (Módulo 3).");
    }
}
