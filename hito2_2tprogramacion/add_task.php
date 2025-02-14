<?php
session_start();
require 'config/database.php';

if (!isset($_SESSION["user_id"])) {
    header("Location: login.php");
    exit();
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $description = trim($_POST["description"]);

    $stmt = $conn->prepare("INSERT INTO tasks (user_id, description) VALUES (?, ?)");
    $stmt->execute([$_SESSION["user_id"], $description]);
    
    header("Location: dashboard.php");
}
?>

