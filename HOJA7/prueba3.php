<?php

// Definición de la clase Animal
class Animal {
    public $especie;

    // Constructor para inicializar la especie
    public function __construct($especie) {
        $this->especie = $especie;
    }

    // Método para emitir sonido
    public function emitirSonido() {
        echo "Este animal hace un sonido genérico.";
    }
}

// Definición de la clase Perro que hereda de Animal
class Perro extends Animal {
    public $raza;

    // Constructor para inicializar especie y raza
    public function __construct($especie, $raza) {
        parent::__construct($especie);
        $this->raza = $raza;
    }

    // Método para emitir el sonido específico de un perro
    public function emitirSonido() {
        echo "El perro ladra: ¡Guau, guau!";
    }
}

// Crear una instancia de la clase Perro
$miPerro = new Perro("Mamífero", "Labrador");

// Mostrar las propiedades y llamar a los métodos
echo "Especie: " . $miPerro->especie . "\n";
echo "Raza: " . $miPerro->raza . "\n";
$miPerro->emitirSonido();

?>
