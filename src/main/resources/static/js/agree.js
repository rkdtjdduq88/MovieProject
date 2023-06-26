/**
 *
 */
document.addEventListener("DOMContentLoaded", function () {
  var termsServiceCheckbox = document.getElementById("termsService");
  var btnSubmit = document.getElementById("btnAgree");

  termsServiceCheckbox.addEventListener("change", function () {
    if (termsServiceCheckbox.checked) {
      btnSubmit.disabled = false;
      btnSubmit.style.backgroundColor = "rgb(99 183 97)";
    } else {
      btnSubmit.disabled = true;
      btnSubmit.style.backgroundColor = "#ffffff";
    }
  });

  btnSubmit.addEventListener("click", function () {
    window.location.href = "login-register";
  });
});
