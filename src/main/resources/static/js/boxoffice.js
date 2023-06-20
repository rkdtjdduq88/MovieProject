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

<<<<<<< HEAD
    // 영화 랭킹을 위한 카운터 변수
    var rank = 1;
=======
      // 데이터를 테이블에 표시
      data.forEach(function (movie) {
        // 영화 랭킹 아이템을 생성하여 문자열에 추가
        var movieItem = `
          <div class="col-lg-4 col-md-6 col-sm-6">
              <div class="product__item">
                  <div class="product__item__pic set-bg" data-setbg="img/trending/trend-1.jpg" style="background-image: url('img/trending/trend-1.jpg')">
                      <div class="ep">${rank}위</div>
                      <div class="comment"><i class="fa fa-comments"></i> 11</div>
                      <div class="view"><i class="fa fa-eye"></i> 9141</div>
                  </div>
                  <div class="product__item__text">
                      <ul>
                          <li>활동중</li>
                          <li>영화</li>
                      </ul>
                      <h5><a href="#">${movie.movieNm}</a></h5>
                  </div>
              </div>
          </div>
        `;
        movieItems += movieItem;
>>>>>>> refs/heads/kang

    // 반복문을 통해 영화 아이템 생성
    for (var i = 1; i <= 6; i++) {
      var imagePath = `/img/trending/trend-${i}.jpg`;

<<<<<<< HEAD
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
=======
    // 데이터를 테이블에 표시
    data.forEach(function (movie) {
      // 영화 포스터 URL을 가져오기 위한 TMDB API 요청
      var tmdbApiUrl = "https://api.themoviedb.org/3/search/movie";
      var apiKey = "6461fff89d9af7c612e73b1e1146ff50";
      var query = movie.movieNm; // 영화 제목을 기준으로 검색

      var tmdbUrl = `${tmdbApiUrl}?api_key=${apiKey}&query=${query}`;

      var promise = fetch(tmdbUrl)
        .then(function (response) {
          return response.json();
        })
        .then(function (tmdbData) {
          // 가져온 TMDB 데이터에서 첫 번째 영화의 포스터 URL을 가져옴
          var posterUrl = "";
          if (
            tmdbData.results &&
            tmdbData.results.length > 0 &&
            tmdbData.results[0].poster_path
          ) {
            posterUrl = tmdbData.results[0].poster_path;
          } else {
            // 포스터 URL이 없을 경우 기본값 설정
            posterUrl = "기본 포스터 이미지 URL";
          }

          // 영화 랭킹 아이템을 생성하여 문자열에 추가
          var movieItem = `
            <div class="col-lg-4 col-md-6 col-sm-6">
                <div class="product__item">
                    <div class="product__item__pic set-bg" data-setbg="">
                        <div class="ep">${rank}위</div>
                        <div class="comment"><i class="fa fa-comments"></i> 11</div>
                        <div class="view"><i class="fa fa-eye"></i> 9141</div>
                    </div>
                    <div class="product__item__text">
                        <ul>
                            <li>상영중</li>
                            <li>영화</li>
                        </ul>
                        <h5><a href="#">${movie.movieNm}</a></h5>
                    </div>
>>>>>>> refs/heads/Sue
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

////////////////////////////////////////////////////////////////////////
// 캐러셀 api
function fetchAndCarouselMovies() {
  var carouselMovie = document.querySelector(".container .hero__slider");
  if (!carouselMovie) {
    console.log("캐러셀 목록을 찾을 수 없습니다.");
    return;
  }
  var apiCarouselUrl = "http://localhost:8080/api/boxoffice/carousel/20230614";
  // API 요청을 보내고 데이터를 받아옴
  fetch(apiCarouselUrl)
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      //console.log(data);
      var carouselMovielItems = "";
      data.forEach((movie) => {
        var carouselMovielItem = `
        <div class="hero__items set-bg" data-setbg="/img/hero/hero-1.jpg" style="background-image: url('/img/hero/hero-1.jpg')">
          <div class="row">        
            <div class="col-lg-6">
              <div class="hero__text">
                <div class="label">${movie.openDt}</div>
                <h2>${movie.movieNm}</h2>
                <p>${movie.rank}</p>
                <a href="#"><span>Watch Now</span> <i
                  class="fa fa-angle-right"></i></a>
              </div>
            </div>  
          </div> 
        </div>     
      `;
        carouselMovielItems += carouselMovielItem;
      });
      console.log(carouselMovielItems);
      carouselMovie.insertAdjacentHTML("afterbegin", carouselMovielItems);

      /*------------------
          Hero Slider
        --------------------*/
      var hero_s = $(".hero__slider");
      hero_s.owlCarousel({
        loop: true,
        margin: 0,
        items: 1,
        dots: true,
        nav: true,
        navText: ["<span class='arrow_carrot-left'></span>", "<span class='arrow_carrot-right'></span>"],
        animateOut: "fadeOut",
        animateIn: "fadeIn",
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        mouseDrag: false,
      });

      hero_s.trigger("refresh.owl.carousel");

      // carouselMovie.innerHTML = carouselMovielItems;
    })
    .catch((error) => console.log("데이터 오류가 발생하였습니다", error));
}

fetchAndCarouselMovies();

//document.addEventListener("DOMContentLoaded", fetchAndCarouselMovies);
