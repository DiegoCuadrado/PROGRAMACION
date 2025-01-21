<?php

// Definición de la clase ConversorMoneda
class ConversorMoneda {
    // Factor de conversión fijo
    private $factorDolarAEuro = 0.85;  
    private $factorEuroADolar = 1.18;  

    // Método para convertir dólares a euros
    public function convertirDolaresAEuros($dolares) {
        return $dolares * $this->factorDolarAEuro;
    }

    // Método para convertir euros a dólares
    public function convertirEurosADolares($euros) {
        return $euros * $this->factorEuroADolar;
    }
}

// Crear una instancia de la clase ConversorMoneda
$conversor = new ConversorMoneda();

// Realizar varias conversiones
$dolares = 100;
$euros = 100;

$convertidoAEuros = $conversor->convertirDolaresAEuros($dolares);
$convertidoADolares = $conversor->convertirEurosADolares($euros);

// Mostrar los resultados de las conversiones
echo "{$dolares} dólares son equivalentes a {$convertidoAEuros} euros.\n";
echo "{$euros} euros son equivalentes a {$convertidoADolares} dólares.\n";

?>
