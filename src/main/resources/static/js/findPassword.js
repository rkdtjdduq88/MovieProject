/**
 *
 */

document.getElementById("findPassword-form").addEventListener("submit", function (event) {
  event.preventDefault(); // 기본 동작 중단

  // 입력값 가져오기
  var userid = document.getElementById("userid").value;
  var name = document.getElementById("name").value;
  var email = encodeURIComponent($("#userEmail1").val() + $("#userEmail2").val());
  email = email.replace(/%20/g, '+');
  var inputCode = $(".mail-check-input").val();

  if ($(".mail-check-input:disabled").val().trim() === "" || inputCode !== code) {
    alert("본인인증을 해주세요.");
    return;
  } else {
    // AJAX 요청 생성
    var xhr = new XMLHttpRequest();
    var url = "/findPassword";
    var params =
      "userid=" +
      encodeURIComponent(userid) +
      "&name=" +
      encodeURIComponent(name) +
      "&email=" +
      encodeURIComponent(email);
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // AJAX 요청 후 응답 처리
    xhr.onreadystatechange = function () {
      if (xhr.readyState === XMLHttpRequest.DONE) {
        if (xhr.status === 200) {
          var notification = document.getElementById("notification");
          notification.classList.add("success");
          notification.textContent = "정상적으로 작동되었습니다.";
          window.location.href = "/changePass?userid=" + encodeURIComponent(userid) + "&name=" + encodeURIComponent(name) + "&email=" + encodeURIComponent(email); // 리다이렉트 경로로 이동
        } else {
          var notification = document.getElementById("notification");
          notification.classList.add("error");
          notification.textContent = "오류가 발생했습니다. 다시 시도해주세요.";
        }
      }
    };

    // AJAX 요청 전송
    xhr.send(params);
  }
});

















let code; // 인증번호를 저장할 변수

$("#mail-Check-Btn").click(function () {
  const email = $("#userEmail1").val() + $("#userEmail2").val(); // 이메일 주소값 얻어오기!

  $.ajax({
    type: "get",
    url: "/mailCheck/" + email,
    success: function (data) {
      console.log("data: " + data);
      code = data;
      alert("인증번호가 전송되었습니다.");

      // 인증번호 전송 후에 추가적인 동작을 수행할 수 있습니다.
      $(".mail-check-input").prop("disabled", false);
    },
  }); // end ajax
}); // end send email

// 인증번호 비교
$(".mail-check-input").blur(function () {
  const inputCode = $(this).val();
  const $resultMsg = $("#mail-check-warn");

  if (inputCode === code) {
    $resultMsg.html("인증번호가 일치합니다.");
    $resultMsg.css("color", "green");
    $("#mail-Check-Btn").attr("disabled", true);
    $("#userEmail1").attr("readonly", true);
    $("#userEmail2").attr("disabled", true);
  } else {
    $resultMsg.html("인증번호가 불일치합니다. 다시 확인해주세요!");
    $resultMsg.css("color", "red");
  }
});