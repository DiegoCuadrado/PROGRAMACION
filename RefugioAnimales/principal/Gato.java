package principal;

public class Gato extends Animal {
    private boolean leucemia;

    public Gato(String chip, String nombre, int edad, String raza, boolean adoptado, boolean leucemia) {
        super(chip, nombre, edad, raza, adoptado);
        this.leucemia = leucemia;
    }

    @Override
    public void mostrar() {
        String leucemiaStr = leucemia ? "sí" : "no";
        System.out.println("Gato - Chip: " + chip + ", Nombre: " + nombre + ", Edad: " + edad + ", Raza: " + raza + ", Adoptado: " + (adoptado ? "sí" : "no") + ", Leucemia: " + leucemiaStr);
    }
}


