// 상세페이지 리뷰 전체 리스트
function movieDetailReplyList() {
  var reviewGetList = document.querySelector(".anime__details__review .section-title");
  if (!reviewGetList) {
    console.log("리뷰 리스트를 가져올 수 없습니다.");
    return;
  }

  fetch("/replies/list/" + title)
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
                <h6>${list.userid}<span>1 hour ago</span></h6>
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

// 리뷰에 몇시간전에 달았는지 보는 기능 넣기
function displayTime(timeVal) {
  const today = new Date(); // 오늘날짜

  // 오늘 날짜 - 댓글작성날짜
  let gap = today.getTime() - timeVal; // 오늘날짜 - 작성날짜 => 밀리세컨 단위로 나옴

  // 댓글작성날짜 Date 객체 생성
  let dateObj = new Date(timeVal);

  let str = "";
  // 작성날짜를 보여줄 때 24시간 안에 작성했느냐? 넘었느냐?
  // 24시간 안이라면 시분초, 넘었다면 년/월/일 형태로 보여주기
  // 1000 * 60 * 60 * 24 : 하루 24시간을 밀리세컨 단위로 만들기
  if (gap < 1000 * 60 * 60 * 24) {
    let hh = dateObj.getHours(); // 1~9시 10~12시
    let mi = dateObj.getMinutes();
    let ss = dateObj.getSeconds();

    return [
      (hh > 9 ? "" : "0") + hh, // 시간이 두자리면 그냥 넘어가고 한자리면 앞자리에 "0" 붙이기
      ":",
      (mi > 9 ? "" : "0") + mi,
      ":",
      (ss > 9 ? "" : "0") + ss,
    ].join("");
  } else {
    const yy = dateObj.getFullYear();
    const mm = dateObj.getMonth() + 1; //월은 0부터 시작이기때문에 +1
    const dd = dateObj.getDate();
    return [
      yy,
      "/",
      (mm > 9 ? "" : "0") + mm, // 월이 두자리면 그냥 넘어가고 한자리면 앞자리에 "0" 붙이기
      "/",
      (dd > 9 ? "" : "0") + dd,
    ].join("");
  }
} // 댓글 시간넣기 종료
