// JSON 데이터를 가져와서 표시하는 함수
function fetchAndDisplayMovies() {
  var movieTableBody = document.querySelector("#movie-table tbody");

  // JSON 데이터를 가져올 API 엔드포인트
  var apiUrl = "http://localhost:8080/api/boxoffice/20230614";

  // API 요청을 보내고 데이터를 받아옴
  fetch(apiUrl)
    .then(function (response) {
      return response.json();
    })
    .then(function (data) {
      // 데이터를 테이블에 표시
      data.forEach(function (movie) {
        var row = document.createElement("tr");

        var titleCell = document.createElement("td");
        titleCell.textContent = movie.movieNm;

        var releaseDateCell = document.createElement("td");
        releaseDateCell.textContent = movie.openDt;

        var salesAmtCell = document.createElement("td");
        salesAmtCell.textContent = movie.salesAmt;

        var audiCntCell = document.createElement("td");
        audiCntCell.textContent = movie.audiCnt;

        row.appendChild(titleCell);
        row.appendChild(releaseDateCell);
        row.appendChild(salesAmtCell);
        row.appendChild(audiCntCell);

        movieTableBody.appendChild(row);
      });
    })
    .catch(function (error) {
      console.log("데이터를 가져오는 중 오류가 발생했습니다:", error);
    });
}

// 페이지 로드 시 영화 목록 표시
document.addEventListener("DOMContentLoaded", fetchAndDisplayMovies);
