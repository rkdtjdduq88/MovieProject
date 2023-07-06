/**
 *
 */
document.querySelector("#uploadFile").addEventListener("change", (e) => {
  // formData 객체 생성
  const formData = new FormData();
  var files = e.target.files;
  var uploadResult = document.querySelector(".uploadResult ul");
  // file 요소 가져오기
  let inputFiles = document.querySelector("#uploadFile").files;

  // 가져온 file 요소를 formData에 추가
  for (let i = 0; i < inputFiles.length; i++) {
    console.log("i: ", i);
    formData.append("uploadFile", inputFiles[i]);
  }
  // 파일 개수 제한
  if (files.length > 1) {
    alert("파일은 하나만 업로드 가능합니다.");
    return;
  }
  // 비동기 formData 전송
  fetch("/uploadAjax", {
    method: "post",
    headers: {
      "X-CSRF-TOKEN": csrfToken,
    },
    body: formData,
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("파일 업로드 실패");
      }
      return response.json();
    })
    .then((data) => {
      console.log(data);
      showUploadFile(data);
    })
    .catch((error) => console.log(error));
});

function showUploadFile(uploadResultArr) {
  // 도착한 데이터 (파일 업로드 정보)에서 파일 이름을 li 태그로 보여준다
  const uploadResult = document.querySelector(".uploadResult ul");
  let str = "";

  uploadResultArr.forEach((item) => {
    // fileType이 true인 경우 이미지 파일이므로 thumbnail 이미지를 보여준다
    if (item.fileType) {
      // 썸네일 이미지 경로 생성
      let fileCallPath = encodeURIComponent(
        item.uploadPath + "/s_" + item.uuid + "_" + item.fileName
      );
      // 썸네일 이미지 클릭 ==> 원본 이미지 보여주기
      let oriFileCallPath = encodeURIComponent(
        item.uploadPath + "/" + item.uuid + "_" + item.fileName
      );
      str +=
        "<li data-path='" + item.uploadPath + "'data-uuid='" + item.uuid + "'";
      str +=
        "data-filename='" +
        item.fileName +
        "'data-type='" +
        item.fileType +
        "'>";
      str +=
        "<a href='/display?fileName=" +
        oriFileCallPath +
        "' data-lightbox='image'>";
      str +=
        "<div class='text-center'><img src='/display?fileName=" +
        fileCallPath +
        "'></div></a>";
      str += "<small>" + item.fileName + "</small> ";
      str +=
        "<button type ='button' class='btn btn-sm btn-circle btn-warning' data-file='" +
        fileCallPath +
        "' data-type='image'> X </button>";
      str += "</li>";
    } else {
      // txt 파일
      let fileCallPath = encodeURIComponent(
        item.uploadPath + "/" + item.uuid + "_" + item.fileName
      );
      str +=
        "<li data-path='" + item.uploadPath + "'data-uuid='" + item.uuid + "'";
      str +=
        "data-filename='" +
        item.fileName +
        "'data-type='" +
        item.fileType +
        "'>";
      str += "<a href='/download?fileName=" + fileCallPath + "'>";
      str +=
        "<div class='text-center'><img src='/resources/img/txt-file.png'></div>";
      str += "<small>" + item.fileName + "</small></a>";
      str +=
        "<button type ='button' class='btn btn-sm btn-circle btn-warning' data-file='" +
        fileCallPath +
        "' data-type='file'>X</button>";
      str += "</li>";
    }
  });
  console.log("파일첨부 ", str);
  uploadResult.insertAdjacentHTML("beforeend", str);
}

//x 클릭 시 동작하는 함수 alert
//register jsp 에서 사용하는 개념하고 modify jsp 에서 사용하는 개념은 다르다.

//자식한테 이벤트가 일어나면 부모에게 전파 ==> 이벤트 전파
//실제 이벤트가 발생한 대상 : 자식, ==>e.target
//이벤트를 감지한 부모 ==> e.currentTarget
// 모든 .uploadResult 클래스를 가진 요소를 선택하여 각각에 이벤트 리스너 등록
// 파일 삭제 이벤트 리스너
document
  .querySelector(".uploadResult ul")
  .addEventListener("click", function (e) {
    if (e.target.tagName === "BUTTON") {
      // 삭제 버튼 클릭 시
      var target = e.target.parentNode;
      var path = target.dataset.path;
      var type = target.dataset.type;
      var uuid = target.dataset.uuid;
      var fileName = target.dataset.filename;

      // 파일 삭제 확인 메시지 표시
      if (confirm("해당 파일을 삭제하시겠습니까?")) {
        // 서버로 삭제 요청
        fetch(
          "/deleteFile?fileName=" +
            encodeURIComponent(path + "/" + uuid + "_" + fileName) +
            "&type=" +
            type,
          {
            method: "POST",
            headers: {
              "X-CSRF-TOKEN": csrfToken,
            },
          }
        )
          .then(function (response) {
            if (!response.ok) {
              throw new Error("파일 삭제 실패");
            }
            return response.json();
          })
          .then(function (data) {
            console.log(data);
            // 삭제 성공 시 해당 파일 아이템 제거
            target.remove();
          })
          .catch(function (error) {
            console.log(error);
          });
      }
    }
  });
