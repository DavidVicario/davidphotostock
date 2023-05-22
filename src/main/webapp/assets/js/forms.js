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

// Ajusta el header al cargar la página
window.onload = function() {
    var loginLink = document.getElementById('login-link');
    var signupLink = document.getElementById('signup-link');
    var userLink = document.getElementById('user-link');
    var logoutLink = document.getElementById('logout-link');

    fetch('/UsersServlet?action=checkLogin')
        .then(response => response.text())
        .then(username => {
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
        .catch((error) => {
            console.error('Error:', error);
        });
};

// Función para cerrar sesión
window.logout = function() {
    fetch('/UsersServlet?action=logout', { method: 'POST' })
        .then(response => {
            if (response.status === 200) {
                
                var loginLink = document.getElementById('login-link');
                var signupLink = document.getElementById('signup-link');
                
                loginLink.textContent = 'LOGIN';
                signupLink.textContent = 'SIGN UP';
            } else {
                console.log('Error logging out');
            }
        })
        .catch((error) => {
            console.error('Error:', error);
        });
};


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