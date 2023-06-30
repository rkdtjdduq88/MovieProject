<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

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

<!-- Normal Breadcrumb Begin -->
<section class="normal-breadcrumb set-bg"
	data-setbg="img/normal-breadcrumb.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="normal__breadcrumb__text">
					<h2>Our Blog</h2>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Normal Breadcrumb End -->
<!-- Blog Section Begin -->
<section class="blog spad">
	<div class="container">
		<div class="row">
			<c:forEach var="board" items="${boardList}">
				<div class="col-lg-6">
					<div class="row">
						<div class="col-lg-12">
							<div class="blog__item set-bg"
								data-setbg="/img/${board.attach}.jpg">
								<div class="blog__item__text">
									<p>
										<span class="icon_calendar"></span>
										<fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd" />
									</p>

									<h4>
										<a href="/blog-details/${board.bno}">${board.title}</a>
									</h4>

								</div>
							</div>
						</div>
						<!-- Repeat the above structure for other blog items -->
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
<!--Pagenation begin  -->
<div class="pagination">
	<c:if test="${currentPage > 1}">
		<a href="/blog?page=${currentPage - 1}">Previous</a>
	</c:if>
	<c:forEach var="pageNumber" begin="1" end="${totalPages}">
		<c:choose>
			<c:when test="${pageNumber == currentPage}">
				<a class="active" href="/blog?page=${pageNumber}">${pageNumber}</a>
			</c:when>
			<c:otherwise>
				<a href="/blog?page=${pageNumber}">${pageNumber}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${currentPage < totalPages}">
		<a href="/blog?page=${currentPage + 1}">Next</a>
	</c:if>
</div>
<!--Pagenation end-->
</section>
<!-- Blog Section End -->


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

<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/player.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>

</body>

<%@ include file="include/footer.jsp" %>



</html>