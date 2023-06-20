document.addEventListener("DOMContentLoaded", function () {
  const movieRankList = document.getElementById("movieRankList");

  if (movieRankList) {
    fetch("http://localhost:8080/api/popularMovies")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not OK");
        }
        return response.json();
      })
      .then((data) => {
        if (!Array.isArray(data) || data.length === 0) {
          throw new Error("Invalid response data");
        }

        // 한글 제목으로 받아온 영화 목록을 표시하는 부분
        data.forEach((movie) => {
          const listItem = document.createElement("li");
          listItem.textContent = movie.koreanTitle;
          movieRankList.appendChild(listItem);
        });
      })
      .catch((error) => {
        console.error("Error fetching movie data:", error);
      });
  } else {
    console.error("movieRankList element not found in the DOM");
  }
});
