
/**
 *
 */
 //회원 가입버튼 클릭시
document.addEventListener("DOMContentLoaded", function () {
  var registerBtn = document.querySelector("#registerBtn");
  registerBtn.addEventListener("click", redirectToRegister);
});

function redirectToRegister() {
  window.location.href = "agree";
}

 //비밀번호 찾기 클릭시
 document.addEventListener("DOMContentLoaded", function () {
  var findPassword = document.querySelector("#findPassword");
  findPassword.addEventListener("click", redirectToFindPassword);
});

function redirectToFindPassword() {
  window.location.href = "/findPassword";
}

