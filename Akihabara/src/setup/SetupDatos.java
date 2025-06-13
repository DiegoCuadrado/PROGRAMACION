package setup;
import java.util.List;

import modelo.ProductoDAO;
import modelo.ProductoOtaku;

public class SetupDatos {

    public static void inicializarDatos() {
        ProductoDAO dao = new ProductoDAO();
        List<ProductoOtaku> lista = dao.obtenerTodosLosProductos();

        if (lista.isEmpty()) {
            System.out.println("Insertando productos iniciales en la base de datos...");

            dao.agregarProducto(new ProductoOtaku("Figura de Anya Forger", "Figura", 59.95, 8));
            dao.agregarProducto(new ProductoOtaku("Manga Chainsaw Man Vol.1", "Manga", 9.99, 20));
            dao.agregarProducto(new ProductoOtaku("Póster Studio Ghibli Colección", "Póster", 15.50, 15));

            System.out.println("Productos iniciales insertados correctamente.");
        } else {
            System.out.println("Ya existen productos en la base de datos. No se insertó nada.");
        }
    }
}

