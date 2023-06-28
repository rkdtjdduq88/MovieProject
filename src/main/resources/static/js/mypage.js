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



function validatePasswordChange(userId) {
        var oldPassword = document.getElementById("old-password").value;
        var newPassword = document.getElementById("new-password").value;

        if (oldPassword === "") {
            alert("기존 비밀번호를 입력해주세요.");
            return;
        }

        if (newPassword === "") {
            alert("새 비밀번호를 입력해주세요.");
            return;
        }

        if (oldPassword === newPassword) {
            alert("기존 비밀번호와 새 비밀번호가 동일합니다. 다른 비밀번호를 입력해주세요.");
            return;
        }

        var confirmChange = confirm("비밀번호를 변경하시겠습니까?");
        if (confirmChange) {
            changePassword(userId, oldPassword, newPassword);
        }
    }

    function changePassword(userId, oldPassword, newPassword) {
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


    
    
    

function validateProfileDeletion(userId) {
    var password = document.getElementById("password-check").value;

    if (password === "") {
        alert("비밀번호를 입력해주세요.");
        return;
    }

    var confirmDeletion = confirm("회원탈퇴를 진행 하시겠습니까?");
    if (confirmDeletion) {
        deleteProfile(userId, password);
    }
}

function deleteProfile(userId, password) {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/deleteProfile", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var response = xhr.responseText;
                if (response === "success") {
                    // 회원 탈퇴 성공
                    window.location.href = "/login";
                } else {
                    // 비밀번호가 일치하지 않는 경우
                    alert("비밀번호를 확인해주세요.");
                }
            } else {
                window.location.href = "/login";
            }
        }
    };
    xhr.send("userId=" + encodeURIComponent(userId) + "&password=" + encodeURIComponent(password));
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