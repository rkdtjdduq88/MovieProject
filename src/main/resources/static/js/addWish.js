/**
 *
 */

//위시리스트
// 위시리스트 버튼을 누르면 확인해서 추가 혹은 이미 있다고 안내
document.querySelector(".follow-btn").addEventListener("click", (e) => {
  e.preventDefault();

  //   if (userid.trim() === "") {
  //     // alert("로그인 후 이용이 가능합니다.");
  //     Swal.fire({
  //       icon: "warning",
  //       title: "로그인 필요",
  //       text: "로그인 후 이용이 가능합니다.",
  //     });
  //     return;
  //   }

  const wishInfo = {
    title: document.querySelector('input[name="title"]').value,
    directorNm: document.querySelector('input[name="directorNm"]').value,
    releaseDate: document.querySelector('input[name="releaseDate"]').value,
    posterUrl: document.querySelector('input[name="posterUrl"]').value,
    userid: document.querySelector('input[name="userid"]').value,
  };

  fetch("/wish/new", {
    method: "post",
    headers: {
      "content-type": "application/json",
      "X-CSRF-TOKEN": csrfToken,
    },
    body: JSON.stringify(wishInfo),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("영화가 이미 위시리스트에 존재합니다.");
      }
      return response.text();
    })
    .then((message) => {
      // alert(message); // 서버로부터 받은 메시지를 알림창으로 표시
      Swal.fire({
        icon: "success",
        title: "추가 완료",
        text: message,
      });
    })
    .catch((error) => {
      // alert(error.message); // 에러 메시지를 알림창으로 표시
      Swal.fire({
        icon: "error",
        title: error.message,
        text: "위시리스트 삭제는 wish페이지에서 확인해주세요.",
      });
    });
});
