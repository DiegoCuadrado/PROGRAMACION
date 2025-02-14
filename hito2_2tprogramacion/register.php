<?php
session_start();
require 'config/database.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Recibir los datos del formulario
    $username = trim($_POST["username"]);
    $email = trim($_POST["email"]);
    $password = $_POST["password"];

    // Validar si el correo electrónico ya está registrado
    $stmt = $conn->prepare("SELECT * FROM users WHERE email = ?");
    $stmt->execute([$email]);
    $user = $stmt->fetch();

    if ($user) {
        // Si ya existe un usuario con ese correo
        echo "<div class='alert'>El correo electrónico ya está registrado.</div>";
    } else {
        // Si no existe, proceder con el registro
        $hashed_password = password_hash($password, PASSWORD_BCRYPT);

        // Insertar en la base de datos
        $stmt = $conn->prepare("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");
        $stmt->execute([$username, $email, $hashed_password]);

        // Redirigir al inicio de sesión
        echo "<div class='alert-success'>¡Registro exitoso! Puedes <a href='login.php'>iniciar sesión</a></div>";
    }
}

include 'views/header.php';
?>

<div class="container">
    <h2 class="text-center">Registro de Usuario</h2>
    <form method="POST" action="register.php">
        <input type="text" name="username" placeholder="Usuario" required>
        <input type="email" name="email" placeholder="Correo Electrónico" required>
        <input type="password" name="password" placeholder="Contraseña" required>
        <button type="submit">Registrarse</button>
    </form>
</div>

<?php include 'views/footer.php'; ?>



