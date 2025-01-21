<?php

// Definición de la clase Rectángulo
class Rectangulo {
    public $base;
    public $altura;

    // Constructor para inicializar las propiedades
    public function __construct($base, $altura) {
        $this->base = $base;
        $this->altura = $altura;
    }

    // Método para calcular el área del rectángulo
    public function calcularArea() {
        return $this->base * $this->altura;
    }
}


$rectangulo = new Rectangulo(10, 5);

// Calcular y mostrar el área del rectángulo
echo "El área del rectángulo es: " . $rectangulo->calcularArea();

?>
