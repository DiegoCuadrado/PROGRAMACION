<?php
session_start();
require 'config/database.php';

if (!isset($_SESSION["user_id"])) {
    header("Location: login.php");
    exit();
}

$stmt = $conn->prepare("SELECT * FROM tasks WHERE user_id = ?");
$stmt->execute([$_SESSION["user_id"]]);
$tasks = $stmt->fetchAll(PDO::FETCH_ASSOC);

include 'views/header.php';
?>

<div class="container">
    <h2 class="text-center">Bienvenido, <?php echo $_SESSION["username"]; ?></h2>

    <form method="POST" action="add_task.php">
        <input type="text" name="description" placeholder="Nueva tarea" required>
        <button type="submit">Agregar</button>
    </form>

    <h3 class="text-center">Mis Tareas</h3>
    <ul>
        <?php foreach ($tasks as $task): ?>
            <li>
                <span><?php echo htmlspecialchars($task['description']); ?></span>
                <div>
                    <a href="mark_done.php?id=<?php echo $task['id']; ?>" class="btn-completed">✔</a>
                    <a href="delete_task.php?id=<?php echo $task['id']; ?>" class="btn-delete">❌</a>
                </div>
            </li>
        <?php endforeach; ?>
    </ul>
</div>

<?php include 'views/footer.php'; ?>



