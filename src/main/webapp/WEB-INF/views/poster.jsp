<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.4.js"
	integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
	crossorigin="anonymous"> // 제이쿼리 사용 가능
</script>
</head>
<body>
<div id="ranking">
<div id="dynamicDiv">
<script>
  var moviecount = 10;
  // 순위 개수 출력하기 최대 10까지 가능

  var dateword;

  var today = new Date();
  var yesterday = new Date();
  yesterday.setDate(today.getDate() - 1);
  // 하루 전 날짜 출력

  var year = yesterday.getFullYear().toString(); // 현재 연도
  var month = (yesterday.getMonth() + 1).toString(); // 현재 월
  var date = yesterday.getDate().toString(); // 현재 일
  //string 값에 맞게 전부 변경

  if ((date.length == 1)) date = '0' + date;
  if ((month.length == 1)) month = '0' + month;
  dateword = year.toString() + month.toString() + date.toString();
  //YYYYMMDD 형식이기 때문에 월, 일이 한자릿수인 경우 앞에 0을 붙여준다.

  // 사용 용이하게 tempRow를 div 요소로 생성
  var tempRow = document.createElement("div");

  // tempRow에 오늘 날짜값을 넣어 맨 위에 출력하도록 한다.
  tempRow.innerHTML += '<div><br> ' + year + '-' + month + '-' + date + 
  '일 기준 박스오피스 순위<br><br></div>';
  dynamicDiv.appendChild(tempRow);

  fetch(
		  'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=7083241ea008894c70a0978fe6fbc95c' +
		    dateword
		)
		  .then(function (response) {
		    if (response.ok) {
		      return response.json();
		    } else {
		      throw new Error('Error: ' + response.status);
		    }
		  })
		  .then(function (result) {
		    var movieList = result.boxOfficeResult.dailyBoxOfficeList;

		    for (var i = 0; i < moviecount; i++) {
		      var movieopenday = movieList[i].openDt.replaceAll('-', '');

		      fetch(
		        'http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?' +
		          'collection=kmdb_new2&ServiceKey=8HPI107SND9Z42R0OM7H' +
		          '&sort=prodYear,1&releaseDts=' +
		          movieopenday +
		          '&detail=Y&query=' +
		          movieList[i].movieNm,
		        {
		          method: 'GET',
		          headers: {
		            'Content-Type': 'application/json',
		          },
		        }
		      )
		        .then(function (response) {
		          if (response.ok) {
		            return response.json();
		          } else {
		            throw new Error('Error: ' + response.status);
		          }
		        })
		        .then(function (jsonData) {
		          var tempString = jsonData.Data[0].Result[0].posters;
		          var posterurl = tempString.split('|');

		          // 여기에 포스터가 없을 경우 예외처리 추가하기

		          document.querySelector('#dynamicDiv').insertAdjacentHTML(
		            'beforeend',
		            "<div><img src='" + posterurl[0] + "'/></div><br>"
		          );
		        })
		        .catch(function (error) {
		          console.log('Error:', error);
		        });

		      document.querySelector('#dynamicDiv').insertAdjacentHTML(
		        'beforeend',
		        '<div>' + (i + 1) + '위</div><br><div>' + movieList[i].movieNm + '</div><br>'
		      );
		      document.querySelector('#dynamicDiv').insertAdjacentHTML(
		        'beforeend',
		        '<div>' + '누적 관객수 : ' + movieList[i].audiAcc + ' 명 </div><br>'
		      );
		    }
		  })
		  .catch(function (error) {
		    console.log('Error:', error);
		  });
</script>
</div>
</div>
<script src="/js/boxoffice.js">
</body>
</html>