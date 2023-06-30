<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html lang="en">

<meta charset="UTF-8">
    <meta name="description" content="Anime Template">
    <meta name="keywords" content="Anime, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Anime | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/plyr.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
    <header class="header">
        <div class="container">
            <div class="row">
                <div class="col-lg-2">
                    <div class="header__logo">
                        <a href="/">
                            <img src="img/logo.png" alt="">
                        </a>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="header__nav">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li><a href="/">Homepage</a></li>
                                <li><a href="./categories.html">Categories <span class="arrow_carrot-down"></span></a>
                                    <ul class="dropdown">
                                        <li><a href="./categories.html">Categories</a></li>
                                        <li><a href="/details">Movie Details</a></li>
                                        <li><a href="./anime-watching.html">Anime Watching</a></li>
                                        <li><a href="./blog-details.html">Blog Details</a></li>
                                        
                                        <security:authorize access="!isAuthenticated()">
										<li><a href="/login">Login</a></li>
										<li><a href="/login-register">Register</a></li>
										</security:authorize>

										<security:authorize access="isAuthenticated()">
											<li><a href="/logout">
												<input type="hidden" name="${_csrf.parameterName}"
													value="${_csrf.token}" />Logout
												</a>
											</li>
											<li><a href="/changePwd">Change Information</a></li>
											<li><a href="/leave">Withdrawal</a></li>
											</li>
										</security:authorize>
									</ul>
                                </li>
                                <li><a href="blog">Our Blog</a></li>
                                
                                <security:authorize access="hasRole('ROLE_ADMIN')">
									<li><a href="main-board">Admin Board</a></li>
								</security:authorize>
								 </ul>
                        </nav>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="header__right">
                        <a href="#" class="search-switch"><span class="icon_search"></span></a>
                        <a href="./login"><span class="icon_profile"></span></a>
                    </div>
                </div>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->
    
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
                    <img src="/img/blog/details/blog-details-pic.jpg" alt="">
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
             
                <div class="blog__details__comment">
                    <h4>${comments.size()} Comments</h4>
                    <c:forEach var="comment" items="${comments}">
                        <div class="blog__details__comment__item">
                            <div class="blog__details__comment__item__pic">
                                <img src="/img/blog/details/comment-1.png" alt="">
                            </div>
                            <div class="blog__details__comment__item__text">
                                <span>${comment.replyDate}</span>
                                <h5>${comment.userid}</h5>
                                <p>${comment.replyContent}</p>
                                <a href="#" class="reply-btn" data-rno="${comment.rno}">Reply</a> <!-- Add data-rno attribute -->
                            </div>
                
                            <!-- Reply form -->
                            <div class="blog__details__comment__reply__form" style="display: none;">
                                <form action="/blog-details/${boardDto.bno}/reply" method="post">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <textarea name="replyContent" rows="5" style="width: 100%;"></textarea>
                                            <input type="hidden" name="bno" value="${boardDto.bno}" />
                                            <input type="hidden" name="rno" value="${comment.rno}" />
                                            <button type="submit" class="site-btn">답글 작성</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- Reply form end -->
                        </div>
                    </c:forEach>
                </div>

                <div class="blog__details__form">
                    <!-- Add comment form -->
                    <form action="/blog-details/${boardDto.bno}/comment" method="post">
                        <div class="row">
                            <div class="col-lg-12">
                                <textarea name="replyContent" rows="5" style="width: 100%;"></textarea>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    //게시물 글번호 가져오기
    const bno = ${boardDto.bno};
</script>
<!-- 스크립트 태그 내의 코드 수정 -->


<!-- Js Plugins -->
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/player.js"></script>
<script src="/js/jquery.nice-select.min.js"></script>    
<script src="/js/mixitup.min.js"></script>
<script src="/js/jquery.slicknav.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/main.js"></script>
<script src="/js/reply.js"></script>

</body>
</html>