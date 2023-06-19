// JSON 데이터를 가져와서 표시하는 함수
function fetchAndDisplayMovies() {
  var movieListContainer = document.querySelector(".trending__product .row");

  if (!movieListContainer) {
    console.log("영화 목록 컨테이너를 찾을 수 없습니다.");
    return;
  }

  // JSON 데이터를 가져올 API 엔드포인트
  var apiUrl = "http://localhost:8080/api/boxoffice/20230614";

  // API 요청을 보내고 데이터를 받아옴
  fetch(apiUrl)
    .then(function (response) {
      return response.json();
    })
    .then(function (data) {
      // 데이터를 표시할 HTML 문자열
      var movieItems = "";

      // 영화 랭킹을 위한 카운터 변수
      var rank = 1;

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

        // 랭킹 카운터 증가
        rank++;

        // 상위 10개 영화만 표시하도록 제한
        if (rank > 10) {
          return;
        }
      });

      // 영화 랭킹 아이템들을 movie-list-container에 추가
      movieListContainer.innerHTML = movieItems;
    })
    .catch(function (error) {
      console.log("데이터를 가져오는 중 오류가 발생했습니다:", error);
    });
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
