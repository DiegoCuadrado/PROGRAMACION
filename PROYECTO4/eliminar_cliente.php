<?php
require_once 'funciones.php';

$archivo = "clientes.csv";
$id = $_POST["id"] ?? null;

if ($id !== null) {
    $clientes = leerClientes($archivo);
    $clientesActualizados = array_filter($clientes, function($cliente) use ($id) {
        return $cliente[0] != $id;
    });
    escribirClientes($archivo, $clientesActualizados);
    echo "<h1>Cliente eliminado con éxito</h1>";
    echo "<a href='listar_clientes.php'>Volver al listado</a>";
} else {
    echo "Error: No se recibió un ID válido.";
}
?>
