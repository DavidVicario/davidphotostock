//Funcion para buscar en el menu los campos.
function menuSearch() {
    //Tomo el valor del ID "search-admin" y lo convierto a mayúsculas
    const input = document.getElementById("search-admin");
    const filter = input.value.toUpperCase();
    //Obtengo una lista de elementos <li> dentro del elemento con el ID "menu-admin"
    const ul = document.getElementById("menu-admin");
    let li = ul.getElementsByTagName("li");

    //Itero sobre cada elemento <li> en la lista obtenida
    for (let i = 0; i < li.length; i++) {
        //Para cada elemento, se obtiene el primer elemento <a> dentro de él
        const a = li[i].getElementsByTagName("a")[0];
        //Se verifica si el texto dentro del elemento <a> coincide con el filtro
        if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
            //Si hay coincidencia, se muestra el elemento <li> 
            //Establezco el estilo de visualización en vacío para que sea visible
            li[i].style.display = "";
        } else {
            //Si no, se oculta el elemento <li> estableciendo "none".
            li[i].style.display = "none";
        }
    }
}

//Función para mostrar una página específica en función del ID proporcionado.
function showPage(pageId) {
    //Obtengo todos los elementos con la clase "page-content"
    let pageContent = document.getElementsByClassName("page-content");
    //He itero con ellos.
    for (let i = 0; i < pageContent.length; i++) {
        //Los establezco como "none" para ocultar todas las páginas.
        pageContent[i].style.display = "none";
    }
    //Muestro la página correspondiente al ID proporcionado con "block".
    document.getElementById(pageId).style.display = "block";
}
//Agrego un evento de escucha al elemento con el ID "menu-admin"
document.getElementById("menu-admin").addEventListener("click", function (event) {
    //Cuando se hace clic en este elemento, el evento se activa y se verifica si 
    //el elemento clicado es un enlace <a>
    const target = event.target;    
    if (target.tagName.toLowerCase() === "a") {
        //Si es un enlace, se obtiene el elemento <li>
        const li = target.parentElement;
        //Y se recupera el ID de la página asociada.
        const pageId = li.getAttribute("data-page");
        //Llamo a la función showPage() con el ID para mostrar esa página.
        showPage(pageId);
    }
});

// Función para cerrar sesión
window.logout = function() {
    fetch('/UsersAdminServlet?action=logout', { method: 'POST' })
        .then(response => {
            if (response.status === 200) {
                
                var loginLink = document.getElementById('login-link');
                var signupLink = document.getElementById('signup-link');
                
                loginLink.textContent = 'LOGIN';
                signupLink.textContent = 'SIGN UP';
                
                //Recargo la pagina para que se actulizen los datos.
                window.location.href = "index.jsp";
            } else {
                console.log('Error logging out');
            }
        })
        .catch((error) => {
            console.error('Error:', error);
        });
};