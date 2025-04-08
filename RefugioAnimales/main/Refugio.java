package main;

import principal.Animal;
import principal.Perro;
import principal.Gato;
import java.util.ArrayList;
import java.util.Scanner;

public class Refugio {
    static ArrayList<Animal> animales = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Alta Animal");
            System.out.println("2. Buscar Animal");
            System.out.println("3. Salir");
            String opcion = sc.next();

            switch (opcion) {
                case "1":
                    alta();
                    break;
                case "2":
                    buscar();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    static void alta() {
        System.out.println("Tipo (Perro/Gato):");
        String tipo = sc.next();

        System.out.println("Chip:");
        String chip = sc.next();

        for (Animal a : animales) {
            if (a.getChip().equals(chip)) {
                System.out.println("El chip ya existe.");
                return;
            }
        }

        System.out.println("Nombre:");
        String nombre = sc.next();

        System.out.println("Edad:");
        int edad = Integer.parseInt(sc.next());

        System.out.println("Raza:");
        String raza = sc.next();

        System.out.println("¿Adoptado? (sí/no):");
        String adoptadoInput = sc.next();
        boolean adoptado = adoptadoInput.equals("sí");

        if (tipo.equals("Perro")) {
            System.out.println("Tamaño (pequeño/mediano/grande):");
            String tamaño = sc.next();
            animales.add(new Perro(chip, nombre, edad, raza, adoptado, tamaño));
        } else if (tipo.equals("Gato")) {
            System.out.println("¿Test leucemia positivo? (sí/no):");
            String leucemiaInput = sc.next();
            boolean leucemia = leucemiaInput.equals("sí");
            animales.add(new Gato(chip, nombre, edad, raza, adoptado, leucemia));
        } else {
            System.out.println("Tipo no reconocido.");
        }
    }

    static void buscar() {
        System.out.println("Introduce chip a buscar:");
        String chip = sc.next();

        for (Animal a : animales) {
            if (a.getChip().equals(chip)) {
                a.mostrar();
                return;
            }
        }
        System.out.println("Animal no encontrado.");
    }
}

