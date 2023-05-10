//LOGIN
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
}

//Error al introducir los datos.
var errorSpan = document.getElementById("error-message");

errorSpan.innerHTML = "Rellena todos los campos con *" // plain javascript

// $("#errorSpan").html("Rellena todos los campos con *");  Jquery