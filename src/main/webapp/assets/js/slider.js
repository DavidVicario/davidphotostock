//Slider

//Declaramos slideIndex y lo iniciamos
let slideIndex = 1;
//Llamo a la funcion y le paso la variable anterior para mostrar la img inicial.
showSlides(slideIndex);

//Función para avanzar o retroceder en el slider.
//n que indica el número de img a avanzar o retroceder
function plusSlides(n) {
    //Cambia el valor de slideIndex al según el valor de n
    showSlides(slideIndex += n);
}

//Función para mostrar una img específica
function currentSlide(n) {
    //Cambia el valor de slideIndex al valor de n
    showSlides(slideIndex = n);
}

//Función para mostrar las diapositivas en función de n
function showSlides(n) {
    //Obtengo todos los elementos con la clase "wrapper-slider". Las img
    let slides = document.getElementsByClassName("wrapper-slider");
    //Si llega al final del slider y se mostrará la primera img
    if (n > slides.length) {slideIndex = 1}   
    //Si se retrocede desde la primera img, se mostrará la última img
    if (n < 1) {slideIndex = slides.length}
    //Itera sobre cada  slides y establezco "none" para ocultarlos
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";  
    }
    //Muestro la img actual con "block" y 
    //la img actual se determina con slideIndex-1 como índice en el array slides
    slides[slideIndex-1].style.display = "block";
}