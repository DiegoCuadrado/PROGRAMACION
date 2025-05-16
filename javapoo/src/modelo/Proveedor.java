package modelo;

public class Proveedor {
    private int idProveedor;
    private String nombre;
    private String direccion;
    private String telefono;

    // Constructor con todos los parámetros
    public Proveedor(int idProveedor, String nombre, String direccion, String telefono) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y setters
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // ToString para mostrar información de manera más fácil
    @Override
    public String toString() {
        return "ID: " + idProveedor + ", Nombre: " + nombre + ", Dirección: " + direccion + ", Teléfono: " + telefono;
    }
}







