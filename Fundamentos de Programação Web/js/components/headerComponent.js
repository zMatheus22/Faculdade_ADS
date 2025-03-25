document.addEventListener("DOMContentLoaded", () => {
  const header = document.querySelector("header");
  header.innerHTML = `
      <nav>
          <a href="home.html">Home</a>
          <a href="produtos.html">Produtos</a>
          <a href="index.html">Login</a>
      </nav>
  `;
});
