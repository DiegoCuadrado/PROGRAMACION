<?php
class Libro {
    private $titulo;
    private $autor;
    private $numeroPaginas;

    public function __construct($titulo, $autor, $numeroPaginas) {
        $this->titulo = $titulo;
        $this->autor = $autor;
        $this->numeroPaginas = $numeroPaginas;
    }

    public function mostrarInfo() {
        echo "Título: " . $this->titulo . "<br>";
        echo "Autor: " . $this->autor . "<br>";
        echo "Número de páginas: " . $this->numeroPaginas . "<br>";
    }
}

$miLibro = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", 1200);

$miLibro->mostrarInfo();
?>
