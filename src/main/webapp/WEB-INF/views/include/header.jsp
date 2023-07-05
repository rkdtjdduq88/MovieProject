<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Anime Template">
<meta name="keywords" content="Anime, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Anime | Template</title>


<!-- Google Font -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />   

<!-- Google Font -->   

<link
	href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">
<!-- Bootstrap core JavaScript-->
<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Css Styles -->
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="/css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="/css/plyr.css" type="text/css">
<link rel="stylesheet" href="/css/nice-select.css" type="text/css">
<link rel="stylesheet" href="/css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="/css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="/css/style.css" type="text/css">
<link rel="stylesheet" href="/css/agree.css" type="text/css">
<link rel="stylesheet" href="/css/moviedetail.css" type="text/css">
<link rel="stylesheet" href="/css/myPage.css" type="text/css">
<link rel="stylesheet" href="/css/findPassword.css" type="text/css">
<!-- <link rel="stylesheet" href="/css/wishList.css" type="text/css"> -->

<!-- sweet alert -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.20/dist/sweetalert2.min.css">

<style>
.dropdown2 {
    display: none;
}

.dropdown2.show {
    display: block;
}
</style>

<script>
function toggleDropdown() {
    var dropdownMenu = document.getElementById("dropdownMenu");
    dropdownMenu.classList.toggle("show");
}

document.addEventListener("click", function(event) {
    var dropdownMenu = document.getElementById("dropdownMenu");
    if (!event.target.closest(".profile-switch") && dropdownMenu.classList.contains("show")) {
        dropdownMenu.classList.remove("show");
    }
});


</script>
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
						<a href="/"> <img src="/img/logo.png" alt="">
						</a>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="header__nav">
						<nav class="header__menu mobile-menu">
									<ul>
										<li class="/"><a href="/">Homepage</a></li>
										<li><a href="/blog">Our Blog</a></li>
								<security:authorize access="isAuthenticated()">
										<security:authorize access="hasRole('ROLE_ADMIN')">
											<li><a href="/main-board">Admin Board</a></li>
										</security:authorize>
										<li><a href="/showWish">Wish</a></li>
								</security:authorize>
									</ul>
															
						</nav>
						
					</div>
				</div>
				<div class="col-lg-2">
					<div class="header__right">
						 <a href="#" class="search-switch"><span class="icon_search"></span></a>
						<security:authorize access="isAuthenticated()">
						    <a href="#" class="profile-switch" onclick="toggleDropdown()">
						        <span class="icon_profile"></span>
						        <ul id="dropdownMenu" class="dropdown2">
						            <li><a href="/mypage">My Page</a></li>
						            <li>
						               <form action="/logout" method="post" id="logoutForm2">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
										<button type="submit">Logout</button>
										</form>
						            </li>
						        </ul>
						    </a>
						</security:authorize>
						
						<security:authorize access="!isAuthenticated()">
						    <a href="/login"><span class="icon_profile"></span></a>
						</security:authorize>
					</div>
				</div>
			</div>
			<div id="mobile-menu-wrap"></div>
		</div>
	</header>
	<!-- Header End -->	