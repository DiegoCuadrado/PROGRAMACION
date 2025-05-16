package modelo;

public class Articulo {
    private int idArticulo;
    private String nombre;
    private double precioUnitario;
    private int stock;

    // Constructor sin ID (para crear artículos nuevos)
    public Articulo(String nombre, double precioUnitario, int stock) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    // Constructor con ID (para obtener o modificar artículos existentes)
    public Articulo(int idArticulo, String nombre, double precioUnitario, int stock) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    // Getters y Setters
    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método toString para mostrar la información del artículo
    @Override
    public String toString() {
        return "ID: " + idArticulo + ", Nombre: " + nombre + ", Precio: " + precioUnitario + ", Stock: " + stock;
    }
}


