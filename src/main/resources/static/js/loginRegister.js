/**
 *
 */

let code = 0;

document
  .getElementById("register-form")
  .addEventListener("submit", function (event) {
    event.preventDefault(); // 기본 동작 중단

    // 입력값 가져오기
   
    var password = document.getElementById("password").value;
    var password2 = document.getElementById("password2").value;
    
    var Input = document.getElementById("mail-Check-Input").value;

    if (password !== password2) {
      alert("비밀번호를 확인해주세요.");
      return;
    } else if ($("#mail-Check-Input").val().trim() === "" || Input !== code) {
      alert("본인인증을 해주세요.");
      return;
    } else {
     	
		document.getElementById("register-form").submit();
    }
    
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


document.querySelector(".btn-danger").addEventListener("click", () => {
    // 사용자가 입력한 userid 가져오기
    const userid = document.querySelector("#userid").value;
    fetch(`/dupId?userid=${userid}`, {
        method: "get"
    })
        .then((response) => response.text())
        .then((result) => {
            console.log(result);
            if (result.trim() === "true") {
                alert("아이디를 사용할 수 있습니다.");
            } else {
                alert("아이디를 사용할 수 없습니다.");
            }
        });
});
