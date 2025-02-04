<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Usuarios</title>
</head>
<body>
    <h2>Usuarios Registrados</h2>
    <?php
    require 'config/db.php';

    $stmt = $pdo->query('SELECT usuarios.id, usuarios.nombre, usuarios.apellidos, usuarios.correo, planes.nombre_plan, planes.precio_mensual, usuarios.duracion_suscripcion FROM usuarios JOIN planes ON usuarios.plan_base_id = planes.id');
    echo '<table border="1"><tr><th>ID</th><th>Nombre</th><th>Apellidos</th><th>Correo</th><th>Plan Base</th><th>Precio Mensual</th><th>Paquetes Adicionales</th><th>Coste Total</th></tr>';

    while ($row = $stmt->fetch()) {
        $usuario_id = $row['id'];
        $paquetesStmt = $pdo->prepare('SELECT paquetes.nombre_paquete, paquetes.precio_mensual FROM usuario_paquetes JOIN paquetes ON usuario_paquetes.paquete_id = paquetes.id WHERE usuario_paquetes.usuario_id = ?');
        $paquetesStmt->execute([$usuario_id]);

        $paquetesInfo = "";
        $paqueteCosto = 0.00;

        while ($paqueteRow = $paquetesStmt->fetch()) {
            $paquetesInfo .= $paqueteRow['nombre_paquete'] . ' (' . $paqueteRow['precio_mensual'] . ' €), ';
            $paqueteCosto += $paqueteRow['precio_mensual'];
        }

        $paquetesInfo = rtrim($paquetesInfo, ', ');

        // Cálculo del costo total mensual
        $costoBase = $row['precio_mensual'];
        $costoTotal = $costoBase + $paqueteCosto;

        // Mostrar resultados en la tabla
        echo '<tr><td>' . $row['id'] . '</td><td>' . $row['nombre'] . '</td><td>' . $row['apellidos'] . '</td><td>' . $row['correo'] . '</td><td>' . $row['nombre_plan'] . '</td><td>' . $costoBase . ' €</td><td>' . $paquetesInfo . '</td><td>' . $costoTotal . ' €</td></tr>';
    }
    echo '</table>';
    ?>
</body>
</html>