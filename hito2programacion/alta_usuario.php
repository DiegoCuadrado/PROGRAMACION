<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alta de Usuario</title>
</head>
<body>
    <h2>Alta de Nuevo Usuario</h2>
    <form action="procesar_alta_usuario.php" method="POST">
        <label>Nombre:</label>
        <input type="text" name="nombre" required><br>

        <label>Apellidos:</label>
        <input type="text" name="apellidos" required><br>

        <label>Correo:</label>
        <input type="email" name="correo" required><br>

        <label>Edad:</label>
        <input type="number" name="edad" required><br>

        <label>Plan Base:</label>
        <select name="plan_base">
            <option value="1">Básico</option>
            <option value="2">Estándar</option>
            <option value="3">Premium</option>
        </select><br>

        <label>Duración de Suscripción:</label>
        <select name="duracion_suscripcion">
            <option value="Mensual">Mensual</option>
            <option value="Anual">Anual</option>
        </select><br>
        
        <button type="submit">Registrar Usuario</button>
    </form>
</body>
</html>