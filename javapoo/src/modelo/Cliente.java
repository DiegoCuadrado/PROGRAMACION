package modelo;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String email;
    private String telefono;

    // Constructor sin idCliente (para agregar nuevos clientes)
    public Cliente(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    // Constructor con idCliente (para modificar clientes existentes)
    public Cliente(int idCliente, String nombre, String email, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método toString para mostrar la información del cliente
    @Override
    public String toString() {
        return "ID: " + idCliente + ", Nombre: " + nombre + ", Email: " + email + ", Teléfono: " + telefono;
    }
}



