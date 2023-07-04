/**
 *
 */
let code = 0;


document
  .getElementById("findPassword-form")
  .addEventListener("submit", function (event) {
    event.preventDefault(); // 기본 동작 중단

    var inputCode = document.getElementById("mail-Check-Input").value;

    if ($("#mail-Check-Input").val().trim() === "" || inputCode !== code) {
      alert("본인인증을 해주세요.");
      return;
    }

    console.log();
    console.log(document.getElementById("findPassword-form"));

    document.getElementById("findPassword-form").submit();
  });

document.querySelector("#selectEmail").addEventListener("change", (e) => {
  document.querySelector("#userEmail2").value = e.target.value;
});

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
    $("#selectEmail").attr("disabled", true);
  } else {
    $resultMsg.html("인증번호가 불일치합니다. 다시 확인해주세요!");
    $resultMsg.css("color", "red");
  }
});

