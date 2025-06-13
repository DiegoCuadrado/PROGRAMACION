package modelo;

import java.time.LocalDate;

public class ClienteOtaku {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private LocalDate fechaRegistro;

    // Constructor para nuevos clientes (sin ID)
    public ClienteOtaku(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fechaRegistro = LocalDate.now(); // Se asume al momento de crear
    }

    // Constructor completo (por ejemplo, al leer de la base de datos)
    public ClienteOtaku(int id, String nombre, String email, String telefono, LocalDate fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
    }

    public ClienteOtaku(int id2, String string, String string2, Object object) {
		// TODO Auto-generated constructor stub
	}

	// Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    // Para mostrar en consola o en diálogos
    @Override
    public String toString() {
        return "Cliente ID: " + id + ", Nombre: " + nombre + ", Email: " + email +
                ", Teléfono: " + telefono + ", Fecha Registro: " + fechaRegistro;
    }
}

