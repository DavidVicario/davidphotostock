// Función para abrir formularios
function openForm(formName) {
    if (formName == 'login') {
        document.getElementById('section-login').style.display = 'block';
    } else if (formName == 'signup') {
        document.getElementById('section-signup').style.display = 'block';
    } 
}

// Función para cerrar formularios
function closeForm(formName) {
    if (formName == 'login') {
        document.getElementById('section-login').style.display = 'none';
    } else if (formName == 'signup') {
        document.getElementById('section-signup').style.display = 'none';
    } 
}

// Cierre de formulario al hacer click fuera de él
var login = document.getElementById('section-login');
var signup = document.getElementById('section-signup');

window.onclick = function(event) {
    if (event.target == login) {
        login.style.display = "none";
    }
    if (event.target == signup) {
        signup.style.display = "none";
    }
}

// Función para ajustar el header dependiendo si el usuario está logado o no
function adjustHeaderForLogin() {
    var loggedInUser = "<%= session.getAttribute('username') %>";
    var loginLink = document.querySelector('.users ul li a[onclick^="openLogin"]');
    var signupLink = document.querySelector('.users ul li a[onclick^="openSignUp"]');
    
    if (loggedInUser) {
        // Cambia "Login" por el nombre del usuario
        loginLink.textContent = loggedInUser;

        // Cambia "Sign Up" por "Cerrar sesión" y ajusta la función onclick
        signupLink.textContent = 'Cerrar sesión';
        signupLink.setAttribute('onclick', 'logout()');
    }
}

// Función para cerrar sesión
function logout() {
    fetch('/UsersServlet?action=logout', { method: 'POST' })
        .then(response => {
            if (response.status === 200) {
                // Una vez que la sesión se ha cerrado correctamente, cambiamos el nombre del usuario y la función onclick de nuevo
                var loginLink = document.querySelector('.users ul li a[onclick^="openLogin"]');
                var signupLink = document.querySelector('.users ul li a[onclick^="openSignUp"]');
                
                loginLink.textContent = 'LOGIN';
                loginLink.setAttribute('onclick', 'openForm("login")');
                signupLink.textContent = 'SIGN UP';
                signupLink.setAttribute('onclick', 'openForm("signup")');
            } else {
                console.log('Error al cerrar la sesión');
            }
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}

// Ajusta el header al cargar la página
adjustHeaderForLogin();









/*//LOGIN
function openLogin() {
    document.getElementById('section-login').style.display='block';
}
function closeLogin() {
    document.getElementById('section-login').style.display='none';
}
var login = document.getElementById('section-login');

window.onclick = function(event) {
    if (event.target == login) {
        login.style.display = "none";
    }
}

//SIGNUP
function openSignUp() {
    document.getElementById('section-signup').style.display='block';
}
function closeSignUp() {
    document.getElementById('section-signup').style.display='none';
}
var signup = document.getElementById('section-signup');

window.onclick = function(event) {
    if (event.target == signup) {
        signup.style.display = "none";
    }
}*/

//Error al introducir los datos.


//Confirmar password
/*
function comprobarClave() {
    pass = document.f1.pass.value
    cpass = document.f1.cpass.value

    if (pass == cpass) {
        alert("Las dos claves son iguales")
    } else {
        alert("Las dos claves son distintas")
    }
}
 */