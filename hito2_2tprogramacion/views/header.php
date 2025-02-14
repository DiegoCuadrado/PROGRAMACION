<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestor de Tareas</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <header>
        <h1>Gestor de Tareas</h1>
        <nav>
            <?php if (isset($_SESSION["user_id"])): ?>
                <a href="dashboard.php">Mis Tareas</a>
                <a href="logout.php">Cerrar Sesión</a>
            <?php else: ?>
                <a href="index.php">Inicio</a>
                <a href="login.php">Iniciar Sesión</a>
                <a href="register.php">Registrarse</a>
            <?php endif; ?>
        </nav>
    </header>



