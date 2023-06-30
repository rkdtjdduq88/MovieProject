/**
 *
 */
document
  .getElementById("register-form")
  .addEventListener("submit", function (event) {
    event.preventDefault(); // 기본 동작 중단

    // 입력값 가져오기
    var userid = document.getElementById("userid").value;
    var password = document.getElementById("password").value;
    var password2 = document.getElementById("password2").value;
    var email = $("#userEmail1").val() + $("#userEmail2").val();
    var name = document.getElementById("name").value;
    var address = document.getElementById("address").value;
    var mobile = document.getElementById("mobile").value;
    const inputCode = $(this).val();
    const code = data;

    if (password !== password2) {
      alert("비밀번호를 확인해주세요.");
      return;
    } else if (
      $("#mail-Check-Input").val().trim() === "" ||
      inputCode !== code
    ) {
      alert("본인인증을 해주세요.");
      return;
    } else {
      // AJAX 요청 생성

      var xhr = new XMLHttpRequest();
      var url = "/register";
      var params =
        "userid=" +
        encodeURIComponent(userid) +
        "&password=" +
        encodeURIComponent(password) +
        "&email=" +
        encodeURIComponent(email) +
        "&name=" +
        encodeURIComponent(name) +
        "&address=" +
        encodeURIComponent(address) +
        "&mobile=" +
        encodeURIComponent(mobile);
      xhr.open("POST", url, true);
      xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    }
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
            alert("회원가입되었습니다.");
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

$("#mail-Check-Btn").click(function () {
  const eamil = $("#userEmail1").val() + $("#userEmail2").val(); // 이메일 주소값 얻어오기!
  console.log("완성된 이메일 : " + eamil); // 이메일 오는지 확인
  const checkInput = $(".mail-check-input"); // 인증번호 입력하는곳

  $.ajax({
    type: "get",
    url: "/mailCheck/" + eamil,
    success: function (data) {
      console.log("data : " + data);
      checkInput.attr("disabled", false);
      code = data;
      alert("인증번호가 전송되었습니다.");
    },
  }); // end ajax
}); // end send eamil

// 인증번호 비교
// blur -> focus가 벗어나는 경우 발생
$(".mail-check-input").blur(function () {
  const inputCode = $(this).val();
  const $resultMsg = $("#mail-check-warn");

  if (inputCode === code) {
    $resultMsg.html("인증번호가 일치합니다.");
    $resultMsg.css("color", "green");
    $("#mail-Check-Btn").attr("disabled", true);
    $("#userEamil1").attr("readonly", true);
    $("#userEamil2").attr("readonly", true);
    $("#userEmail2").attr("onFocus", "this.initialSelect = this.selectedIndex");
    $("#userEmail2").attr(
      "onChange",
      "this.selectedIndex = this.initialSelect"
    );
  } else {
    $resultMsg.html("인증번호가 불일치 합니다. 다시 확인해주세요!.");
    $resultMsg.css("color", "red");
  }
});
