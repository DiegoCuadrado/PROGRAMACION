<?php

// Definición de la clase CuentaBancaria
class CuentaBancaria {
    // Propiedades
    public $titular;
    public $saldo;
    public $tipoDeCuenta;

    // Constructor para inicializar las propiedades
    public function __construct($titular, $saldoInicial, $tipoDeCuenta) {
        $this->titular = $titular;
        $this->saldo = $saldoInicial;
        $this->tipoDeCuenta = $tipoDeCuenta;
    }

    // Método para depositar una cantidad
    public function depositar($cantidad) {
        if ($cantidad > 0) {
            $this->saldo += $cantidad;
            echo "Se han depositado \${$cantidad}. Saldo actual: \${$this->saldo}\n";
        } else {
            echo "La cantidad a depositar debe ser mayor que 0.\n";
        }
    }

    // Método para retirar una cantidad
    public function retirar($cantidad) {
        if ($cantidad > 0 && $cantidad <= $this->saldo) {
            $this->saldo -= $cantidad;
            echo "Se han retirado \${$cantidad}. Saldo actual: \${$this->saldo}\n";
        } else {
            echo "Fondos insuficientes o cantidad inválida para retirar.\n";
        }
    }

    // Método para mostrar la información de la cuenta
    public function mostrarInfo() {
        echo "Titular: {$this->titular}\n";
        echo "Tipo de cuenta: {$this->tipoDeCuenta}\n";
        echo "Saldo actual: \${$this->saldo}\n";
    }
}

// Crear una instancia de la clase CuentaBancaria
$cuenta = new CuentaBancaria("Carlos Pérez", 500, "Ahorro");

// Realizar operaciones
$cuenta->depositar(200);
$cuenta->retirar(150);
$cuenta->retirar(600);  

// Mostrar la información final de la cuenta
$cuenta->mostrarInfo();

?>
