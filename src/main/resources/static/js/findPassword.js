/**
 *
 */

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

// 비밀번호 찾기 폼의 submit 이벤트 처리
$("#findPassword-form").submit(function (event) {
  event.preventDefault(); // 기본 동작인 form submit 동작을 막습니다.

  // 아이디, 이름, 이메일 등 필요한 데이터를 가져오는 로직
  const userId = $("#userid").val();
  const name = $("#name").val();
  const email = $("#userEmail1").val() + $("#userEmail2").val();
  const inputCode = $(".mail-check-input").val();

  // 입력한 아이디와 이름이 테이블에 존재하는지 확인하는 Ajax 요청
  $.ajax({
    type: "get",
    url: "/checkUser/" + userId + "/" + name,
    success: function (data) {
      if (data === "success") {
        // 이메일 인증 여부와 아이디, 이름 등의 데이터를 확인하고 비밀번호 변경 로직을 수행할 수 있습니다.
        if (inputCode === code && userId && name && email) {
          // 비밀번호 변경 로직을 수행하는 함수를 호출하거나 페이지 이동 등의 동작을 수행합니다.

          // 예시: 비밀번호 변경 후에 changePass로 페이지 이동하기
          window.location.href = "changePass";
        } else {
          // 필요한 조건이 충족되지 않았을 경우에 대한 처리를 수행합니다.
          // 예를 들어, 오류 메시지를 표시하거나 알림을 띄울 수 있습니다.
          alert("입력한 정보가 올바르지 않습니다. 다시 확인해주세요.");
        }
      } else {
        alert("입력한 아이디와 이름이 일치하지 않습니다. 다시 확인해주세요.");
      }
    },
  }); // end ajax
});