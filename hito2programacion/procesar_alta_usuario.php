<?php
require 'config/db.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nombre = $_POST['nombre'];
    $apellidos = $_POST['apellidos'];
    $correo = $_POST['correo'];
    $edad = $_POST['edad'];
    $plan_base_id = $_POST['plan_base'];
    $duracion_suscripcion = $_POST['duracion_suscripcion'];

    try {
        // Validación de correo único
        $checkEmailStmt = $pdo->prepare("SELECT id FROM usuarios WHERE correo = ?");
        $checkEmailStmt->execute([$correo]);
        if ($checkEmailStmt->fetch()) {
            die("Error: El correo ya está registrado.");
        }

        $stmt = $pdo->prepare("INSERT INTO usuarios (nombre, apellidos, correo, edad, plan_base_id, duracion_suscripcion) VALUES (?, ?, ?, ?, ?, ?)");
        $stmt->execute([$nombre, $apellidos, $correo, $edad, $plan_base_id, $duracion_suscripcion]);
        echo "Usuario registrado exitosamente.";
    } catch (PDOException $e) {
        echo "Error al registrar usuario: " . $e->getMessage();
    }
}
?>