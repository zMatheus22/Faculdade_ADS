document.addEventListener("DOMContentLoaded", function () {
  const header = document.querySelector("header");
  header.innerHTML = `
      <h1>Loja de Eletrônicos para Estudantes</h1>
      <nav>
        <a href="index.html">Home</a>
        <a href="produtos.html">Produtos</a>
        <a href="sobre.html">Sobre</a>
        <a href="contato.html">Contato</a>
      </nav>
  `;
});
