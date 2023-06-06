//Función para abrir formularios
/*
 Usamos el valor enviado para cambiar el estilo de las ventanas a Block 
 y que sean visibles en pantalla.
 */
function openForm(formName) {
    if (formName == 'user') {
        document.getElementById('add-user').style.display = 'block';
    } else if (formName == 'category') {
        document.getElementById('add-category').style.display = 'block';
    } else if (formName == 'subcategory') {
        document.getElementById('add-subcategory').style.display = 'block';
    } else if (formName == 'product') {
        document.getElementById('add-product').style.display = 'block';
    } else if (formName == 'shipment') {
        document.getElementById('add-shipment').style.display = 'block';
    } else if (formName == 'shipmentproduct') {
        document.getElementById('add-shipmentproduct').style.display = 'block';
    }
}

//Cierre de formulario al hacer click fuera de él
const user = document.getElementById('add-user');
const category = document.getElementById('add-category');
const subcategory = document.getElementById('add-subcategory');
const product = document.getElementById('add-product');
const shipment = document.getElementById('add-shipment');
const shipmentproduct = document.getElementById('add-shipmentproduct');

window.onclick = function (event) {
    if (event.target == user) {
        user.style.display = "none";
    }
    if (event.target == category) {
        category.style.display = "none";
    }
    if (event.target == subcategory) {
        subcategory.style.display = "none";
    }
    if (event.target == product) {
        product.style.display = "none";
    }
    if (event.target == shipment) {
        shipment.style.display = "none";
    }
    if (event.target == shipmentproduct) {
        shipmentproduct.style.display = "none";
    }
}

//Función para cerrar formularios
/*
 Usamos el valor enviado para cambiar el estilo de las ventanas a None 
 y que sean invisibles en pantalla.
 */
function closeForm(formName) {
    if (formName == 'user') {
        document.getElementById('add-user').style.display = 'none';
    } else if (formName == 'category') {
        document.getElementById('add-category').style.display = 'none';
    } else if (formName == 'subcategory') {
        document.getElementById('add-subcategory').style.display = 'none';
    } else if (formName == 'product') {
        document.getElementById('add-product').style.display = 'none';
    } else if (formName == 'shipment') {
        document.getElementById('add-shipment').style.display = 'none';
    } else if (formName == 'shipmentproduct') {
        document.getElementById('add-shipmentproduct').style.display = 'none';
    }
}