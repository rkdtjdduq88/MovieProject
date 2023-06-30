<<<<<<< HEAD
// 상세페이지 리뷰 전체 리스트(listAll)
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
      data.list.forEach((list) => {
        var isCurrentUser = list.userid === userid; // 현재 사용자와 댓글 작성자를 비교

        var buttons = "";
        if (isCurrentUser) {
          buttons = `
            <button class="btn btn-danger" type="button">삭제</button>                        
            <button class="btn btn-warning" type="button">수정</button>
          `;
        }
        var ratingStars = getRatingStars(list.grade);

        var review = `<div class="anime__review__item">
            <div class="anime__review__item__pic">
            <img src="https://avatars.dicebear.com/api/bottts/${list.userid}.jpg" alt="img" style="width: 80px; height: 80px; border-radius: 50%;">
            </div>
                <div class="anime__review__item__text" data-rno="${list.rno}">      
                  <div class="row">  
                    <div class="col">
                      <h6>${list.userid}</h6>                      
                    </div>
                    <span class="material-symbols-outlined">
                      favorite
                      </span>
                    <div class="col">
                      <h6><span>${displayTime(list.replydate)}</span></h6>
                    </div>
                        <div class="rating">
                            ${ratingStars}
                          </div>
                      </div>                         
                        <h6>${buttons}</h6>                                        
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

/////////////////////////////////////////////////////////////////////////////////////////////
// 상세페이지 댓글 작성 기능넣기(insert)

// 리뷰 별점 기능 넣기(grade)
let grade = 0;
const rating = document.querySelector("#insertForm .rating");
const stars = rating.querySelectorAll(".fa-star-o");

rating.addEventListener("click", (e) => {
  // 클릭된 별 요소 가져오기
  const starRating = e.target;

  // 클릭된 별의 인덱스를 가져오기
  const starIndex = Array.from(stars).indexOf(starRating);

  starRating.classList.remove("star-o");
  starRating.classList.add("fa-star");

  // 클릭한 별까지 별을 채우기
  for (let i = 0; i < stars.length; i++) {
    if (i <= starIndex) {
      stars[i].classList.remove("fa-star-o");
      stars[i].classList.add("fa-star");
    } else {
      stars[i].classList.remove("fa-star");
      stars[i].classList.add("fa-star-o");
    }
  }

  //console.log(starRating.dataset.value);
  grade = starRating.dataset.value;
});

document.querySelector("#insertForm").addEventListener("submit", (e) => {
  e.preventDefault();

  const replyContent = document.querySelector("#insertForm #replyContent").value;
  const userid = document.querySelector("#insertForm #userid").value;

  const data = {
    replyContent: replyContent,
    userid: userid,
    title: title,
    grade: grade,
  };

  fetch("/replies/new", {
    method: "post",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("입력 오류");
      }
      return response.text();
    })
    .then((data) => {
      //console.log(data);

      movieDetailReplyList();
    })
    .catch((error) => console.log(error));
});

////////////////////////////////////////////////////////////////////////////////////////////////
// 댓글 수정하기전 댓글 정보 가져오는 작업(read)
document.querySelector(".section-title").addEventListener("click", (e) => {
  // e.target : 이벤트 발생 대상
  // 이벤트 발생 대상을 감싸고 있는 부모 div 찾기
  let div = e.target.closest("div");
  //console.log("이벤트 발생 ", div);

  // rno 가져오기 (data-* 속성값 가져오기 : dataset)
  let rno = div.dataset.rno;
  //console.log("rno ", rno);

  // 댓글 작성자 정보 가져오기
  let userid = div.querySelector("div.col > h6").innerHTML;
  //console.log("댓글 작성자 ", userid);

  // 로그인 사용자 정보 가져오기
  let form_replyer = document.querySelector("#insertForm #userid");
  let login_user = "";
  if (form_replyer) {
    login_user = form_replyer.value;
  }

  if (!login_user) {
    alert("로그인 한 후 수정 및 삭제가 가능합니다.");
    return;
  }

  // 이벤트를 부모가 감지를 하기 때문에
  if (e.target.classList.contains("btn-warning")) {
    // 댓글 하나 가져오기
    // 로그인 사용자와 댓글 작성자가 같은지 확인
    if (userid != login_user) {
      alert("자신의 댓글만 수정이 가능합니다.");
      return;
    }
    fetch("/replies/" + rno)
      .then((response) => {
        if (!response.ok) {
          throw new Error("가져올 댓글 없음");
        }
        return response.json();
      })
      .then((data) => {
        //console.log(data);
        document.querySelector(".modal-body #rno").value = data.rno;
        document.querySelector(".modal-body #replyContent").value = data.replyContent;
        document.querySelector(".modal-body #userid").value = data.userid;
        $("#replyModal").modal("show");
      })
      .catch((error) => console.log(error));
    // 댓글 하나 불러오기 종료

    // 모달 창 안에 가져온 내용 보여주기
  } else if (e.target.classList.contains("btn-danger")) {
    // 로그인 사용자와 댓글 작성자가 같은지 확인
    if (userid != login_user) {
      alert("자신의 댓글만 수정이 가능합니다.");
      return;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // 삭제버튼 클릭 시(delete)
    fetch("/replies/" + rno, {
      method: "delete",
      headers: {
        "content-type": "application/json",
      },
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("삭제 불가");
        }
        return response.text();
      })
      .then((data) => {
        if (data === "success") {
          alert("삭제 성공");
          movieDetailReplyList();
        }
      })
      .catch((error) => console.log(error));
  }
});

///////////////////////////////////////////////////////////////////////////////////////////////////////
// 댓글 수정 작업 (update)
document.querySelector(".modal-footer .btn-primary").addEventListener("click", () => {
  // 모달 창안에 있는 rno, reply 가져온 후 자바스크립트 객체 생성
  rno = document.querySelector(".modal-body #rno").value;
  const updateReply = {
    rno: rno,
    replyContent: document.querySelector(".form-group #replyContent").value,
    userid: document.querySelector(".form-group #userid").value,
  };

  // fetch update 호출
  fetch("/replies/" + rno, {
    method: "put",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(updateReply),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("수정 실패");
      }
      return response.text();
    })
    .then((data) => {
      //console.log("수정내용", data);
      if (data === "success") {
        $("#replyModal").modal("hide");
        movieDetailReplyList();
      }
    })
    .catch((error) => console.log(error));
});

///////////////////////////////////////////////////////////////////////////////////////////////////////
// 리뷰에 몇시간전에 달았는지 보는 기능을 가진 함수 작성
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

///////////////////////////////////////////////////////////////////////////////////////////////////////
// 별점 넣기 함수
// 별점에 따라 별 아이콘 생성 및 색깔 채우기
function getRatingStars(grade) {
  var filledStars = Math.floor(grade); // 채워진 별의 개수 (정수 부분)
  var halfStar = grade - filledStars === 0.5; // 반 별이 채워져야 하는지 여부

  var starIcons = "";
  for (var i = 0; i < filledStars; i++) {
    starIcons += `<i class="fa fa-star"></i>`;
  }
  if (halfStar) {
    starIcons += `<i class="fa fa-star-half-o"></i>`;
  }
  for (var j = filledStars + (halfStar ? 1 : 0); j < 5; j++) {
    starIcons += `<i class="fa fa-star-o"></i>`;
  }

  return starIcons;
}
=======
/**
 *
 */
// 상세페이지 리뷰 전체 리스트(listAll)
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
      //console.log(data);
      var reviewList = "";
      data.forEach((list) => {
        var isCurrentUser = list.userid === userid; // 현재 사용자와 댓글 작성자를 비교

        var buttons = "";
        if (isCurrentUser) {
          buttons = `
              <button class="btn btn-danger" type="button">삭제</button>                        
              <button class="btn btn-warning" type="button">수정</button>
            `;
        }

        var review = `<div class="anime__review__item">
              <div class="anime__review__item__pic">
                  <img src="/img/anime/review-1.jpg" alt="">
              </div>
                  <div class="anime__review__item__text" data-rno="${list.rno}">      
                    <div class="row">  
                      <div class="col">
                        <h6>${list.userid}</h6>
                      </div>
                      <div class="col">
                        <h6><span>${displayTime(list.replydate)}</span></h6>
                      </div>
                      <div class="rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star-half-o"></i>
                          </div>
                    </div>                         
                          <h6>${buttons}</h6>                                        
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

/////////////////////////////////////////////////////////////////////////////////////////////
// 상세페이지 댓글 작성 기능넣기(insert)

document.querySelector("#insertForm").addEventListener("submit", (e) => {
  e.preventDefault();

  const replyContent = document.querySelector("#insertForm #replyContent").value;
  const userid = document.querySelector("#insertForm #userid").value;
  // const rno = document.querySelector("#rno").value;

  const data = {
    replyContent: replyContent,
    userid: userid,
    title: title,
  };

  fetch("/replies/new", {
    method: "post",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("입력 오류");
      }
      return response.text();
    })
    .then((data) => {
      console.log(data);

      movieDetailReplyList();
    })
    .catch((error) => console.log(error));
});
////////////////////////////////////////////////////////////////////////////////////////////////
// 댓글 수정하기전 댓글 정보 가져오는 작업(read)
document.querySelector(".section-title").addEventListener("click", (e) => {
  // e.target : 이벤트 발생 대상
  // 이벤트 발생 대상을 감싸고 있는 부모 div 찾기
  let div = e.target.closest("div");
  console.log("이벤트 발생 ", div);

  // rno 가져오기 (data-* 속성값 가져오기 : dataset)
  let rno = div.dataset.rno;
  //console.log("rno ", rno);

  // 댓글 작성자 정보 가져오기
  let userid = div.querySelector("div.col > h6").innerHTML;
  //console.log("댓글 작성자 ", userid);

  // 로그인 사용자 정보 가져오기
  let form_replyer = document.querySelector("#insertForm #userid");
  let login_user = "";
  if (form_replyer) {
    login_user = form_replyer.value;
  }

  if (!login_user) {
    alert("로그인 한 후 수정 및 삭제가 가능합니다.");
    return;
  }

  // 이벤트를 부모가 감지를 하기 때문에
  if (e.target.classList.contains("btn-warning")) {
    // 댓글 하나 가져오기
    // 로그인 사용자와 댓글 작성자가 같은지 확인
    if (userid != login_user) {
      alert("자신의 댓글만 수정이 가능합니다.");
      return;
    }
    fetch("/replies/" + rno)
      .then((response) => {
        if (!response.ok) {
          throw new Error("가져올 댓글 없음");
        }
        return response.json();
      })
      .then((data) => {
        //console.log(data);
        document.querySelector(".modal-body #rno").value = data.rno;
        document.querySelector(".modal-body #replyContent").value = data.replyContent;
        document.querySelector(".modal-body #userid").value = data.userid;
        $("#replyModal").modal("show");
      })
      .catch((error) => console.log(error));
    // 댓글 하나 불러오기 종료

    // 모달 창 안에 가져온 내용 보여주기
  } else if (e.target.classList.contains("btn-danger")) {
    // 로그인 사용자와 댓글 작성자가 같은지 확인
    if (userid != login_user) {
      alert("자신의 댓글만 수정이 가능합니다.");
      return;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // 삭제버튼 클릭 시(delete)
    fetch("/replies/" + rno, {
      method: "delete",
      headers: {
        "content-type": "application/json",
      },
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("삭제 불가");
        }
        return response.text();
      })
      .then((data) => {
        if (data === "success") {
          alert("삭제 성공");
          movieDetailReplyList();
        }
      })
      .catch((error) => console.log(error));
  }
});

///////////////////////////////////////////////////////////////////////////////////////////////////////
// 댓글 수정 작업 (update)
document.querySelector(".modal-footer .btn-primary").addEventListener("click", () => {
  // 모달 창안에 있는 rno, reply 가져온 후 자바스크립트 객체 생성
  rno = document.querySelector(".modal-body #rno").value;
  const updateReply = {
    rno: rno,
    replyContent: document.querySelector(".form-group #replyContent").value,
    userid: document.querySelector(".form-group #userid").value,
  };

  // fetch update 호출
  fetch("/replies/" + rno, {
    method: "put",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(updateReply),
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("수정 실패");
      }
      return response.text();
    })
    .then((data) => {
      //console.log("수정내용", data);
      if (data === "success") {
        $("#replyModal").modal("hide");
        movieDetailReplyList();
      }
    })
    .catch((error) => console.log(error));
});

///////////////////////////////////////////////////////////////////////////////////////////////////////
// 리뷰에 몇시간전에 달았는지 보는 기능을 가진 함수 작성
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

// 위시리스트 버튼을 누르면 확인해서 추가 혹은 이미 있다고 안내
document.querySelector(".follow-btn").addEventListener("click", (e) => {
  e.preventDefault();

  if (userid.trim() === "") {
    // alert("로그인 후 이용이 가능합니다.");
    Swal.fire({
      icon: "warning",
      title: "로그인 필요",
      text: "로그인 후 이용이 가능합니다.",
    });
    return;
  }

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
>>>>>>> refs/remotes/origin/young