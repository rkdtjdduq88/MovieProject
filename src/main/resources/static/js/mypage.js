/**
 *
 */
function openPopup(userid) {
    // 비밀번호 변경 팝업 열기 로직
    var passwordPopup = document.getElementById("password-popup");
    passwordPopup.style.display = "block";

    // 팝업 관련 로직 처리
    // ...
}

function delPopup(userid) {
    // 회원탈퇴 팝업 열기 로직
    var deletePopup = document.getElementById("delete-popup");
    deletePopup.style.display = "block";

    // 팝업 관련 로직 처리
    // ...
}

function closePopup(event) {
    // 팝업 닫기 로직
    var popup = event.target.closest(".popup");
    popup.style.display = "none";
}