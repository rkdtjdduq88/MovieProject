/**
 * 폼 모든 요소가 비어있는지 확인
 */
const form = document.querySelector("#registerForm");

form.addEventListener("submit", (e) => {
  e.preventDefault();

  let str = "";
  // form.checkValidity(): 부트스트랩에서 제공하는 함수
  if (!form.checkValidity()) {
    // e.stopPropagation(); // 이벤트 전파 막기
    form.classList.add("was-validated");
  } else {
    // 첨부파일 정보를 hidden으로 담아서 폼 전송하기
    // 게시글 내용이 작성이 다 되도 폼은 못가게 막기
    // 첨부파일 정보 수집하기
    const lis = document.querySelectorAll(".uploadResult ul li");
    console.log(lis);

    // lis forEach 돌리기=> li 태그 안에 data-속성 값 모으기
    lis.forEach((item, idx) => {
      // console.log("path ", item.dataset.path); // data-에는 대문자를 사용할 수 없다. 그래서 dataset 뒤에 소문자 변수명을 사용했다.
      // console.log("uuid ", item.dataset.uuid);
      // console.log("filename ", item.dataset.filename);
      // console.log("type ", item.dataset.type);

      // li 하나당
      // <input type='hidden' name='attachList[0].uuid' value='ff549ca7-e228-46dc-8b6b-70e34c445e9e'/>
      // <input type='hidden' name='attachList[0].uploadPath' value='2023\\05\\30'/>
      // <input type='hidden' name='attachList[0].fileName' value='cat.jpg'/>
      // <input type='hidden' name='attachList[0].fileType' value='true'/>
      str += "<input type='hidden' name='attachList[" + idx + "].uuid' value='" + item.dataset.uuid + "'/>";
      str += "<input type='hidden' name='attachList[" + idx + "].uploadPath' value='" + item.dataset.path + "'/>";
      str += "<input type='hidden' name='attachList[" + idx + "].fileName' value='" + item.dataset.filename + "'/>";
      str += "<input type='hidden' name='attachList[" + idx + "].fileType' value='" + item.dataset.type + "'/>";
    });
    // 수집한 태그 폼에 추가
    form.insertAdjacentHTML("beforeend", str);

    console.log(form);
    form.submit();
  }
});