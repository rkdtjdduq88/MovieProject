/**
 *
 */

// 사용자의 전체 위시리스트 불러오는 함수
function showWishList() {
  fetch("/wish/wishList/" + userid, {
    headers: {
      "content-type": "application/json",
    },
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("리스트 없음");
      }
      return response.json();
    })
    .then((data) => {
      var wishTag = "";
      console.log(data);
      // 받아온 위시리스트 데이터를 순회하며 태그 생성
      data.forEach((wishlist) => {
        const { wno, title, directorNm, releaseDate, posterUrl } = wishlist;

        // 위시리스트 태그 생성 //my-5 // mx-auto
        let wishlistTag = `
          <div class="col-lg-4 col-md-6 col-sm-6"> 
            <div class="product__item">
              <div class="product__item__pic set-bg" data-setbg="${posterUrl}" style="background-image: url('${posterUrl}')">
              </div>
              <div class="product__item__text" style="float: right; text-align: left;">
                <div class="over">
                  <div class="tit">${title}</div>
                  <div class="rdt">${releaseDate}</div>
                  <div class="drc">${directorNm}</div>
                  <a href="/movie/details?movieNm=${title}&movieDt=${releaseDate}"><div class="view">리뷰 & 평점</div></a>
                </div>
                  <div class="btn-group">
                    <a class="btn btn-secondary" data-wno=${wno}>위시리스트 삭제</a>
                  </div>
              </div>
            </div>
          </div>
        `;
        wishTag += wishlistTag; // 생성한 위시리스트 태그 추가
      });

      // 생성한 위시리스트 태그를 화면에 추가 // .product__page__content
      const productPageContent = document.querySelector(".row.wishList");
      productPageContent.insertAdjacentHTML("beforeend", wishTag);
    })
    .catch((error) => console.log(error));
}
showWishList();

// 위시리스트에서 영화 삭제하는 코드
document.addEventListener("click", (e) => {
  if (e.target.classList.contains("btn-secondary")) {
    let wno = e.target.dataset.wno;

    fetch("/wish/remove/" + wno, {
      method: "delete",
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("삭제 실패");
        }
        return response.text();
      })
      .then((message) => {
        Swal.fire({
          icon: "success",
          title: "삭제 완료",
          text: message,
        });
        // showWishList(); // 화면 데이터 다시 가져오기
        // 삭제 후에 showWishList 함수 호출 대신 화면에서 해당 항목을 직접 제거
        const deletedItem = e.target.closest(".col-lg-4");
        deletedItem.remove();
      })
      .catch((error) => console.log(error));
  }
});

// 이벤트 위임을 통해 마우스 이벤트 적용
document.addEventListener("mouseover", function (event) {
  // 마우스를 올린 요소가 .product__item__pic 클래스를 포함하는 경우에만 처리
  if (event.target.matches(".product__item__pic")) {
    const productItem = event.target.closest(".product__item");
    const overElement = productItem.querySelector(".over");
    overElement.style.display = "block";
  }
});

document.addEventListener("mouseout", function (event) {
  // 마우스를 벗어난 요소가 .product__item__pic 클래스를 포함하는 경우에만 처리
  if (event.target.matches(".product__item__pic")) {
    const productItem = event.target.closest(".product__item");
    const overElement = productItem.querySelector(".over");
    overElement.style.display = "none";
  }
});

// // 위시리스트에서 영화 삭제
// document.querySelector(".btn-success").addEventListener("click", (e) => {
//   //WNO
//   let wno = e.target.dataset.wno;

//   fetch(
//     "/wish/remove/" +
//       wno +
//       {
//         method: "delete",
//       }
//   )
//     .then((response) => {
//       if (!response.ok) {
//         throw new Error("삭제 실패");
//       }
//       return response.text();
//     })
//     .then((message) => {
//       // alert(message); // 서버로부터 받은 메시지를 알림창으로 표시
//       Swal.fire({
//         icon: "success",
//         title: "삭제 완료",
//         text: message,
//       });
//       showWishList(); // 화면 데이터 다시 가져오기
//     })
//     .catch((error) => console.log(error));
// });
