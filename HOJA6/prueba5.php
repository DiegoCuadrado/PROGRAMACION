<?php
class Calculadora {
    public function sumar($a, $b) {
        return $a + $b;
    }

    public function restar($a, $b) {
        return $a - $b;
    }

    public function multiplicar($a, $b) {
        return $a * $b;
    }

    public function dividir($a, $b) {
        if ($b == 0) {
            return "Error: No se puede dividir entre cero.";
        }
        return $a / $b;
    }
}

$calculadora = new Calculadora();

echo "Suma: " . $calculadora->sumar(10, 5) . "<br>";
echo "Resta: " . $calculadora->restar(10, 5) . "<br>";
echo "Multiplicación: " . $calculadora->multiplicar(10, 5) . "<br>";
echo "División: " . $calculadora->dividir(10, 5) . "<br>";
echo "División por cero: " . $calculadora->dividir(10, 0) . "<br>";
?>
