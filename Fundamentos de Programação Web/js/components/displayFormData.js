document.addEventListener("DOMContentLoaded", function () {
  const formDataDisplay = document.getElementById("formDataDisplay");

  // Captura os parâmetros da URL (dados enviados via GET)
  const urlParams = new URLSearchParams(window.location.search);

  const name = urlParams.get("name");
  const email = urlParams.get("email");
  const message = urlParams.get("message");

  // Exibe os dados capturados
  if (name && email && message) {
    formDataDisplay.innerHTML = `
            <p><strong>Nome:</strong> ${name}</p>
            <p><strong>E-mail:</strong> ${email}</p>
            <p><strong>Mensagem:</strong> ${message}</p>
        `;
  } else {
    formDataDisplay.innerHTML =
      "<p>Não foram recebidos dados do formulário.</p>";
  }
});
