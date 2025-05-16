import Controlador.*;
import modelo.*;
import vista.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear las instancias de las vistas y los DAOs
        ClienteVista clienteVista = new ClienteVista();
        ProveedorVista proveedorVista = new ProveedorVista();
        ArticuloVista articuloVista = new ArticuloVista();
        FacturaRecibidaVista facturaRecibidaVista = new FacturaRecibidaVista();
        VentaVista ventaVista = new VentaVista();

        ClienteDAO clienteDAO = new ClienteDAO();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        ArticuloDAO articuloDAO = new ArticuloDAO();  // Línea corregida: asegúrate de que exista la clase
        FacturaRecibidaDAO facturaRecibidaDAO = new FacturaRecibidaDAO();
        VentaDAO ventaDAO = new VentaDAO();  // Se pasa ArticuloDAO al constructor

        // Crear los controladores para cada entidad
        ClienteControlador clienteControlador = new ClienteControlador(clienteVista, clienteDAO);
        ProveedorControlador proveedorControlador = new ProveedorControlador(proveedorVista, proveedorDAO);
        ArticuloControlador articuloControlador = new ArticuloControlador(articuloVista, articuloDAO);
        FacturaRecibidaControlador facturaRecibidaControlador = new FacturaRecibidaControlador(facturaRecibidaVista, facturaRecibidaDAO);
        VentaControlador ventaControlador = new VentaControlador(ventaVista, ventaDAO);

        // Menú principal de la aplicación
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Proveedores");
            System.out.println("3. Gestión de Artículos");
            System.out.println("4. Gestión de Facturas Recibidas");
            System.out.println("5. Gestión de Ventas");
            System.out.println("6. Informes de Ventas por Cliente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Utilidades.leerInt();

            switch (opcion) {
                case 1:
                    clienteControlador.gestionarClientes();  // Línea corregida: asegúrate de que el método exista
                    break;
                case 2:
                    proveedorControlador.gestionarProveedores();
                    break;
                case 3:
                    articuloControlador.gestionarArticulos();
                    break;
                case 4:
                    facturaRecibidaControlador.gestionarFacturasRecibidas();
                    break;
                case 5:
                    ventaControlador.gestionarVentas();
                    break;
                case 6:
                    generarInformeVentasPorCliente(ventaDAO);
                    break;
                case 0:
                    System.out.println("Gracias por usar la aplicación. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void generarInformeVentasPorCliente(VentaDAO ventaDAO) {
        System.out.println("\n=== Informe de Ventas por Cliente ===");
        System.out.print("Ingrese el ID del cliente para generar el informe: ");
        int idCliente = Utilidades.leerInt();

        List<Venta> ventas = ventaDAO.obtenerVentasPorCliente(idCliente); // Este método debe existir

        if (ventas.isEmpty()) {
            System.out.println("El cliente con ID " + idCliente + " no tiene ventas registradas.");
        } else {
            double totalGastado = 0;
            System.out.println("Ventas de Cliente ID " + idCliente + ":");
            for (Venta venta : ventas) {
                Articulo articulo = venta.getArticulo(new ArticuloDAO());  // Obtener artículo utilizando ArticuloDAO
                System.out.println("Artículo: " + articulo.getNombre() +
                        ", Cantidad: " + venta.getCantidad() +
                        ", Fecha: " + venta.getFechaVenta());
                totalGastado += venta.getCantidad() * articulo.getPrecioUnitario();
            }
            System.out.println("Total gastado: €" + totalGastado);
        }
    }
}




