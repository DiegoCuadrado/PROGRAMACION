package principal;

public class Perro extends Animal {
    private String tamaño;

    public Perro(String chip, String nombre, int edad, String raza, boolean adoptado, String tamaño) {
        super(chip, nombre, edad, raza, adoptado);
        this.tamaño = tamaño;
    }

    public void mostrar() {
        System.out.println("Perro - Chip: " + chip + ", Nombre: " + nombre + ", Edad: " + edad + ", Raza: " + raza + ", Adoptado: " + adoptado + ", Tamaño: " + tamaño);
    }
}
// @implements class code

