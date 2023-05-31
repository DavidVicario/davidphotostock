//Filtro del Portfolio

//Muestro todos los elementos iniciales sin filtrar en el portfolio.
filterSelection("all")

//Funcion para de filtrar los elementos del portfolio según la categoría
function filterSelection(c) {
    let x, i;
    //Obtengo todos los elementos con la clase "column-pf"
    x = document.getElementsByClassName("column-pf");
    //Si es "all", se asigna una cadena vacía a c y muestra todo
    if (c == "all") c = "";

    for (i = 0; i < x.length; i++) {
        //Se llama a hiddenClass() pasando el elemento actual y la clase "show-pf"
        //Ocultandolo
        hiddenClass(x[i], "show-pf");
        //Si la clase del elemento contiene la categoría c
        //Se llama a showClass() pasando el elemento actual y la clase "show-pf"
        //Mostrandolo
        if (x[i].className.indexOf(c) > -1) showClass(x[i], "show-pf");
    }
}

//Funcion para mostrar una clase específica en un elemento.
function showClass(element, name) {
    let arr1, arr2;
    //Divido la cadena de clases del elemento en un array utilizando un espacio
    arr1 = element.className.split(" ");
    //Divido la cadena de la clase a mostrar en un array utilizando un espacio
    arr2 = name.split(" ");
    //Itero arr2
    for (let i = 0; i < arr2.length; i++) {
        //Si la clase actual no se encuentra en arr1, se agrega a arr1
        if (arr1.indexOf(arr2[i]) == -1) {
            //Actualizo la clase del elemento concatenando las clases de arr1
            element.className += " " + arr2[i];
        }
    }
}

//Funcion para para ocultar una clase específica en un elemento
function hiddenClass(element, name) {
    let arr1, arr2;
    arr1 = element.className.split(" ");
    arr2 = name.split(" ");
    for (let  i = 0; i < arr2.length; i++) {
        //Mientras la clase actual se encuentre en arr1, se realiza un bucle para 
        //eliminar todas las instancias de esa clase.
        while (arr1.indexOf(arr2[i]) > -1) {
            arr1.splice(arr1.indexOf(arr2[i]), 1);
        }
    }
    //Actualizo la clase del elemento asignando las clases de arr1
    element.className = arr1.join(" ");
}

//Obtengo el id de botones del portfolio
const btnContainer = document.getElementById("container-btn-pf");
//Obtengo todos los elementos con la clase "btn-pf" dentro del btnContainer
const btns = btnContainer.getElementsByClassName("btn-pf");
//itero sobre todos los botones
for (let i = 0; i < btns.length; i++) {
    //Agrego un evento de escucha de clic al botón actual.
    btns[i].addEventListener("click", function(){
        //Obtengo todos los elementos con la clase "active-pf" representando
        //los botones activos
        const current = document.getElementsByClassName("active-pf");
        //Se reemplaza la clase "active-pf" del botón activo actual eliminándolo
        current[0].className = current[0].className.replace(" active-pf", "");
        //Se agrega la clase "active-pf" al botón actual
        this.className += " active-pf";
    });
}

//Dropdown de categorias

//Funcion para mostrar u ocultar el menú desplegable
function showDrop(id) {
    //Obtengo el elemento con el ID y se alterna la clase "show-dr" 
    //en ese elemento, para mostrar u ocultar el menú desplegable
    document.getElementById(id).classList.toggle("show-dr");
}

//Agrego un evento de escucha de clic
document.addEventListener('click', function(event) {
    //Obtengo todos los elementos con la clase "btn-drop" 
    const dropdownButtons = document.querySelectorAll('.btn-drop');
    //Obtengo todos los elementos con la clase "content-dropdown"
    const dropdownContents = document.querySelectorAll('.content-dropdown');
    //Se realizan comprobaciones para determinar si se hizo clic dentro o fuera 
    //de los botones y contenidos del menú desplegable
    const clickedInsideButton = Array.from(dropdownButtons).some(button => button === event.target || button.contains(event.target));
    const clickedInsideContent = Array.from(dropdownContents).some(content => content === event.target || content.contains(event.target));
    //Si el clic no se realizó dentro de los botones ni dentro de los contenidos    
    if (!clickedInsideButton && !clickedInsideContent) {
        //Se recorre un bucle forEach en los contenidos del menú desplegable para 
        //eliminar la clase "show-dr", lo que oculta los menús desplegables abiertos.
        Array.from(dropdownContents).forEach(content => content.classList.remove('show-dr'));
    }
});

window.onload = function() {
  window.location.href = "/ProductServlet?action=allProduct";
}

// Dropdown Cascada -- En proceso...
/*
    https://www.w3schools.com/howto/howto_css_modal_images.asp
 * 
    https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_cascading_dropdown
const subjectObject = {
    "Front-end": {
        "Author": ["Author", "Abstract"],
        "Macro": ["Insect", "Flora"],
        "Nature": ["Fauna", "Flora", "Landscape"],
        "Travel": ["Culture", "People", "Landscape", "Architecture"],
        "Social": ["Portrait", "People", "Street"],
        "Commercial": ["Product", "Foot"]
    }
};

window.onload = function () {
    const categoryDiv = document.getElementById("cdd");
    for (const category in subjectObject) {
        const a = document.createElement("a");
        a.className = "btn-pf";
        a.onclick = function (category) {
            return function () {
                filterSelection(category.toLowerCase());
                showDrop("cdd");
                populateSubcategory(category);
            };
        }(category);
    a.textContent = category;
    categoryDiv.appendChild(a);
    }
};

function populateSubcategory(category) {
    const subcategoryDiv = document.getElementById("sdd");
    subcategoryDiv.innerHTML = "";
    const subcategories = subjectObject[category];
    for (let i = 0; i < subcategories.length; i++) {
        const a = document.createElement("a");
        a.className = "btn-pf";
        a.onclick = function (subcategory) {
            return function () {
                filterSelection(subcategory.toLowerCase());
                showDrop("sdd");
            };
        }(subcategories[i]);
    a.textContent = subcategories[i];
    subcategoryDiv.appendChild(a);
    }
}
*/