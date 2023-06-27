document.addEventListener("DOMContentLoaded", function () {
  var registerBtn = document.querySelector("#registerBtn");
  registerBtn.addEventListener("click", redirectToRegister);
});

function redirectToRegister(event) {
  event.preventDefault();
  window.location.href = "agree";
}
