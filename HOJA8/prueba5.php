<?php

// Definición de la clase Personaje
class Personaje {
    // Propiedades
    public $nombre;
    public $nivel;
    public $puntosVida;
    public $puntosAtaque;

    // Constructor para inicializar las propiedades
    public function __construct($nombre, $nivel, $puntosVida, $puntosAtaque) {
        $this->nombre = $nombre;
        $this->nivel = $nivel;
        $this->puntosVida = $puntosVida;
        $this->puntosAtaque = $puntosAtaque;
    }

    // Método para atacar a otro personaje
    public function atacar(Personaje $objetivo) {
        // Resta puntos de vida al objetivo según los puntos de ataque del atacante
        echo "{$this->nombre} ataca a {$objetivo->nombre} y le resta {$this->puntosAtaque} puntos de vida.\n";
        $objetivo->puntosVida -= $this->puntosAtaque;
        if ($objetivo->puntosVida < 0) {
            $objetivo->puntosVida = 0;  
        }
    }

    // Método para curarse (restaurar puntos de vida)
    public function curarse() {
        $restaurar = 20; 
        echo "{$this->nombre} se cura y restaura {$restaurar} puntos de vida.\n";
        $this->puntosVida += $restaurar;
        if ($this->puntosVida > 100) {
            $this->puntosVida = 100; 
        }
    }

    // Método para subir de nivel
    public function subirNivel() {
        $this->nivel++;
        $this->puntosAtaque += 10; 
        $this->puntosVida += 20;  
        if ($this->puntosVida > 100) {
            $this->puntosVida = 100; 
        }
        echo "{$this->nombre} ha subido de nivel a nivel {$this->nivel}.\n";
    }

    // Método para mostrar el estado del personaje
    public function mostrarEstado() {
        echo "Nombre: {$this->nombre}\n";
        echo "Nivel: {$this->nivel}\n";
        echo "Puntos de Vida: {$this->puntosVida}\n";
        echo "Puntos de Ataque: {$this->puntosAtaque}\n";
    }
}

// Crear personajes
$heroe = new Personaje("Heroe", 1, 100, 25);
$villano = new Personaje("Villano", 1, 80, 30);

// Mostrar el estado inicial de ambos personajes
echo "Estado Inicial:\n";
$heroe->mostrarEstado();
$villano->mostrarEstado();
echo "--------------------\n";

// Simular una batalla
echo "¡La batalla comienza!\n";
$heroe->atacar($villano);  
$villano->atacar($heroe);  
$heroe->curarse();  
$villano->atacar($heroe);  

// Mostrar el estado después de algunos turnos de batalla
echo "Estado Final Después de Batalla:\n";
$heroe->mostrarEstado();
$villano->mostrarEstado();
echo "--------------------\n";

// Subir de nivel
$heroe->subirNivel();  
$villano->subirNivel();  

// Mostrar el estado después de subir de nivel
echo "Estado Después de Subir de Nivel:\n";
$heroe->mostrarEstado();
$villano->mostrarEstado();

?>
