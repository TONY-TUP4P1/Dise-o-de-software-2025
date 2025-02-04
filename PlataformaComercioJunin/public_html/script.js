document.addEventListener("DOMContentLoaded", function() {
    const productosBtn = document.getElementById("productosBtn");
    const menuLateral = document.getElementById("menuLateral");
    const productosSection = document.getElementById("productos");

    productosBtn.addEventListener("click", function() {
        // Mostrar el menú lateral y la sección de productos
        menuLateral.classList.toggle("hidden");
        productosSection.classList.toggle("hidden");
    });
});
