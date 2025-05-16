package Controlador;

import modelo.Articulo;
import modelo.ArticuloDAO;
import vista.ArticuloVista;

import java.util.List;

public class ArticuloControlador {
    private ArticuloVista vista;
    private ArticuloDAO dao;

    public ArticuloControlador(ArticuloVista vista, ArticuloDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    public void gestionarArticulos() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    listarArticulos();
                    break;
                case 2:
                    agregarArticulo();
                    break;
                case 3:
                    modificarArticulo();
                    break;
                case 4:
                    eliminarArticulo();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    vista.mostrarError("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void listarArticulos() {
        List<Articulo> articulos = dao.obtenerTodos();
        if (articulos.isEmpty()) {
            vista.mostrarMensaje("No hay artículos registrados.");
        } else {
            vista.mostrarArticulos(articulos);
        }
    }

    private void agregarArticulo() {
        Articulo nuevoArticulo = vista.solicitarDatosArticulo();
        boolean exito = dao.agregar(nuevoArticulo);
        if (exito) {
            vista.mostrarMensaje("Artículo agregado correctamente.");
        } else {
            vista.mostrarError("No se pudo agregar el artículo.");
        }
    }

    private void modificarArticulo() {
        int idArticulo = vista.solicitarIdArticulo();
        Articulo articuloExistente = dao.obtenerPorId(idArticulo);
        if (articuloExistente != null) {
            Articulo articuloModificado = vista.solicitarDatosModificacion(articuloExistente);
            boolean exito = dao.modificar(articuloModificado);
            if (exito) {
                vista.mostrarMensaje("Artículo modificado correctamente.");
            } else {
                vista.mostrarError("No se pudo modificar el artículo.");
            }
        } else {
            vista.mostrarError("El artículo con ID " + idArticulo + " no existe.");
        }
    }

    private void eliminarArticulo() {
        int idArticulo = vista.solicitarIdArticulo();
        boolean exito = dao.eliminar(idArticulo);
        if (exito) {
            vista.mostrarMensaje("Artículo eliminado correctamente.");
        } else {
            vista.mostrarError("No se pudo eliminar el artículo.");
        }
    }
}


