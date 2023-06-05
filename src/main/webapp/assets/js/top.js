//Boton de TOP + Indicador de pagina

//Obtenemos el id del btn-top
let btnTop = document.getElementById("btn-top");

//Defino una funcion para cada vez que se hace scroll.
window.onscroll = function () {
    scrollFunction();
    indicator();
};

//Funcion que muestra el boton de TOP dependiendo de unos 20px de la zona superior.
//si es inferior a esos 20px desaparecera. 
function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        btnTop.style.display = "block";
    } else {
        btnTop.style.display = "none";
    }
}

//Le agrego un evento de escucha en caso de hacerle click.
btnTop.addEventListener('click', goTop);

//Funcion que hace que el scroll de ponga a 0px de la parte superior.
function goTop() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}

//Medidor de Scroll
//Seleccionamos el circulo de nuestro boton SVG
const circle = document.querySelector('.progress-ring-circle');
//Obtenemos su radio.
const radius = circle.r.baseVal.value;
//Calculamos el perimetro del circulo.
const circumference = radius * 2 * Math.PI;

//Animamos el trazo para que parezca que se dibuja gradualmente. 
circle.style.strokeDasharray = `${circumference} ${circumference}`;
circle.style.strokeDashoffset = `${circumference}`;

//Funcion que coge un porcentaje y lo ajusta al strokeDashoffset para dibujarlo.
function setProgress(percent) {
    const offset = circumference - percent / 100 * circumference;
    circle.style.strokeDashoffset = offset;
}

//Funcion que llamamos cuando hacemos scroll
function indicator() {
    const winScroll = document.body.scrollTop || document.documentElement.scrollTop;
    const height = document.documentElement.scrollHeight - document.documentElement.clientHeight;
    //Calculamos el porcentaje de pagina que se ha desplazado
    const scrolled = (winScroll / height) * 100;
    //Pasamos ese porcentaje a setProgress
    setProgress(scrolled);
}

//Agregamos un evento escucha para saber cada vez que se hace scroll.
window.addEventListener('scroll', indicator);