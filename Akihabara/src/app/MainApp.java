package app;

import modelo.ProductoOtaku;
import modelo.ProductoDAO;
import modelo.ClienteOtaku;
import modelo.ClienteDAO;
import servicio.LlmService;
import vista.InterfazConsola;

import java.util.List;


public class MainApp {
    private final InterfazConsola vista;
    private final ProductoDAO dao;
    private final ClienteDAO clienteDAO;
    private final LlmService llmService;
    

    public MainApp() {
        this.vista = new InterfazConsola();
        this.dao = new ProductoDAO();
        this.llmService = new LlmService();
        this.clienteDAO = new ClienteDAO(); // <== esto es lo nuevo
    }


    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            int opcion = vista.mostrarMenuPrincipal(); // leer y mostrar menú en una sola línea

            switch (opcion) {
                case 1 -> mostrarTodosLosProductos();
                case 2 -> consultarProductoPorId();
                case 3 -> agregarProducto();
                case 4 -> actualizarProducto();
                case 5 -> eliminarProducto();
                case 6 -> generarDescripcionConIA();
                case 7 -> sugerirCategoriaConIA();
                case 8 -> gestionarClientes(); // Nuevo submenú
                case 9 -> {
                    vista.mostrarMensaje("¡Hasta pronto, Maestro Kenji!");
                    salir = true;
                }
                default -> vista.mostrarError("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void agregarProducto() {
        ProductoOtaku nuevo = vista.solicitarDatosProducto();
        dao.agregarProducto(nuevo);
        vista.mostrarMensaje("Producto añadido correctamente.");
    }

    private void consultarProductoPorId() {
        int id = vista.solicitarIdProducto();
        ProductoOtaku producto = dao.obtenerProductoPorId(id);
        if (producto != null) {
            vista.mostrarProducto(producto);
        } else {
            vista.mostrarError("Producto no encontrado.");
        }
    }

    private void mostrarTodosLosProductos() {
        List<ProductoOtaku> productos = dao.obtenerTodosLosProductos();
        if (productos.isEmpty()) {
            vista.mostrarMensaje("No hay productos registrados.");
        } else {
            vista.mostrarListaProductos(productos);
        }
    }

    private void actualizarProducto() {
        int id = vista.solicitarIdProducto();
        ProductoOtaku producto = dao.obtenerProductoPorId(id);
        if (producto == null) {
            vista.mostrarError("Producto no encontrado.");
            return;
        }

        vista.solicitarDatosActualizados(producto);

        if (dao.actualizarProducto(producto)) {
            vista.mostrarMensaje("Producto actualizado.");
        } else {
            vista.mostrarError("No se pudo actualizar el producto.");
        }
    }

    private void eliminarProducto() {
        int id = vista.solicitarIdProducto();
        if (dao.eliminarProducto(id)) {
            vista.mostrarMensaje("Producto eliminado.");
        } else {
            vista.mostrarError("No se pudo eliminar el producto.");
        }
    }

    private void generarDescripcionConIA() {
        int id = vista.solicitarIdParaDescripcionIA();
        if (id <= 0) return;

        ProductoOtaku producto = dao.obtenerProductoPorId(id);
        if (producto == null) {
            vista.mostrarError("Producto no encontrado.");
            return;
        }

        String prompt = String.format(
            "Genera en español una descripción de marketing breve y atractiva para un producto otaku llamado \"%s\", que pertenece a la categoría \"%s\".",
            producto.getNombre(),
            producto.getCategoria()
        );

        String descripcion = llmService.preguntarLLM(prompt);
        vista.mostrarDescripcionIA(descripcion);
    }

    private void sugerirCategoriaConIA() {
        String nombre = vista.solicitarNombreParaSugerenciaCategoria();

        String prompt = String.format(
            "En español, para un producto otaku llamado \"%s\", sugiere una categoría adecuada eligiendo de esta lista: Figura, Manga, Póster, Llavero, Ropa, Videojuego, Otro.",
            nombre
        );

        String sugerencia = llmService.preguntarLLM(prompt);
        vista.mostrarDescripcionIA("Categoría sugerida: " + sugerencia);
    }

    // Puedes completar esto según tus clases ClienteOtaku, ClienteDAO, etc.
   

    public static void main(String[] args) {
        new MainApp().iniciar();
    }
    private void gestionarClientes() {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Ver todos los clientes");
            System.out.println("2. Buscar cliente por ID");
            System.out.println("3. Agregar nuevo cliente");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Volver al menú principal");

            int opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    vista.mostrarListaClientes(clienteDAO.obtenerTodosLosClientes());
                    break;
                case 2:
                    int idConsulta = vista.solicitarIdCliente();
                    ClienteOtaku cliente = clienteDAO.obtenerClientePorId(idConsulta);
                    if (cliente != null) vista.mostrarCliente(cliente);
                    else vista.mostrarError("Cliente no encontrado.");
                    break;
                case 3:
                    ClienteOtaku nuevo = vista.solicitarDatosCliente();
                    clienteDAO.agregarCliente(nuevo);
                    vista.mostrarMensaje("Cliente agregado.");
                    break;
                case 4:
                    int idActualizar = vista.solicitarIdCliente();
                    ClienteOtaku actualizar = clienteDAO.obtenerClientePorId(idActualizar);
                    if (actualizar != null) {
                        vista.solicitarDatosActualizadosCliente(actualizar);
                        clienteDAO.actualizarCliente(actualizar);
                        vista.mostrarMensaje("Cliente actualizado.");
                    } else {
                        vista.mostrarError("Cliente no encontrado.");
                    }
                    break;
                case 5:
                    int idEliminar = vista.solicitarIdCliente();
                    if (clienteDAO.eliminarCliente(idEliminar)) {
                        vista.mostrarMensaje("Cliente eliminado.");
                    } else {
                        vista.mostrarError("Cliente no encontrado.");
                    }
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    vista.mostrarError("Opción inválida.");
            }
        }
    }

    
}





