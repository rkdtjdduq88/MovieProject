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


//로그인 버튼 클릭시
document.getElementById('login-form').addEventListener('submit', function(event) {
  event.preventDefault(); // 폼 제출 기본 동작 방지

  // 입력한 아이디와 비밀번호 가져오기
  var userid = document.getElementsByName('userid')[0].value;
  var password = document.getElementsByName('password')[0].value;

  // AJAX를 사용하여 서버로 데이터 전송
  var xhr = new XMLHttpRequest();
  xhr.open('POST', '/login');
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.onload = function() {
    if (xhr.status === 200) {
      var response = JSON.parse(xhr.responseText);
      if (response.success) {
        // 로그인 성공한 경우
        window.location.href = '/';
      } else {
        // 로그인 실패한 경우
        document.getElementById('error-message').style.display = 'block';
        document.getElementById('error-message').innerText = response.message;
      }
    } else if (xhr.status === 401) {
      // 인증 오류 처리
      document.getElementById('error-message').style.display = 'block';
      document.getElementById('error-message').innerText = '아이디 또는 비밀번호가 올바르지 않습니다.';
    } else {
      // 기타 서버 오류 처리
      document.getElementById('error-message').style.display = 'block';
      document.getElementById('error-message').innerText = '서버 오류가 발생했습니다. 잠시 후 다시 시도해주세요.';
    }
  };

  // 요청 데이터 설정
  var data = {
    userid: userid,
    password: password
  };

  xhr.send(JSON.stringify(data));
});