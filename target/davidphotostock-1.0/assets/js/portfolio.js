//Portfolio filtro
filterSelection("all")

function filterSelection(c) {
  var x, i;
  x = document.getElementsByClassName("column-pf");
  if (c == "all") c = ""; 
  for (i = 0; i < x.length; i++) {
    hiddenClass(x[i], "show-pf");
    if (x[i].className.indexOf(c) > -1) showClass(x[i], "show-pf");
  }
}

function showClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    if (arr1.indexOf(arr2[i]) == -1) {
      element.className += " " + arr2[i];
    }
  }
}

function hiddenClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    while (arr1.indexOf(arr2[i]) > -1) {
      arr1.splice(arr1.indexOf(arr2[i]), 1);
    }
  }
  element.className = arr1.join(" ");
}

var btnContainer = document.getElementById("container-btn-pf");
var btns = btnContainer.getElementsByClassName("btn-pf");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function(){
    var current = document.getElementsByClassName("active-pf");
    current[0].className = current[0].className.replace(" active-pf", "");
    this.className += " active-pf";
  });
}

//Dropdown
function showDrop(id) {
  document.getElementById(id).classList.toggle("show-dr");
}

document.addEventListener('click', function(event) {
  var dropdownButtons = document.querySelectorAll('.btn-drop');
  var dropdownContents = document.querySelectorAll('.content-dropdown');
  
  var clickedInsideButton = Array.from(dropdownButtons).some(button => button === event.target || button.contains(event.target));
  var clickedInsideContent = Array.from(dropdownContents).some(content => content === event.target || content.contains(event.target));

  if (!clickedInsideButton && !clickedInsideContent) {
    Array.from(dropdownContents).forEach(content => content.classList.remove('show-dr'));
  }
});

