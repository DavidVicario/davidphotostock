//Función que muestra el menu
//Selecciono el elemento con la clase "mobile-close-header"
//Boton que activa la funcion para mostrar y ocultar el menú.
const mobileCloseHeader = document.querySelector(".mobile-close-header");
//Selecciono el elemento header
//Contenedor del header donde se encuentra el menú
const header = document.querySelector("header");

//Agrego un evento de escucha de clic al elemento mobileCloseHeader
mobileCloseHeader.addEventListener("click", () => {
    //Alterna la clase "active" en el elemento header, lo que muestra u oculta el menú
    header.classList.toggle("active");
});

//Función de icono de menu
//Para animacion que cambia al desplegar el menu.
function animateX(x) {
    //Alterna la clase "change" en el elemento x, que representa el ícono
    x.classList.toggle("change");
}

//Función que muestra el carrito
// Selecciona el elemento de la tienda
let shop = document.querySelector('.shop');
let cart = document.querySelector('.contain-cart');

// Agrega un controlador de eventos para cuando el mouse entra en el elemento
shop.addEventListener('mouseenter', function () {
    cart.style.visibility = "visible";
});

shop.addEventListener('mouseleave', function () {
    cart.style.visibility = "hidden";
});