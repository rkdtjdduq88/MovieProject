/**
 *
 */
document.addEventListener("DOMContentLoaded", function () {
  var registerBtn = document.querySelector("#registerBtn");
  registerBtn.addEventListener("click", redirectToRegister);
});

function redirectToRegister() {
  window.location.href = "agree";
}
