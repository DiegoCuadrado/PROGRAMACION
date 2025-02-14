<?php
session_start();
require 'config/database.php';

if (!isset($_SESSION["user_id"])) {
    header("Location: login.php");
    exit();
}

$id = $_GET["id"];
$stmt = $conn->prepare("UPDATE tasks SET status = 'completed' WHERE id = ?");
$stmt->execute([$id]);

header("Location: dashboard.php");
?>

