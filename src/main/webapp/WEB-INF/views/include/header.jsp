<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link
	href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

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
<link rel="stylesheet" href="/css/myPage.css" type="text/css">

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

function logout() {
    fetch('/logout', { method: 'POST' })
        .then(response => {
            if (response.ok) {
                // 로그아웃 성공 시 처리할 내용 작성
                window.location.href = '/'; // 로그아웃 후 리다이렉트할 페이지
            }
        })
        .catch(error => {
            console.error('로그아웃 실패:', error);
        });
}

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
								<li><a href="/categories">Categories <span
										class="arrow_carrot-down"></span></a>
									<ul class="dropdown">
										<li><a href="/categories">Categories</a></li>
										<li><a href="/movie/details/">Anime Details</a></li>
										<li><a href="/anime-watching">Anime Watching</a></li>
										<li><a href="/blog-details">Blog Details</a></li>
										<c:if test="${empty sessionScope.userid}">
										    <li><a href="/register">Sign Up</a></li>
										    <li><a href="/login">Login</a></li>
										</c:if>
									</ul></li>
								<li><a href="/blog">Our Blog</a></li>
								<li><a href="#">Contacts</a></li>
							</ul>
						</nav>
					</div>
				</div>
				<div class="col-lg-2">
					<div class="header__right">
					    <a href="#" class="search-switch"><span class="icon_search"></span></a>
					    
					    <% if (session.getAttribute("userid") != null) { %>
					        <a href="#" class="profile-switch" onclick="toggleDropdown()">
					            <span class="icon_profile"></span>
					            <ul id="dropdownMenu" class="dropdown2">
					                <li><a href="/myPage">My Page</a></li>
					                <li><a href="#" onclick="logout()">Logout</a></li>
					            </ul>
					        </a>
					    <% } else { %>
					        <a href="/login"><span class="icon_profile"></span></a>
					    <% } %>
					</div>
				</div>
			</div>
			<div id="mobile-menu-wrap"></div>
		</div>
	</header>
	<!-- Header End -->	