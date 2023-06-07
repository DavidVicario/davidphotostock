//Impido el click derecho en todo el proyecto.
//Con esta funcion se bloquea el uso del click derecho en toda la pagina. 
document.oncontextmenu = function () {
    return false;
}

//Función para abrir formularios
/*
 Usamos el valor enviado para cambiar el estilo de las ventanas a Block 
 y que sean visibles en pantalla.
 */
function openForm(formName) {
    if (formName == 'login') {
        document.getElementById('section-login').style.display = 'block';
    } else if (formName == 'signup') {
        document.getElementById('section-signup').style.display = 'block';
    } else if (formName == 'forgot') {
        document.getElementById('section-forgot').style.display = 'block';
    } else if (formName == 'message') {
        document.getElementById('section-message').style.display = 'block';
    }
}

//Función para cerrar formularios
/*
 Usamos el valor enviado para cambiar el estilo de las ventanas a None 
 y que sean invisibles en pantalla.
 */
function closeForm(formName) {
    if (formName == 'login') {
        document.getElementById('section-login').style.display = 'none';
    } else if (formName == 'signup') {
        document.getElementById('section-signup').style.display = 'none';
    } else if (formName == 'forgot') {
        document.getElementById('section-forgot').style.display = 'none';
    } else if (formName == 'message') {
        document.getElementById('section-message').style.display = 'none';
    }
}

//Cierre de formulario al hacer click fuera de él
const login = document.getElementById('section-login');
const signup = document.getElementById('section-signup');
const forgot = document.getElementById('section-forgot');
const message = document.getElementById('section-message');

window.onclick = function (event) {
    if (event.target == login) {
        login.style.display = "none";
    }
    if (event.target == signup) {
        signup.style.display = "none";
    }
    if (event.target == forgot) {
        forgot.style.display = "none";
    }
    if (event.target == message) {
        signup.style.display = "none";
    }
}

//Funcion para ajustar el header al cargar la página
window.onload = function () {
    const loginLink = document.getElementById('login-link');
    const signupLink = document.getElementById('signup-link');
    const userLink = document.getElementById('user-link');
    const logoutLink = document.getElementById('logout-link');

    //Mandamos la solicitud al servidor. 
    fetch('/UsersServlet?action=checkLogin')
            //Iniciamos la promesa.
            .then(response => response.text())
            .then(username => {
                //Si se cumple, hacemos cambio en el header de Login por User
                //y signup`por logout en funcion se detecta username.
                console.log(username);
                if (username !== '') {
                    userLink.style.display = 'block';
                    logoutLink.style.display = 'block';
                    loginLink.style.display = 'none';
                    signupLink.style.display = 'none';
                    userLink.textContent = username;
                } else {
                    loginLink.style.display = 'block';
                    signupLink.style.display = 'block';
                    userLink.style.display = 'none';
                    logoutLink.style.display = 'none';
                }
            })
            //Promesa por si la operacion es rechazada.
            .catch((error) => {
                console.error('Error:', error);
            });

    //Recordar usuario
    //Buscamos la cookie con el nombre de usuario para auto escribirla.
    const username = getCookie("username");
    if (username) {
        document.getElementById("user-l").value = username;
    }
};

//Función para cerrar sesión
window.logout = function () {
    //Mandamos la solicitud al servidor. 
    fetch('/UsersServlet?action=logout', {method: 'POST'})
            //Iniciamos la promesa. 
            .then(response => {
                //La solicitus es exitosa en 200, asi que lo igualamos. 
                if (response.status === 200) {

                    //Volvemos a dejar el Header de forma "No usuario".
                    const loginLink = document.getElementById('login-link');
                    const signupLink = document.getElementById('signup-link');

                    loginLink.textContent = 'LOGIN';
                    signupLink.textContent = 'SIGN UP';

                    //Recargo la pagina para que se actulizen los datos.
                    window.location.reload();
                } else {
                    console.log('Error logging out');
                }
            })
            //Promesa por si la operacion es rechazada.
            .catch((error) => {
                console.error('Error:', error);
            });
};

//Confirmar password y usuario.
/*
 Funcion para comprobar si se cumplen los requisitos minimos para una pass
 (?=.*\d): Debe contener al menos un dígito.
 (?=.*[a-z]): Debe contener al menos una letra minúscula.
 (?=.*[A-Z]): Debe contener al menos una letra mayúscula.
 .{6,}: Debe tener al menos seis caracteres de longitud.
 */
function checkPassword(val) {
    const regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
    if (regex.test(val)) {
        return true;
    } else {
        return false;
    }
}

const validate = document.querySelector('.content-signup');
//Funcion para checkear el user y pass validos.
validate.onsubmit = function () {
    //Impedimos que se guarde la tabulacion
    if (validate.user.value == "") {
        alert("Debe escribir un nombre de usuario");
        validate.user.focus();
        return false;
    }
    /*
    Guardamos en una variable los requisilos del username
    \w: Solo debe contener letras, números y underscores.
    {4,10}: Debe tener una longitud entre 4 y 10 caracteres.
    */
    let re = /^\w{4,10}$/;
    if (!re.test(validate.user.value)) {
        alert("Nombre de usuario solo debe contener letras, números y underscores. Longitud entre 4 - 10.");
        validate.user.focus();
        return false;
    }
    //Comprobamos que no han tabulado y que las dos contraseñas son iguales.
    if (validate.pass.value != "" && validate.pass.value == validate.cpass.value) {
        //Llamamos a nuetsra funcion para comprobar la contraseña.
        if (!checkPassword(validate.pass.value)) {
            alert("La contraseña al menos debe de tener una letra, un número y una mayuscula. Mínimo 6 caracteres.");
            validate.pass.focus();
            return false;
        }
    } else {
        alert("Las contraseñas deben de ser iguales.");
        validate.pass.focus();
        return false;
    }
    return true;
}

const validateForgot = document.querySelector('.content-forgot');
validateForgot.onsubmit = function () {
    //Impedimos que se guarde la tabulacion
    if (validateForgot.user.value == "") {
        alert("Debe escribir su nombre de usuario");
        validateForgot.user.focus();
        return false;
    }
    //Comprobamos que no han tabulado y que las dos contraseñas son iguales.
    if (validateForgot.pass.value != "" && validateForgot.pass.value == validateForgot.cpass.value) {
        //Llamamos a nuetsra funcion para comprobar la contraseña.
        if (!checkPassword(validateForgot.pass.value)) {
            alert("La contraseña al menos debe de tener una letra, un número y una mayuscula. Mínimo 6 caracteres.");
            validateForgot.pass.focus();
            return false;
        }
    } else {
        alert("Las contraseñas deben de ser iguales.");
        validateForgot.pass.focus();
        return false;
    }
    return true;
}

//Funcion para recuperar el username de la Cookie
function getCookie(cname) {
    //Almacenamos el nombre de la cookie mas su valor. 
    const name = cname + "=";
    //Decodificamos todas las cookies y las almacenamos.
    const decodedCookie = decodeURIComponent(document.cookie);
    //Las dividimos en un array de cookies individuales.
    let ca = decodedCookie.split(';');
    //Recorremos todas las cookies
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i];
        //Eliminamos los espacios en blanco. 
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        //Si el inicio de la cookie coincide con el nombre de la cookie que 
        //estamos buscando, entonces se retorna el valor de la cookie
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    //Si no la encuentra devolvemos una cadena vacia. 
    return "";
}

//Control de Stock en carrito. 
//Seleccionamos los input tipo number y recorremos cada elemento. 
document.querySelectorAll('input[type="number"]').forEach(input => {
    //Ponemos un evento de escucha para que active cada vez que se haga un cambio.
    input.addEventListener('change', event => {
        //Guardamos el valor maximo del Stock de la bbdd
        const max = parseInt(input.getAttribute('max'));
        //Si el valor añadido es superior al maximo de la BBDD, lo cambiamos al maximo.
        if (input.value > max) {
            input.value = max;
        }
    });
});



//FORGOT
/*
document.querySelector("[name='verify']").addEventListener("click", function(event){
    event.preventDefault();
    document.querySelector(".pass-forgot").style.display = "block";
});*/

document.querySelector("[name='verify']").addEventListener("click", function(event){
    event.preventDefault();
    var username = document.getElementById("user-forgot").value;
    
    fetch('/UsersServlet?action=forgotPass', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: `user=${username}&username-verified=false`
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        if (data.usernameVerified === "true") {
            document.querySelector(".pass-forgot").style.display = "block";
        }
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});