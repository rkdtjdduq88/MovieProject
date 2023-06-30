<%@include file="./include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.HttpURLConnection, java.net.URL, java.io.BufferedReader, java.io.InputStreamReader" %>



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
						<a href="#" class="facebook"><i class="fa fa-facebook-square"></i>
							Facebook</a> <a href="#" class="pinterest"><i
							class="fa fa-pinterest"></i> Pinterest</a> <a href="#"
							class="linkedin"><i class="fa fa-linkedin-square"></i>
							Linkedin</a> <a href="#" class="twitter"><i
							class="fa fa-twitter-square"></i> Twitter</a>
					</div>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="blog__details__pic">
					<img src="https://api.dicebear.com/6.x/bottts-neutral/svg" alt="">
				</div>
			</div>
			<div class="col-lg-8">
				<div class="blog__details__content">
					<div class="blog__details__text">
						<p>${boardDto.content}</p>
					</div>
					<div class="blog__details__item__text">
						<h4>Tobio-Nishinoya showdown:</h4>
						<img src="/img/blog/details/bd-item-1.jpg" alt="">
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
										<a href="#"><span class="arrow_left"></span> Building a
											Better LiA...</a>
									</h5>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="blog__details__btns__item next__btn">
									<h5>
										<a href="#">Mugen no Juunin: Immortal â 21 <span
											class="arrow_right"></span></a>
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

</body>
</html>
