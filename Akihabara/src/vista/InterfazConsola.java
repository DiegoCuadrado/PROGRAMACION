package vista;

import modelo.ProductoOtaku;
import modelo.ClienteOtaku;

import java.util.List;
import java.util.Scanner;

public class InterfazConsola {

    private final Scanner scanner = new Scanner(System.in);

    // ====== MENÚS ======
    public int mostrarMenuPrincipal() {
        System.out.println("\n===== Akihabara Market - Menú Principal =====");
        System.out.println("1. Ver todos los productos");
        System.out.println("2. Buscar producto por ID");
        System.out.println("3. Agregar nuevo producto");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Generar descripción de producto con IA");
        System.out.println("7. Sugerir categoría para producto con IA");
        System.out.println("8. Gestión de clientes");
        System.out.println("9. Salir");
        return leerOpcion();
    }

    public int mostrarMenuClientes() {
        System.out.println("\n===== Gestión de Clientes =====");
        System.out.println("1. Registrar nuevo cliente");
        System.out.println("2. Buscar cliente por ID");
        System.out.println("3. Ver todos los clientes");
        System.out.println("4. Actualizar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("6. Volver al menú principal");
        return leerOpcion();
    }

    public int leerOpcion() {
        int opcion = -1;
        try {
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            mostrarError("Debe ingresar un número válido.");
        }
        return opcion;
    }

    // ====== PRODUCTOS ======
    public ProductoOtaku solicitarDatosProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Categoría (Figura, Manga, Póster, Llavero, Ropa): ");
        String categoria = scanner.nextLine();

        double precio = solicitarDouble("Precio");
        int stock = solicitarEntero("Stock");

        return new ProductoOtaku(nombre, categoria, precio, stock);
    }

    public ProductoOtaku solicitarDatosActualizados(ProductoOtaku producto) {
        System.out.println("\n--- Actualizar Producto ---");
        System.out.println("Deja vacío cualquier campo para mantener el valor actual.");

        System.out.print("Nuevo nombre (" + producto.getNombre() + "): ");
        String nuevoNombre = scanner.nextLine();
        if (!nuevoNombre.trim().isEmpty()) producto.setNombre(nuevoNombre);

        System.out.print("Nueva categoría (" + producto.getCategoria() + "): ");
        String nuevaCategoria = scanner.nextLine();
        if (!nuevaCategoria.trim().isEmpty()) producto.setCategoria(nuevaCategoria);

        System.out.print("Nuevo precio (" + producto.getPrecio() + "): ");
        String precioStr = scanner.nextLine();
        if (!precioStr.trim().isEmpty()) {
            try {
                producto.setPrecio(Double.parseDouble(precioStr));
            } catch (NumberFormatException e) {
                mostrarError("Precio inválido. Se mantendrá el valor actual.");
            }
        }

        System.out.print("Nuevo stock (" + producto.getStock() + "): ");
        String stockStr = scanner.nextLine();
        if (!stockStr.trim().isEmpty()) {
            try {
                producto.setStock(Integer.parseInt(stockStr));
            } catch (NumberFormatException e) {
                mostrarError("Stock inválido. Se mantendrá el valor actual.");
            }
        }

        return producto;
    }

    public int solicitarIdProducto() {
        System.out.print("Ingrese el ID del producto: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarProducto(ProductoOtaku producto) {
        System.out.println("ID: " + producto.getId());
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Categoría: " + producto.getCategoria());
        System.out.println("Precio: $" + producto.getPrecio());
        System.out.println("Stock: " + producto.getStock());
        System.out.println("----------------------------");
    }

    public void mostrarListaProductos(List<ProductoOtaku> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("\n--- Lista de Productos ---");
        for (ProductoOtaku p : productos) mostrarProducto(p);
    }

    public int solicitarIdParaDescripcionIA() {
        System.out.print("Introduce el ID del producto para generar su descripción con IA: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            mostrarError("ID inválido. Debe ser un número entero.");
            return -1;
        }
    }

    public String solicitarNombreParaSugerenciaCategoria() {
        System.out.print("Introduce el nombre del producto para sugerir categoría con IA: ");
        return scanner.nextLine();
    }

    public void mostrarDescripcionIA(String descripcion) {
        System.out.println("\n--- Descripción Generada por IA ---");
        System.out.println(descripcion);
        System.out.println("-----------------------------------\n");
    }

    public void mostrarSugerenciaCategoria(String categoria) {
        System.out.println("\n--- Categoría Sugerida por IA ---");
        System.out.println("> " + categoria);
        System.out.println("----------------------------------\n");
    }

 // CLIENTES — dentro de InterfazConsola.java

 // Solicitar datos para nuevo cliente
 public ClienteOtaku solicitarDatosCliente() {
     System.out.print("Nombre del cliente: ");
     String nombre = scanner.nextLine();

     System.out.print("Email del cliente: ");
     String email = scanner.nextLine();

     System.out.print("Teléfono del cliente: ");
     String telefono = scanner.nextLine();

     return new ClienteOtaku(nombre, email, telefono);
 }

 // Solicitar ID para búsqueda/modificación
 public int solicitarIdCliente() {
     System.out.print("Ingrese el ID del cliente: ");
     try {
         return Integer.parseInt(scanner.nextLine());
     } catch (NumberFormatException e) {
         mostrarError("ID inválido.");
         return -1;
     }
 }

 // Mostrar un solo cliente
 public void mostrarCliente(ClienteOtaku cliente) {
     System.out.println(cliente);
     System.out.println("-----------------------------------");
 }

 // Mostrar lista de clientes
 public void mostrarListaClientes(List<ClienteOtaku> clientes) {
     if (clientes.isEmpty()) {
         System.out.println("No hay clientes registrados.");
         return;
     }

     System.out.println("\n--- Lista de Clientes ---");
     for (ClienteOtaku c : clientes) {
         mostrarCliente(c);
     }
 }

 // Solicitar actualización
 public ClienteOtaku solicitarDatosActualizadosCliente(ClienteOtaku cliente) {
     System.out.println("\n--- Actualizar Cliente ---");
     System.out.println("Deja vacío para mantener el valor actual.");

     System.out.print("Nuevo nombre (" + cliente.getNombre() + "): ");
     String nombre = scanner.nextLine();
     if (!nombre.trim().isEmpty()) cliente.setNombre(nombre);

     System.out.print("Nuevo email (" + cliente.getEmail() + "): ");
     String email = scanner.nextLine();
     if (!email.trim().isEmpty()) cliente.setEmail(email);

     System.out.print("Nuevo teléfono (" + cliente.getTelefono() + "): ");
     String telefono = scanner.nextLine();
     if (!telefono.trim().isEmpty()) cliente.setTelefono(telefono);

     return cliente;
 }


    // ====== MENSAJES ======
    public void mostrarMensaje(String mensaje) {
        System.out.println("[INFO] " + mensaje);
    }

    public void mostrarError(String error) {
        System.out.println("[ERROR] " + error);
    }

    // ====== UTILS ======
    private double solicitarDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + ": ");
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                mostrarError("Ingrese un número decimal válido.");
            }
        }
    }

    private int solicitarEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + ": ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                mostrarError("Ingrese un número entero válido.");
            }
        }
    }
}





