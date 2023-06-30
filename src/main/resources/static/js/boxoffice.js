// document.addEventListener("DOMContentLoaded", function () {
//   const movieRankList = document.getElementById("movieRankList");

//   if (movieRankList) {
//     fetch("http://localhost:8080/api/popularMovies")
//       .then((response) => {
//         if (!response.ok) {
//           throw new Error("Network response was not OK");
//         }
//         return response.json();
//       })
//       .then((data) => {
//       console.log(data);
//         if (!Array.isArray(data) || data.length === 0) {
//           throw new Error("Invalid response data");
//         }
//       })
//       .catch((error) => {
//         console.error("Error fetching movie data:", error);
//       });
//   } else {
//     console.error("movieRankList element not found in the DOM");
//   }
// });
