//Funcion para Menu de domain.
function myFunction() {
    
  var input, filter, ul, li, a, i;
  input = document.getElementById("search-admin");
  filter = input.value.toUpperCase();
  ul = document.getElementById("menu-admin");
  li = ul.getElementsByTagName("li");
  
  for (i = 0; i < li.length; i++) {
    a = li[i].getElementsByTagName("a")[0];
    if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
//Función cambio de pagina
function showPage(pageId) {
  var pageContent = document.getElementsByClassName("page-content");
  for (var i = 0; i < pageContent.length; i++) {
    pageContent[i].style.display = "none";
  }

  document.getElementById(pageId).style.display = "block";
}
document.getElementById("menu-admin").addEventListener("click", function (event) {
  var target = event.target;
  if (target.tagName.toLowerCase() === "a") {
    var li = target.parentElement;
    var pageId = li.getAttribute("data-page");
    showPage(pageId);
  }
});

