/**
 *
 */

document.getElementById("register-form").addEventListener("submit", function (event) {
  event.preventDefault(); // 기본 동작 중단

  // 입력값 가져오기
  var userid = document.getElementById("userid").value;
  var password = document.getElementById("password").value;
  var email = document.getElementById("email").value;
  var name = document.getElementById("name").value;
  var address = document.getElementById("address").value;
  var mobile = document.getElementById("mobile").value;

  // AJAX 요청 생성
  var xhr = new XMLHttpRequest();
  var url = "/register";
  var params = "userid=" + encodeURIComponent(userid) + "&password=" + encodeURIComponent(password) + "&email=" + encodeURIComponent(email) + "&name=" + encodeURIComponent(name) + "&address=" + encodeURIComponent(address) + "&mobile=" + encodeURIComponent(mobile);
  xhr.open("POST", url, true);
  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

  // AJAX 요청 후 응답 처리
  xhr.onreadystatechange = function () {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        var response = JSON.parse(xhr.responseText);
        if (response.success) {
          // 성공적으로 회원가입이 완료되었을 때
          notification.classList.add("success");
          notification.textContent = response.message;
          window.location.href = "/login";
        } else {
          // 회원가입 실패 시
          notification.classList.add("error");
          notification.textContent = response.message;
        }
      } else {
        // 오류가 발생했을 때
        notification.classList.add("error");
        notification.textContent = "오류가 발생했습니다. 다시 시도해주세요.";
      }
    }
  };

  // AJAX 요청 전송
  xhr.send(params);
});
