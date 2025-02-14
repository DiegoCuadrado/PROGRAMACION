<?php
session_start();
require 'config/database.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $email = trim($_POST["email"]);
    $password = $_POST["password"];

    // Verificar si el usuario existe en la base de datos
    $stmt = $conn->prepare("SELECT * FROM users WHERE email = ?");
    $stmt->execute([$email]);
    $user = $stmt->fetch();

    if ($user && password_verify($password, $user['password'])) {
        // Si las credenciales son correctas
        $_SESSION["user_id"] = $user["id"];
        $_SESSION["username"] = $user["username"];
        header("Location: dashboard.php");
        exit();
    } else {
        // Si las credenciales son incorrectas
        echo "<div class='alert'>Credenciales incorrectas. Inténtalo de nuevo.</div>";
    }
}

include 'views/header.php';
?>

<div class="container">
    <h2 class="text-center">Iniciar Sesión</h2>
    <form method="POST" action="login.php">
        <input type="email" name="email" placeholder="Correo Electrónico" required>
        <input type="password" name="password" placeholder="Contraseña" required>
        <button type="submit">Iniciar Sesión</button>
    </form>
</div>

<?php include 'views/footer.php'; ?>


