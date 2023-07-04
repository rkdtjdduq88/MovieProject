let str = "";
let url = "";
let video = "";
function searchParam(name) {
  return new URLSearchParams(location.search).get(name);
}
const movie = searchParam("movieNm");
console.log(movie);

locData();

const mwatch = document.querySelector(".mwatch");

function locData() {
  url = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&q=" + movie + "teaser&type=video&key=AIzaSyBMh5jfdhATVG6lN_4ZoKULT42PWK_I9Lg";

  fetch(url)
    .then((response) => {
      if (!response.ok) {
        throw new Error("영상 찾기 실패");
      }
      return response.json();
    })
    .then((data) => {
      console.log(data);
      video = data.items[0].id.videoId;
      str += '<a href="https://www.youtube.com/embed/' + video + '" class="watch-btn">';
      str += '<span>Watch Now</span><i class="fa fa-angle-right"></i></a>';

      mwatch.innerHTML = str;
    })
    .catch((error) => console.log(error));
}
