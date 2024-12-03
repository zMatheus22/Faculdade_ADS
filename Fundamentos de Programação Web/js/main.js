document.addEventListener("DOMContentLoaded", function () {
  createHeader();

  if (document.getElementById("product-list")) {
    createProductList();
  }
});
