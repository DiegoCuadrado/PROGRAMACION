<?php

// Definición de la clase Persona
class Persona {
    // Propiedades
    public $nombre;
    public $edad;
    public $genero;

    // Constructor para inicializar las propiedades
    public function __construct($nombre, $edad, $genero) {
        $this->nombre = $nombre;
        $this->edad = $edad;
        $this->genero = $genero;
    }

    // Método para presentar a la persona
    public function presentar() {
        echo "Hola, mi nombre es {$this->nombre}, tengo {$this->edad} años y soy {$this->genero}.";
    }
}

// Crear una instancia de la clase Persona
$persona = new Persona("Juan", 30, "masculino");

// Llamar al método presentar()
$persona->presentar();

?>

