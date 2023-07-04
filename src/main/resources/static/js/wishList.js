let page = 1;
// 사용자의 전체 위시리스트 불러오는 함수
function showWishList(page) {
  fetch("/wish/wishList/" + userid + "/" + page, {
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
      data.list.forEach((wishlist) => {
        const { wno, title, directorNm, releaseDate, posterUrl } = wishlist;

        // 위시리스트 태그 생성 //my-5 // mx-auto
        let wishlistTag = `
          <div class="col-lg-3 col-md-4 col-sm-6 wishTitle"> 
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
                
              <div class="svg-wrapper">
              <svg height="40" width="150" xmlns="http://www.w3.org/2000/svg">
                <rect id="shape" height="40" width="150" />
                <div id="text">
                  <a data-wno="${wno}"><span class="spot"></span>위시리스트 삭제</a>
                </div>
              </svg>
            </div>
              
              </div>
            </div>
          </div>
        `;
        wishTag += wishlistTag; // 생성한 위시리스트 태그 추가
      });

      // 생성한 위시리스트 태그를 화면에 추가 // .product__page__content
      const productPageContent = document.querySelector(".row.wishList");
      // productPageContent.insertAdjacentHTML("beforeend", wishTag);
      productPageContent.innerHTML = wishTag; // 기존의 위시리스트 요소들을 새로운 요소로 대체

      pagination(data.total);
    })
    .catch((error) => console.log(error));
}
showWishList(page);

// 페이지 이동 시 showWishList 함수 호출
function handlePageChange(e) {
  e.preventDefault();
  const newPage = e.target.getAttribute("href");
  page = newPage;
  // const productPageContent = document.querySelector(".row.wishList");
  // productPageContent.innerHTML = ""; // 기존의 위시리스트 요소들을 모두 제거
  showWishList(page);
}
// 페이지 번호를 클릭할 때 showWishList 함수 호출
document.querySelector(".pagination-container").addEventListener("click", handlePageChange);

function pagination(total) {
  let endPage = Math.ceil(page / 12.0) * 12;
  let startPage = endPage - 11;
  let prev = startPage != 1;
  let next = endPage * 12 < total;

  if (endPage * 12 >= total) {
    endPage = Math.ceil(total / 12.0);
  }

  let str = "";
  if (prev) {
    str += " <a href='" + (startPage - 1) + "'><i class='fa fa-angle-double-left'></i></a>";
  }

  for (let i = startPage; i <= endPage; i++) {
    let active = page == i ? "current-page" : "";
    str += "<a href='" + i + "' class='" + active + "'>" + i + "</a>";
  }

  if (next) {
    str += " <a href='" + (endPage + 1) + "'><i class='fa fa-angle-double-right'></i></a>";
  }

  document.querySelector(".pagination-container").innerHTML = str;
}

document.querySelector(".product__pagination").addEventListener("click", (e) => {
  e.preventDefault();
  page = e.target.getAttribute("href");
  showWishList(page);
});

// 영화 위시리스트 삭제 코드
document.addEventListener("click", (e) => {
  if (e.target.classList.contains("spot")) {
    let wno = e.target.closest("a").dataset.wno;

    fetch("/wish/remove/" + wno, {
      method: "delete",
      "X-CSRF-TOKEN": csrfToken,
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
        const deletedItem = e.target.closest(".wishTitle");
        deletedItem.remove();
        showWishList(page);
      })
      .catch((error) => console.log(error));
  }
});

document.addEventListener("mouseover", function (event) {
  if (event.target.matches(".product__item__pic")) {
    const productItem = event.target.closest(".product__item");
    const overElement = productItem.querySelector(".over");
    overElement.style.display = "block";
  }
});

document.addEventListener("mouseout", function (event) {
  if (event.target.matches(".product__item__pic")) {
    const productItem = event.target.closest(".product__item");
    const overElement = productItem.querySelector(".over");
    overElement.style.display = "none";
  }
});
