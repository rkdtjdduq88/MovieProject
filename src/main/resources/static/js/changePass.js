/**
 *
 */
document
  .getElementById("ChangePass-form")
  .addEventListener("submit", function (event) {
    event.preventDefault(); // 기본 동작 중단
    
    var newPassword = document.getElementById("newPassword").value;
    var newPassword2 = document.getElementById("newPassword2").value;

    if (newPassword !== newPassword2) {
      alert("비밀번호를 확인해주세요.");
      return;
    } else {
     	
		document.getElementById("ChangePass-form").submit();
    }
    
  });