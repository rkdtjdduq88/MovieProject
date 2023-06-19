// JSON 데이터를 가져와서 표시하는 함수
async function fetchAndDisplayMovies() {
  var movieListContainer = document.querySelector(".trending__product .row");

  if (!movieListContainer) {
    console.log("영화 목록 컨테이너를 찾을 수 없습니다.");
    return;
  }

  // JSON 데이터를 가져올 API 엔드포인트
  var apiUrl = "http://localhost:8080/api/boxoffice/20230614";

  try {
    // API 요청을 보내고 데이터를 받아옴
    var response = await fetch(apiUrl);
    var data = await response.json();

    // 데이터를 표시할 HTML 문자열
    var movieItems = "";

    // 영화 랭킹을 위한 카운터 변수
    var rank = 1;

    // 반복문을 통해 영화 아이템 생성
    for (var i = 1; i <= 6; i++) {
      var imagePath = `/img/trending/trend-${i}.jpg`;

      // 영화 랭킹 아이템을 생성하여 문자열에 추가
      var movieItem = `
        <div class="col-lg-4 col-md-6 col-sm-6">
            <div class="product__item">
                <div class="product__item__pic set-bg" style="background-image: url('${imagePath}')">
                    <div class="ep">${rank}위</div>
                    <div class="comment"><i class="fa fa-comments"></i> 11</div>
                    <div class="view"><i class="fa fa-eye"></i> 9141</div>
                </div>
                <div class="product__item__text">
                    <ul>
                        <li>활동중</li>
                        <li>영화</li>
                    </ul>
                    <h5><a href="#">${data[rank-1].movieNm}</a></h5>
                </div>
            </div>
        </div>
      `;

      movieItems += movieItem;

      // 랭킹 카운터 증가
      rank++;
    }

    // 영화 목록 컨테이너에 movieItems를 할당하여 표시
    movieListContainer.innerHTML = movieItems;
  } catch (error) {
    console.log("데이터를 가져오는 중 오류가 발생했습니다:", error);
  }
}

// 페이지 로드 시 영화 목록 표시
document.addEventListener("DOMContentLoaded", fetchAndDisplayMovies);
