<?php
require_once 'funciones.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nombre = $_POST['nombre'];
    $correo = $_POST['correo'];
    $telefono = $_POST['telefono'];

    $clientes = leerClientes('clientes.csv');
    $nuevoID = end($clientes)[0] + 1;
    $clientes[] = [$nuevoID, $nombre, $correo, $telefono];
    
    escribirClientes('clientes.csv', $clientes);
    echo "<h1>Cliente añadido con éxito</h1>";
    echo "<a href='index.php'>Volver al inicio</a>";
} else {
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Añadir Cliente</title>
</head>
<body>
    <h1>Añadir Cliente</h1>
    <form method="POST" action="añadir_cliente.php">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br>
        <label for="correo">Correo:</label>
        <input type="email" id="correo" name="correo" required><br>
        <label for="telefono">Teléfono:</label>
        <input type="text" id="telefono" name="telefono" required><br>
        <button type="submit">Añadir</button>
    </form>
</body>
</html>
<?php } ?>
