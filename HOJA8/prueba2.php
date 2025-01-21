<?php

// Definición de la clase Tarea
class Tarea {
    public $nombre;
    public $descripcion;
    public $fechaLimite;
    public $estado;

    // Constructor para inicializar las propiedades
    public function __construct($nombre, $descripcion, $fechaLimite) {
        $this->nombre = $nombre;
        $this->descripcion = $descripcion;
        $this->fechaLimite = $fechaLimite;
        $this->estado = "pendiente"; 
    }

    // Método para marcar la tarea como completada
    public function marcarComoCompletada() {
        $this->estado = "completada";
        echo "La tarea '{$this->nombre}' ha sido marcada como completada.\n";
    }

    // Método para editar la descripción de la tarea
    public function editarDescripcion($nuevaDescripcion) {
        $this->descripcion = $nuevaDescripcion;
        echo "La descripción de la tarea '{$this->nombre}' ha sido actualizada.\n";
    }

    // Método para mostrar la información de la tarea
    public function mostrarTarea() {
        echo "Nombre: {$this->nombre}\n";
        echo "Descripción: {$this->descripcion}\n";
        echo "Fecha Límite: {$this->fechaLimite}\n";
        echo "Estado: {$this->estado}\n";
    }
}

// Crear una lista de tareas
$tareas = [
    new Tarea("Comprar víveres", "Comprar frutas y verduras", "2025-01-22"),
    new Tarea("Hacer ejercicio", "Ir al gimnasio por una hora", "2025-01-23"),
    new Tarea("Leer un libro", "Leer al menos 50 páginas de un libro", "2025-01-24")
];

// Mostrar todas las tareas
foreach ($tareas as $tarea) {
    $tarea->mostrarTarea();
    echo "---------------------\n";
}

// Marcar la primera tarea como completada
$tareas[0]->marcarComoCompletada();

// Editar la descripción de la segunda tarea
$tareas[1]->editarDescripcion("Ir al parque a correr");

// Mostrar el estado actualizado de todas las tareas
foreach ($tareas as $tarea) {
    $tarea->mostrarTarea();
    echo "---------------------\n";
}

?>
