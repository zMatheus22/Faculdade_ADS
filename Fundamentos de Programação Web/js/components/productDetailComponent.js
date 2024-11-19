document.addEventListener("DOMContentLoaded", function () {
  const urlParams = new URLSearchParams(window.location.search);
  const productId = urlParams.get("id");

  if (productId) {
    // Simula uma requisição de dados para o produto com o ID
    const product = getProductById(productId);

    if (product) {
      document.querySelector(".product-detail h2").textContent = product.name;
      document.querySelector(".product-detail p").textContent =
        product.description;
      document.querySelector(
        ".product-detail .price"
      ).textContent = `R$ ${product.price}`;
      document.querySelector(".product-detail img").src = `${product.image}`;
    }
  }

  function getProductById(id) {
    // Exemplo de retorno simulado. Idealmente isso seria feito com uma requisição AJAX.
    const products = [
      {
        id: 1,
        name: "Laptop para Estudantes",
        description: "Laptop ideal para estudantes...",
        price: 3500,
        image: "https://www.asus.com/media/Odin/Websites/global/Series/24.png",
      },
      {
        id: 2,
        name: "Tablet Educacional",
        description: "Tablet compacto e eficiente...",
        price: 1800,
        image: "https://m.media-amazon.com/images/I/61eecV0KUcL.jpg",
      },
    ];

    return products.find((product) => product.id === parseInt(id));
  }
});
