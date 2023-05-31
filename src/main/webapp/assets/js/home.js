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
    if (n > slides.length) {
        slideIndex = 1
    }
    //Si se retrocede desde la primera img, se mostrará la última img
    if (n < 1) {
        slideIndex = slides.length
    }
    //Itera sobre cada  slides y establezco "none" para ocultarlos
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    //Muestro la img actual con "block" y 
    //la img actual se determina con slideIndex-1 como índice en el array slides
    slides[slideIndex - 1].style.display = "block";
}

//Añade las animaciones.
document.addEventListener("DOMContentLoaded", function () {
    let observer = new IntersectionObserver(entries => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                if (entry.target.querySelector('.ani-middle-img')) {
                    entry.target.querySelector('.ani-middle-img').classList.add('ani-middle-img-start');
                }
                if (entry.target.querySelector('.ani-middle-txt')) {
                    entry.target.querySelector('.ani-middle-txt').classList.add('ani-middle-txt-start');
                }
                if (entry.target.querySelector('.instagram-flip')) {
                    entry.target.classList.add('instagram-flip-animation');
                }

                observer.unobserve(entry.target);
            }
        });
    });

    document.querySelectorAll('.observe').forEach(element => {
        observer.observe(element);
    });
});

//Boton de TOP

let btnTop = document.getElementById("btn-top");

window.onscroll = function () {
    scrollFunction()
    indicator()
};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        btnTop.style.display = "block";
    } else {
        btnTop.style.display = "none";
    }
}

btnTop.addEventListener('click', goTop);

function goTop() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}

//Medidor de Scroll
const circle = document.querySelector('.progress-ring-circle');
const radius = circle.r.baseVal.value;
const circumference = radius * 2 * Math.PI;

circle.style.strokeDasharray = `${circumference} ${circumference}`;
circle.style.strokeDashoffset = `${circumference}`;

function setProgress(percent) {
    const offset = circumference - percent / 100 * circumference;
    circle.style.strokeDashoffset = offset;
}

function indicator() {
    const winScroll = document.body.scrollTop || document.documentElement.scrollTop;
    const height = document.documentElement.scrollHeight - document.documentElement.clientHeight;
    const scrolled = (winScroll / height) * 100;
    setProgress(scrolled);
}

window.addEventListener('scroll', indicator);