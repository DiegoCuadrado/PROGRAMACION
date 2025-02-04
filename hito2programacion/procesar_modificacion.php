<?php
require 'config/db.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $id = $_POST['id'];
    $plan_base_id = $_POST['plan_base'];

    try {
        $stmt = $pdo->prepare("UPDATE usuarios SET plan_base_id = ? WHERE id = ?");
        $stmt->execute([$plan_base_id, $id]);
        echo "Usuario modificado exitosamente.";
    } catch (PDOException $e) {
        echo "Error al modificar usuario: " . $e->getMessage();
    }
}
?>
