/**
 *
 */
function openPopup() {
  var button = document.getElementById("change-password-button");
  var popup = document.getElementById("password-popup");

  // 버튼의 위치와 크기를 가져와서 팝업 창의 위치를 설정합니다.
  var buttonRect = button.getBoundingClientRect();
  var buttonTop = buttonRect.top + buttonRect.height;
  var buttonLeft = buttonRect.left;
  var buttonWidth = buttonRect.width;

  // 팝업 창의 위치를 설정합니다.
  popup.style.top = buttonTop + "px";
  popup.style.left = buttonLeft + "px";
  popup.style.width = buttonWidth + "px";

  // 팝업 창을 보여줍니다.
  popup.style.display = "block";
}

 function delPopup() {
    var button = document.getElementById("change-password-button");
    var popup = document.getElementById("delete-popup");

    // 버튼의 위치와 크기를 가져와서 팝업 창의 위치를 설정합니다.
    var buttonRect = button.getBoundingClientRect();
    var buttonTop = buttonRect.top + buttonRect.height;
    var buttonLeft = buttonRect.left;
    var buttonWidth = buttonRect.width;

    // 팝업 창의 위치를 설정합니다.
    popup.style.top = buttonTop + "px";
    popup.style.left = buttonLeft + "px";
    popup.style.width = buttonWidth + "px";

    // 팝업 창을 보여줍니다.
    popup.style.display = "block";
  }

function closePopup() {
  document.getElementById("password-popup").style.display = "none";
  document.getElementById("delete-popup").style.display = "none";
}



function changePassword(userId) {
  var oldPassword = document.getElementById("old-password").value;
  var newPassword = document.getElementById("new-password").value;

  var form = document.createElement("form");
  form.setAttribute("method", "post");
  form.setAttribute("action", "/changePassword");

  var userIdInput = document.createElement("input");
  userIdInput.setAttribute("type", "hidden");
  userIdInput.setAttribute("name", "userId");
  userIdInput.setAttribute("value", userId);
  form.appendChild(userIdInput);

  var oldPasswordInput = document.createElement("input");
  oldPasswordInput.setAttribute("type", "hidden");
  oldPasswordInput.setAttribute("name", "oldPassword");
  oldPasswordInput.setAttribute("value", oldPassword);
  form.appendChild(oldPasswordInput);

  var newPasswordInput = document.createElement("input");
  newPasswordInput.setAttribute("type", "hidden");
  newPasswordInput.setAttribute("name", "newPassword");
  newPasswordInput.setAttribute("value", newPassword);
  form.appendChild(newPasswordInput);

  document.body.appendChild(form);
  form.submit();

}


function deleteProfile(userId) {
  var password = document.getElementById("password-check").value;

  var form = document.createElement("form");
  form.setAttribute("method", "post");
  form.setAttribute("action", "/deleteProfile");

  var userIdInput = document.createElement("input");
  userIdInput.setAttribute("type", "hidden");
  userIdInput.setAttribute("name", "userId");
  userIdInput.setAttribute("value", userId);
  form.appendChild(userIdInput);

  var passwordInput = document.createElement("input");
  passwordInput.setAttribute("type", "hidden");
  passwordInput.setAttribute("name", "password");
  passwordInput.setAttribute("value", password);
  form.appendChild(passwordInput);

  document.body.appendChild(form);
  
  // 폼 제출
  form.submit();
  
  // 문서에서 폼 제거
  document.body.removeChild(form);
}








 function editEmail() {
     document.getElementById("email").removeAttribute("readonly");
     document.querySelector(".btn_edit").style.display = "none";
     document.querySelector(".btn_save").style.display = "inline-block";
 }

 function saveEmail(userId) {
     var email = document.getElementById("email").value;


     var form = document.createElement("form");
     form.setAttribute("method", "post");
     form.setAttribute("action", "/updateEmail");


     var userIdInput = document.createElement("input");
     userIdInput.setAttribute("type", "hidden");
     userIdInput.setAttribute("name", "userId");
     userIdInput.setAttribute("value", userId);
     form.appendChild(userIdInput);

     var emailInput = document.createElement("input");
     emailInput.setAttribute("type", "hidden");
     emailInput.setAttribute("name", "email");
     emailInput.setAttribute("value", email);
     form.appendChild(emailInput);


     document.body.appendChild(form);
     form.submit();
 }

function editMobile() {
    document.getElementById("mobile").removeAttribute("readonly");
    document.querySelector(".btn_edit2").style.display = "none";
    document.querySelector(".btn_save2").style.display = "inline-block";
}

function saveMobile(userId) {
    var mobile = document.getElementById("mobile").value;

    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", "/updateMobile");

    var userIdInput = document.createElement("input");
    userIdInput.setAttribute("type", "hidden");
    userIdInput.setAttribute("name", "userId");
    userIdInput.setAttribute("value", userId);
    form.appendChild(userIdInput);

    var mobileInput = document.createElement("input");
    mobileInput.setAttribute("type", "hidden");
    mobileInput.setAttribute("name", "mobile");
    mobileInput.setAttribute("value", mobile);
    form.appendChild(mobileInput);

    document.body.appendChild(form);
    form.submit();
}