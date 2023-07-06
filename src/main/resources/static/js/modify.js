const bno = document.getElementById("Inputbno").value;

fetch("/getAttachList?bno=" + bno)
  .then((response) => {
    if (!response.ok) {
      throw new Error("첨부물 없음");
    }
    return response.json();
  })
  .then((data) => {
    console.log(data);
    showUploadFile(data);
  })
  .catch((error) => console.log(error));

// 수정 버튼 클릭해서 form submit이 일어나면 첨부파일 목록 수집하기
const modifyForm = document.querySelector("#modifyForm");

modifyForm.addEventListener("submit", (e) => {
  e.preventDefault();

  const lis = document.querySelectorAll(".uploadResult ul li");

  let str = "";
  lis.forEach((item, idx) => {
    str +=
      "<input type='hidden' name='attachList[" +
      idx +
      "].uuid' value='" +
      item.dataset.uuid +
      "'/>";
    str +=
      "<input type='hidden' name='attachList[" +
      idx +
      "].uploadPath' value='" +
      item.dataset.path +
      "'/>";
    str +=
      "<input type='hidden' name='attachList[" +
      idx +
      "].fileName' value='" +
      item.dataset.filename +
      "'/>";
    str +=
      "<input type='hidden' name='attachList[" +
      idx +
      "].fileType' value='" +
      item.dataset.type +
      "'/>";
  });

  // 수집한 태그 폼에 추가
  modifyForm.insertAdjacentHTML("beforeend", str);

  modifyForm.submit();
});

// 수정, 삭제 클릭 시 동작하는 폼

/**
 * 1. 삭제 버튼 클릭 시 operForm submit to /remove
 * 2. 목록 버튼 클릭 시 operForm submit to /list
 * 3. bno 제거하고 보내기
 */
const form = document.querySelector("#operForm");

const modify = document.querySelector(".btn-info");
if (modify) {
  modify.addEventListener("click", () => {
    // 첨부 파일의 UUID 값을 가져와서 FormData에 추가
    const uploadItems = document.querySelectorAll(".uploadResult ul li");
    const uuids = Array.from(uploadItems).map((item) => item.dataset.uuid);

    // FormData 생성
    const formData = new FormData(form);

    // UUID 값을 FormData에 추가
    for (let i = 0; i < uuids.length; i++) {
      formData.append("uuids", uuids[i]);
    }

    // FormData를 사용하여 수정 요청
    fetch("/modify", {
      method: "POST",
      headers: {
        "X-CSRF-TOKEN": csrfToken,
      },
      body: formData,
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("파일 수정 실패");
        }
        return response.json();
      })
      .then((data) => {
        console.log(data);
        // 수정 완료 후 처리할 코드 작성
      })
      .catch((error) => console.log(error));
  });
}

const btnDan = document.querySelector(".btn-danger");
if (btnDan) {
  btnDan.addEventListener("click", () => {
    form.action = "/remove";
    form.submit();
  });
}

document.querySelector(".btn-secondary").addEventListener("click", () => {
  // bno 제거하고 전송
  form.firstElementChild.remove();
  form.action = "/list";
  form.submit();
});
