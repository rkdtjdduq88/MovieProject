// 상세페이지 리뷰 전체 리스트
function movieDetailReplyList() {
  var reviewGetList = document.querySelector(".anime__details__review .section-title");
  if (!reviewGetList) {
    console.log("리뷰 리스트를 가져올 수 없습니다.");
    return;
  }

  fetch("/replies/list/{title}")
    .then((response) => {
      if (!response.ok) {
        throw new Error("리스트 없음");
      }
      return response.json();
    })
    .then((data) => {
      console.log(data);
      var reviewList = "";
      data.forEach((list) => {
        var review = `<div class="anime__review__item">
            <div class="anime__review__item__pic">
                <img src="/img/anime/review-1.jpg" alt="">
            </div>
            <div class="anime__review__item__text">
                <h6>${list.userid}<span>1 Hour ago</span></h6>
                <p>${list.replyContent}</p>
            </div>
        </div>`;
        reviewList += review;
      });
      reviewGetList.innerHTML = reviewList;
    })
    .catch((error) => console.log("데이터를 가져올 수 없습니다.", error));
}
movieDetailReplyList();
