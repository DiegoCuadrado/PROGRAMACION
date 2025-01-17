<?php
require_once 'funciones.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $id = $_POST['id'];
    $nombre = $_POST['nombre'];
    $correo = $_POST['correo'];
    $telefono = $_POST['telefono'];

    $clientes = leerClientes('clientes.csv');
    foreach ($clientes as &$cliente) {
        if ($cliente[0] == $id) {
            $cliente[1] = $nombre;
            $cliente[2] = $correo;
            $cliente[3] = $telefono;
            break;
        }
    }
    escribirClientes('clientes.csv', $clientes);
    echo "<h1>Cliente modificado con éxito</h1>";
    echo "<a href='index.php'>Volver al inicio</a>";
} else {
    $id = $_GET['id'] ?? '';
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Cliente</title>
</head>
<body>
    <h1>Modificar Cliente</h1>
    <form method="POST" action="modificar_cliente.php">
        <label for="id">ID del Cliente:</label>
        <input type="number" id="id" name="id" value="<?= $id ?>" required><br>
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br>
        <label for="correo">Correo:</label>
        <input type="email" id="correo" name="correo" required><br>
        <label for="telefono">Teléfono:</label>
        <input type="text" id="telefono" name="telefono" required><br>
        <button type="submit">Modificar</button>
    </form>
</body>
</html>
<?php } ?>
