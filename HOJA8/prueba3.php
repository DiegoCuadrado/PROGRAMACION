<?php

// Definición de la clase Empleado
class Empleado {
    public $nombre;
    public $sueldo;
    public $aniosExperiencia;

    // Constructor para inicializar las propiedades
    public function __construct($nombre, $sueldo, $aniosExperiencia) {
        $this->nombre = $nombre;
        $this->sueldo = $sueldo;
        $this->aniosExperiencia = $aniosExperiencia;
    }

    // Método para calcular el bonus
    public function calcularBonus() {
        $bonus = ($this->aniosExperiencia / 2) * (0.05 * $this->sueldo);
        return $bonus;
    }

    // Método para mostrar los detalles del empleado
    public function mostrarDetalles() {
        echo "Nombre: {$this->nombre}\n";
        echo "Sueldo: \${$this->sueldo}\n";
        echo "Años de Experiencia: {$this->aniosExperiencia}\n";
        echo "Bonus: \${$this->calcularBonus()}\n";
    }
}

// Definición de la clase Consultor que hereda de Empleado
class Consultor extends Empleado {
    // Propiedad adicional específica de Consultor
    public $horasPorProyecto;

    // Constructor para inicializar las propiedades de Empleado y Consultor
    public function __construct($nombre, $sueldo, $aniosExperiencia, $horasPorProyecto) {
        parent::__construct($nombre, $sueldo, $aniosExperiencia);
        $this->horasPorProyecto = $horasPorProyecto;
    }

    // Sobrescribir el método calcularBonus
    public function calcularBonus() {
        $bonus = parent::calcularBonus(); 
        if ($this->horasPorProyecto > 100) {
            $bonus += 0.10 * $this->sueldo; 
        }
        return $bonus;
    }

    // Mostrar los detalles del consultor
    public function mostrarDetalles() {
        echo "Nombre: {$this->nombre}\n";
        echo "Sueldo: \${$this->sueldo}\n";
        echo "Años de Experiencia: {$this->aniosExperiencia}\n";
        echo "Horas por Proyecto: {$this->horasPorProyecto}\n";
        echo "Bonus: \${$this->calcularBonus()}\n";
    }
}

// Crear una instancia de la clase Empleado
$empleado = new Empleado("Juan Pérez", 40000, 6);

// Crear una instancia de la clase Consultor
$consultor = new Consultor("Ana Gómez", 50000, 4, 120);

// Mostrar los detalles de ambos
echo "Detalles del Empleado:\n";
$empleado->mostrarDetalles();
echo "\nDetalles del Consultor:\n";
$consultor->mostrarDetalles();

?>
