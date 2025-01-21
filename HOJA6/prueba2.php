<?php
class Circulo {
    private $radio;

    
    public function __construct($radio) {
        $this->radio = $radio;
    }

    public function calcularArea() {
        return pi() * pow($this->radio, 2);  
    }
}

$miCirculo = new Circulo(5);

$area = $miCirculo->calcularArea();
echo "El área del círculo con radio 5 es: " . $area;
?>
