<?php
session_start();
include('conexao.php');

// Lida com o processo de login de um usuário.
// $_POST Os dados POST contendo o email e a senha do usuário.
// $_SESSION Os dados da sessão para armazenar o email do usuário após o login bem-sucedido.
// $conexao O objeto de conexão MySQLi para interagir com o banco de dados.

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
  $email = $_POST['email'];
  $senha = md5($_POST['senha']);

  $query = "SELECT * FROM usuarios WHERE email = '$email' AND senha = '$senha'";
  $result = mysqli_query($conexao, $query);

  if (mysqli_num_rows($result) == 1) {
    $usuario = mysqli_fetch_assoc($result);
    $_SESSION['usuario'] = $usuario['email'];
    $_SESSION['cargo'] = $usuario['cargo'];
    header('Location: home.html');
  } else {
    echo "Usuário ou senha inválidos.";
  }
}
?>