//Función que muestra el menu
const mobileCloseHeader = document.querySelector(".mobile-close-header");
const header = document.querySelector("header");

mobileCloseHeader.addEventListener("click", () => {
    header.classList.toggle("active");
});

//Función de icono X
function myFunction(x) {
    x.classList.toggle("change");
}