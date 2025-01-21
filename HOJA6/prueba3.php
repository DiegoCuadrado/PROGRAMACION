<?php
class Vehiculo {
    protected $marca;

    public function __construct($marca) {
        $this->marca = $marca;
    }

    public function encender() {
        echo "El vehículo de marca " . $this->marca . " ha sido encendido.<br>";
    }
}

class Coche extends Vehiculo {
    private $modelo;

    
    public function __construct($marca, $modelo) {
        parent::__construct($marca);
        $this->modelo = $modelo;
    }

    public function mostrarInfo() {
        echo "Marca: " . $this->marca . "<br>";
        echo "Modelo: " . $this->modelo . "<br>";
    }
}

$miCoche = new Coche("Toyota", "Corolla");

$miCoche->encender();   
$miCoche->mostrarInfo();  
?>
