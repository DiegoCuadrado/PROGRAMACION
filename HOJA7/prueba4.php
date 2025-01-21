<?php

// Definición de la clase Producto
class Producto {
    public $nombre;
    public $precio;

    // Constructor para inicializar las propiedades
    public function __construct($nombre, $precio) {
        $this->nombre = $nombre;
        $this->precio = $precio;
    }

    // Método para mostrar detalles del producto
    public function mostrarDetalles() {
        echo "Producto: {$this->nombre}, Precio: \${$this->precio}\n";
    }
}

// Definición de la clase Electrodoméstico que hereda de Producto
class Electrodomestico extends Producto {
    public $consumo;

    // Constructor para inicializar propiedades de Producto y Electrodoméstico
    public function __construct($nombre, $precio, $consumo) {
        parent::__construct($nombre, $precio);
        $this->consumo = $consumo;
    }

    // Sobrescribir el método mostrarDetalles()
    public function mostrarDetalles() {
        echo "Electrodoméstico: {$this->nombre}, Precio: \${$this->precio}, Consumo: {$this->consumo} kWh\n";
    }
}

// Crear una instancia de la clase Producto
$producto = new Producto("Libro", 20);

// Crear una instancia de la clase Electrodoméstico
$electrodomestico = new Electrodomestico("Lavadora", 300, 0.8);

// Mostrar los detalles de ambos objetos
$producto->mostrarDetalles();
$electrodomestico->mostrarDetalles();

?>
