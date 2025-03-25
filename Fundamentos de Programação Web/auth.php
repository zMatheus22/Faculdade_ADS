<?php
session_start();

// Lida com o processo de login de um usuário.
if (!isset($_SESSION['usuario'])) {
  header('Location: ./index.html');
  exit();
}
?>