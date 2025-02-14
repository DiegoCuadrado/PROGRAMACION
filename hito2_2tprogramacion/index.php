<?php
session_start();
if (isset($_SESSION["user_id"])) {
    header("Location: dashboard.php");
    exit();
}

include 'views/header.php';
?>

<div class="container text-center mt-5">
    <h2 class="mb-3">Bienvenido al Gestor de Tareas</h2>
    <p class="lead">Administra tus tareas de manera sencilla y eficiente.</p>
    <a href="login.php" class="btn btn-primary me-2">Iniciar Sesión</a>
    <a href="register.php" class="btn btn-success">Registrarse</a>
</div>

<?php include 'views/footer.php'; ?>




