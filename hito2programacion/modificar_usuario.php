<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Usuario</title>
</head>
<body>
    <h2>Modificar Información de Usuario</h2>
    <form action="procesar_modificacion.php" method="POST">
        <label>ID del Usuario:</label>
        <input type="text" name="id" required><br>

        <label>Nuevo Plan Base:</label>
        <select name="plan_base">
            <option value="1">Básico</option>
            <option value="2">Estándar</option>
            <option value="3">Premium</option>
        </select><br>

        <button type="submit">Modificar</button>
    </form>
</body>
</html>
