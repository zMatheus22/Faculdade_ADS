<?php
// Conexão com o banco de dados MySQL
$host = 'db';
$user = 'user';
$pass = 'password';
$db = 'techestudo';

$conexao = mysqli_connect($host, $user, $pass, $db);

if (!$conexao) {
  die("Conexão falhou: " . mysqli_connect_error());
}
?>