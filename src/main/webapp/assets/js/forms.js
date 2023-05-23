//Función para abrir formularios
function openForm(formName) {
    if (formName == 'login') {
        document.getElementById('section-login').style.display = 'block';
    } else if (formName == 'signup') {
        document.getElementById('section-signup').style.display = 'block';
    } 
}

//Función para cerrar formularios
function closeForm(formName) {
    if (formName == 'login') {
        document.getElementById('section-login').style.display = 'none';
    } else if (formName == 'signup') {
        document.getElementById('section-signup').style.display = 'none';
    } 
}

//Cierre de formulario al hacer click fuera de él
const login = document.getElementById('section-login');
const signup = document.getElementById('section-signup');

window.onclick = function(event) {
    if (event.target == login) {
        login.style.display = "none";
    }
    if (event.target == signup) {
        signup.style.display = "none";
    }
}

//Funcion para ajustar el header al cargar la página
window.onload = function() {
    const loginLink = document.getElementById('login-link');
    const signupLink = document.getElementById('signup-link');
    const userLink = document.getElementById('user-link');
    const logoutLink = document.getElementById('logout-link');

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

//Función para cerrar sesión
window.logout = function() {
    fetch('/UsersServlet?action=logout', { method: 'POST' })
        .then(response => {
            if (response.status === 200) {
                
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
        .catch((error) => {
            console.error('Error:', error);
        });
};

//Confirmar password y usuario.
function checkPassword(val){
    const regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/; 
    if(regex.test(val)){
        return true;        
    }else{
        return false;        
    }   
}

const validate = document.querySelector('.content-signup');

validate.onsubmit = function() {
    if(validate.user.value == "") {
        alert("Debe escribir un nombre de usuario");
        validate.user.focus();
        return false;
    }
    let re = /^\w{4,10}$/;
    if(!re.test(validate.user.value)) {
        alert("Nombre de usuario solo debe contener letras, números y underscores. Longitud entre 4 - 10.");
        validate.user.focus();
        return false;
    }
    if(validate.pass.value != "" && validate.pass.value == validate.cpass.value) {
        if(!checkPassword(validate.pass.value)) {
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


//Error al introducir los datos.