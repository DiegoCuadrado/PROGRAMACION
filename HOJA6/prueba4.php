<?php
class Empleado {
    protected $nombre;
    protected $sueldo;

    public function __construct($nombre, $sueldo) {
        $this->nombre = $nombre;
        $this->sueldo = $sueldo;
    }

    public function mostrarDetalles() {
        echo "Nombre: " . $this->nombre . "<br>";
        echo "Sueldo: " . $this->sueldo . "<br>";
    }
}

class Gerente extends Empleado {
    private $departamento;

    public function __construct($nombre, $sueldo, $departamento) {
        parent::__construct($nombre, $sueldo);
        $this->departamento = $departamento;
    }

    public function mostrarDetalles() {
        parent::mostrarDetalles();
        echo "Departamento: " . $this->departamento . "<br>";
    }
}

$empleado = new Empleado("Juan Pérez", 3000);
$empleado->mostrarDetalles();

echo "<hr>";

$gerente = new Gerente("Ana López", 5000, "Ventas");
$gerente->mostrarDetalles();
?>
