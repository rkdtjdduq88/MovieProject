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
<title>Anemy</title>


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
<!-- sweet alert -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.20/dist/sweetalert2.min.css">

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

							<c:if test="${userid == null}">
								<ul>
									<li class="/"><a href="/">Homepage</a></li>
									<li><a href="/categories">Categories <span
											class="arrow_carrot-down"></span></a>
										<ul class="dropdown">
											<li><a href="/categories">Categories</a></li>
											<li><a href="/movie/details/">Anime Details</a></li>
											<li><a href="/anime-watching">Anime Watching</a></li>
											<li><a href="/blog-details">Blog Details</a></li>
											<li><a href="/register">Sign Up</a></li>
											<li><a href="/login">Login</a></li>
										</ul></li>
									<li><a href="/blog">Our Blog</a></li>
									<li><a href="/main-board">Admin Board</a></li>
								</ul>
							</c:if>
							
							<c:if test="${userid != null}">
								<ul>
									<li class="/"><a href="/">Homepage</a></li>
									<li><a href="/categories">Categories <span
											class="arrow_carrot-down"></span></a>
										<ul class="dropdown">
											<li><a href="/categories">Categories</a></li>
											<li><a href="/movie/details/">Anime Details</a></li>
											<li><a href="/anime-watching">Anime Watching</a></li>
											<li><a href="/blog-details">Blog Details</a></li>
											<li><a href="/register">Sign Up</a></li>
											<li><a href="/login">Login</a></li>
										</ul></li>
									<li><a href="/blog">Our Blog</a></li>
									<li><a href="/main-board">Admin Board</a></li>
									<li><a href="/showWish">Wish</a></li>
								</ul>
							</c:if>
							
						</nav>
						
					</div>
				</div>
				<div class="col-lg-2">
					<div class="header__right">
						<a href="#" class="search-switch"><span class="icon_search"></span></a>
						<a href="/login"><span class="icon_profile"></span></a>
					</div>
				</div>
			</div>
			<div id="mobile-menu-wrap"></div>
		</div>
	</header>
	<!-- Header End -->	