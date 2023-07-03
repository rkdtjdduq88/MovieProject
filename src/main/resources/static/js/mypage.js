/**
 *
 */
function openPopup() {
  event.preventDefault();
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
  form.submit();
}

 function delPopup() {
    event.preventDefault();
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
    form.submit();
  }
  
function closePopup() {
  document.getElementById("password-popup").style.display = "none";
  document.getElementById("delete-popup").style.display = "none";
}










