document.addEventListener("DOMContentLoaded", function() {
    localStorage.setItem("progreso", "2"); // Guarda que el usuario está en el paso 2
    document.querySelectorAll(".progress-step")[1].classList.add("active"); // Activa el paso 2
});

// Redirigir a la página de cesta
function redirectToCart() {
    window.location.href = "cesta.html";
}

// Interacción con las estrellas de valoración
document.querySelectorAll(".star").forEach(star => {
    star.addEventListener("click", function() {
        let value = this.getAttribute("data-value");
        document.querySelectorAll(".star").forEach(s => s.classList.remove("selected"));
        for (let i = 0; i < value; i++) {
            document.querySelectorAll(".star")[i].classList.add("selected");
        }
    });
});

// Seleccionar método de pago
document.querySelectorAll(".payment-option").forEach(option => {
    option.addEventListener("click", function() {
        // Quitar selección de todos
        document.querySelectorAll(".payment-option").forEach(opt => opt.classList.remove("selected"));
        
        // Agregar selección a la opción clickeada
        this.classList.add("selected");

        // Marcar el radio button interno
        this.querySelector("input").checked = true;
    });
});

// Botón Confirmar Pago
document.getElementById("confirm-payment").addEventListener("click", function() {
    let selectedPayment = document.querySelector('input[name="payment"]:checked');
    
    if (selectedPayment) {
        alert("Pago confirmado con " + selectedPayment.value);
    } else {
        alert("Por favor, selecciona un método de pago.");
    }
});

document.addEventListener("DOMContentLoaded", function() {
    localStorage.setItem("progreso", "3"); // Guarda que el usuario está en el paso 3
    document.querySelectorAll(".progress-step")[2].classList.add("active"); // Activa el paso 3
});

document.addEventListener("DOMContentLoaded", function() {
    // Selecciona todas las celdas donde irá la lista desplegable
    let celdasUnidad = document.querySelectorAll(".unidad-medida");

    // Contenido del select
    let selectHTML = `
        <select>
            <option value="kg">Kg</option>
            <option value="litro">Litro</option>
            <option value="saco">Saco</option>
        </select>
    `;

    // Insertar el select en cada celda
    celdasUnidad.forEach(celda => {
        celda.innerHTML = selectHTML;
    });
});