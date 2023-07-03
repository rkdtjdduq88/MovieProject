<%@include file="./include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.HttpURLConnection, java.net.URL, java.io.BufferedReader, java.io.InputStreamReader" %>

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<!-- Blog Details Section Begin -->
<section class="blog-details spad">
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="col-lg-8">
				<div class="blog__details__title">
					<h6>
						Action, Magic <span>- March 08, 2020</span>
					</h6>
					<h2>${boardDto.title}</h2>
					
					<div class="blog__details__social">
					<a id="clip-btn" href="javascript:clipboardShare()">
      <img src="https://cdn.icon-icons.com/icons2/2551/PNG/512/clipboard_check_icon_152889.png" width="85" height="85" />
</a>
							  <a id="kakao-link-btn" href="javascript:kakaoShare()">
    	<img src="https://developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png" />
    </a><a href="#" class="facebook-share" onclick="shareFacebook()">
    <img src="https://cdn-icons-png.flaticon.com/512/3536/3536394.png" width="73" height="73" >
</a>

					</div>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="blog__details__pic">
					<img src="" alt="">
				</div>
			</div>
			<div class="col-lg-8">
				<div class="blog__details__content">
					<div class="blog__details__text">
						<p>${boardDto.content}</p>
					</div>
					<div class="blog__details__item__text">
						<h4></h4>
						<img src="" alt="">
						<p></p>
					</div>

					<div class="blog__details__tags">
						<a href="#">Healthfood</a> <a href="#">Sport</a> <a href="#">Game</a>
					</div>
					<div class="blog__details__btns">
						<div class="row">
							<div class="col-lg-6">
    <div class="blog__details__btns__item">
        <h5>
            <c:if test="${previousPost ne null}">
                <a href="/blog-details/${previousPost.bno}">
                    <span class="arrow_left"></span> ${previousPost.title}
                </a>
            </c:if>
            <c:if test="${previousPost eq null}">
                <span class="disabled">이전 포스트가 없습니다</span>
            </c:if>
        </h5>
    </div>
</div>
<div class="col-lg-6">
    <div class="blog__details__btns__item next__btn">
        <h5>
            <c:if test="${nextPost ne null}">
                <a href="/blog-details/${nextPost.bno}">
                    ${nextPost.title} <span class="arrow_right"></span>
                </a>
            </c:if>
            <c:if test="${nextPost eq null}">
                <span class="disabled">마지막 포스트입니다</span>
            </c:if>
        </h5>
    </div>
</div>

						</div>
					</div>
				</div>
			<div id="commentsContainer" class="blog__details__comment">
    <c:set var="currentTime" value="<%=new java.util.Date().getTime()%>" />

    <c:forEach var="comment" items="${comments}">
        <div class="blog__details__comment__item">
			           <div class="blog__details__comment__item__pic">
			    <img src="https://avatars.dicebear.com/api/bottts/${comment.userid}.jpg" alt="img" style="width: 80px; height: 80px; border-radius: 50%;">
			</div>
            <div class="blog__details__comment__item__text">
                <c:set var="commentTime" value="${comment.replyDate.time}" />
                <c:set var="isSameDay" value="${(currentTime - commentTime) < (24 * 60 * 60 * 1000)}" />
                <span>
                    <c:choose>
                        <c:when test="${isSameDay}">
                            ${fn:substring(comment.replyDate, 11, 19)}
                        </c:when>
                        <c:otherwise>
                            ${fn:substring(comment.replyDate, 0, 10)}
                        </c:otherwise>
                    </c:choose>
                </span>
                <h5 class="comment-userid">${comment.userid}</h5>
                <p class="comment-content">${comment.replyContent}</p>
                <c:if test="${comment.userid eq loggedInUser}">
                    <button type="button" data-rno="${comment.rno}" class="btn btn-primary edit-btn">수정</button>
                    <button type="button" data-rno="${comment.rno}" class="btn btn-confirm update-btn" style="display: none;">확인</button>
                    <button type="button" data-rno="${comment.rno}" class="btn btn-danger delete-btn">삭제</button>
                </c:if>
                <!-- Reply form -->
                <div class="blog__details__comment__reply__form" style="display: none;">
                    <form action="/blog-details/${boardDto.bno}/reply" method="post">
                        <div class="row">
                            <div class="col-lg-12">
                                <textarea name="replyContent" rows="5" style="width: 100%;"></textarea>
                                <input type="hidden" name="bno" value="${boardDto.bno}" />
                                <input type="hidden" name="userid" value="${reply.userid}" />
                                <button type="submit" class="site-btn">답글 작성</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<div class="blog__details__form">
    <!-- Add comment form -->
    <form id="commentForm" action="/blog-details/${boardDto.bno}/comment" method="post">
        <div class="row">
            <div class="col-lg-12">
                <textarea id="commentContent" name="replyContent" rows="5" style="width: 100%;"></textarea>
                <input type="hidden" name="bno" value="${boardDto.bno}" />
                <button type="submit" class="site-btn">댓글 작성</button>
            </div>
        </div>
    </form>
    <!-- Add comment form end -->
</div>


			</div>
		</div>
	</div>
</section>
<!-- Blog Details Section End -->

<%@include file="./include/footer.jsp"%>

<!-- Search model Begin -->
<div class="search-model">
	<div class="h-100 d-flex align-items-center justify-content-center">
		<div class="search-close-switch">
			<i class="icon_close"></i>
		</div>
		<form class="search-model-form">
			<input type="text" id="search-input" placeholder="Search here.....">
		</form>
	</div>
</div>
<!-- Search model end -->

<form action="" id="operForm">
	<input type="hidden" name="bno" value="${read.bno}" />
</form>
<!-- kakao sdk 호출 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
const loggedInUser = "${loggedInUser}";
	//게시물 글번호 가져오
	const bno = ${boardDto.bno};

</script>
<!-- 스크립트 태그 내의 코드 수정 -->


<!-- Js Plugins -->

<script src="/js/bootstrap.min.js"></script>
<script src="/js/player.js"></script>
<script src="/js/jquery.nice-select.min.js"></script>
<script src="/js/mixitup.min.js"></script>
<script src="/js/jquery.slicknav.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/reply.js"></script>
<script src="/js/main.js"></script>
<script type="text/javascript">
  // SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.
  Kakao.init('890eeace03d702aa8dab7f47b73c5c42');

  // SDK 초기화 여부를 판단합니다.
  console.log(Kakao.isInitialized());

  function kakaoShare() {
    Kakao.Link.sendDefault({
      objectType: 'feed',
      content: {
        title: '카카오공유하기 시 타이틀',
        description: '카카오공유하기 시 설명',
        imageUrl: '카카오공유하기 시 썸네일 이미지 경로',
        link: {
          mobileWebUrl: '카카오공유하기 시 클릭 후 이동 경로',
          webUrl: '카카오공유하기 시 클릭 후 이동 경로',
        },
      },
      buttons: [
        {
          title: '웹으로 보기',
          link: {
            mobileWebUrl: '카카오공유하기 시 클릭 후 이동 경로',
            webUrl: '카카오공유하기 시 클릭 후 이동 경로',
          },
        },
      ],
      // 카카오톡 미설치 시 카카오톡 설치 경로이동
      installTalk: true,
    })
  }
  
  function shareFacebook() {
      var url = encodeURIComponent(window.location.href);
      var facebookShareUrl = 'https://www.facebook.com/sharer/sharer.php?u=' + url;

      window.open(facebookShareUrl, '_blank');
  }
//클립보드 복사하기
	function clipboardShare() {
  	    // 1. 새로운 element 생성
  	    var tmpTextarea = document.createElement('textarea');
          
          // 2. 해당 element에 복사하고자 하는 value 저장
          tmpTextarea.value = "복사하고픈 value";
          
          // 3. 해당 element를 화면에 안보이는 곳에 위치
          tmpTextarea.setAttribute('readonly', '');
          tmpTextarea.style.position = 'absolute';
          tmpTextarea.style.left = '-9999px';
          document.body.appendChild(tmpTextarea);
          
          // 4. 해당 element의 value를 시스템 함수를 호출하여 복사
          tmpTextarea.select();
          tmpTextarea.setSelectionRange(0, 9999);  // 셀렉트 범위 설정
          var successChk = document.execCommand('copy');
          
          // 5. 해당 element 삭제
          document.body.removeChild(tmpTextarea);
          
          // 클립보드 성공여부 확인
          if(!successChk){
          	alert("클립보드 복사에 실패하였습니다.");
          } else {
          	alert("클립보드에 복사가 완료되었습니다.");
          }
     }
</script>
</body>
</html>
