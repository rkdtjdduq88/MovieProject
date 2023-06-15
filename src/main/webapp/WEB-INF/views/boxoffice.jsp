<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
						<a href="./index.html"> <img src="/img/logo.png" alt="">
						</a>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="header__nav">
						<nav class="header__menu mobile-menu">
							<ul>
								<li class="active"><a href="./index.html">Homepage</a></li>
								<li><a href="./categories.html">Categories <span
										class="arrow_carrot-down"></span></a>
									<ul class="dropdown">
										<li><a href="./categories.html">Categories</a></li>
										<li><a href="./anime-details.html">Anime Details</a></li>
										<li><a href="./anime-watching.html">Anime Watching</a></li>
										<li><a href="./blog-details.html">Blog Details</a></li>
										<li><a href="./signup.html">Sign Up</a></li>
										<li><a href="./login.html">Login</a></li>
									</ul></li>
								<li><a href="./blog.html">Our Blog</a></li>
								<li><a href="#">Contacts</a></li>
							</ul>
						</nav>
					</div>
				</div>
				<div class="col-lg-2">
					<div class="header__right">
						<a href="#" class="search-switch"><span class="icon_search"></span></a>
						<a href="./login.html"><span class="icon_profile"></span></a>
					</div>
				</div>
			</div>
			<div id="mobile-menu-wrap"></div>
		</div>
	</header>
	<!-- Header End -->

	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="hero__slider owl-carousel">
				<div class="hero__items set-bg" data-setbg="/img/hero/hero-1.jpg">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">Adventure</div>
								<h2>Fate / Stay Night: Unlimited Blade Works</h2>
								<p>After 30 days of travel across the world...</p>
								<a href="#"><span>Watch Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="hero__items set-bg" data-setbg="/img/hero/hero-1.jpg">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">Adventure</div>
								<h2>Fate / Stay Night: Unlimited Blade Works</h2>
								<p>After 30 days of travel across the world...</p>
								<a href="#"><span>Watch Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="hero__items set-bg" data-setbg="/img/hero/hero-1.jpg">
					<div class="row">
						<div class="col-lg-6">
							<div class="hero__text">
								<div class="label">Adventure</div>
								<h2>Fate / Stay Night: Unlimited Blade Works</h2>
								<p>After 30 days of travel across the world...</p>
								<a href="#"><span>Watch Now</span> <i
									class="fa fa-angle-right"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<!-- Movie Section Begin -->
	<section class="movies">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title">
						<h2>영화 목록</h2>
					</div>
				</div>
			</div>
			<div class="row" id="movie-list-container">
				<div class="col-lg-12">
					<div class="movie-list">
						<table id="movie-table">
							<thead>
								<tr>
									<th>영화 제목</th>
									<th>개봉일</th>
									<th>매출액</th>
									<th>관객 수</th>
								</tr>
							</thead>
							<tbody>
								<!-- 영화 목록은 JavaScript로 동적으로 생성됩니다 -->
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Movie Section End -->

	<div class="col-lg-4 col-md-6 col-sm-8">
		<div class="product__sidebar">
			<div class="product__sidebar__view">
				<div class="section-title">
					<h5>Top Views</h5>
				</div>
				<ul class="filter__controls">
					<li class="active" data-filter="*">Day</li>
					<li data-filter=".week">Week</li>
					<li data-filter=".month">Month</li>
					<li data-filter=".years">Years</li>
				</ul>
				<div class="filter__gallery">
					<div class="product__sidebar__view__item set-bg mix day years"
						data-setbg="/img/sidebar/tv-1.jpg">
						<div class="ep">18 / ?</div>
						<div class="view">
							<i class="fa fa-eye"></i> 9141
						</div>
						<h5>
							<a href="#">Boruto: Naruto next generations</a>
						</h5>
					</div>
					<div class="product__sidebar__view__item set-bg mix month week"
						data-setbg="/img/sidebar/tv-2.jpg">
						<div class="ep">18 / ?</div>
						<div class="view">
							<i class="fa fa-eye"></i> 9141
						</div>
						<h5>
							<a href="#">The Seven Deadly Sins: Wrath of the Gods</a>
						</h5>
					</div>
					<div class="product__sidebar__view__item set-bg mix week years"
						data-setbg="/img/sidebar/tv-3.jpg">
						<div class="ep">18 / ?</div>
						<div class="view">
							<i class="fa fa-eye"></i> 9141
						</div>
						<h5>
							<a href="#">Sword art online alicization war of underworld</a>
						</h5>
					</div>
					<div class="product__sidebar__view__item set-bg mix years month"
						data-setbg="/img/sidebar/tv-4.jpg">
						<div class="ep">18 / ?</div>
						<div class="view">
							<i class="fa fa-eye"></i> 9141
						</div>
						<h5>
							<a href="#">Fate/stay night: Heaven's Feel I. presage flower</a>
						</h5>
					</div>
					<div class="product__sidebar__view__item set-bg mix day"
						data-setbg="/img/sidebar/tv-5.jpg">
						<div class="ep">18 / ?</div>
						<div class="view">
							<i class="fa fa-eye"></i> 9141
						</div>
						<h5>
							<a href="#">Fate stay night unlimited blade works</a>
						</h5>
					</div>
				</div>
			</div>
			<div class="product__sidebar__comment">
				<div class="section-title">
					<h5>New Comment</h5>
				</div>
				<div class="product__sidebar__comment__item">
					<div class="product__sidebar__comment__item__pic">
						<img src="/img/sidebar/comment-1.jpg" alt="">
					</div>
					<div class="product__sidebar__comment__item__text">
						<ul>
							<li>Active</li>
							<li>Movie</li>
						</ul>
						<h5>
							<a href="#">The Seven Deadly Sins: Wrath of the Gods</a>
						</h5>
						<span><i class="fa fa-eye"></i> 19.141 Viewes</span>
					</div>
				</div>

			</div>
		</div>
	</div>
	</div>
	</div>
	</section>
	<!-- Product Section End -->

	<!-- Footer Section Begin -->
	<footer class="footer">
		<div class="page-up">
			<a href="#" id="scrollToTopButton"><span class="arrow_carrot-up"></span></a>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="footer__logo">
						<a href="./index.html"><img src="/img/logo.png" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="footer__nav">
						<ul>
							<li class="active"><a href="./index.html">Homepage</a></li>
							<li><a href="./categories.html">Categories</a></li>
							<li><a href="./blog.html">Our Blog</a></li>
							<li><a href="#">Contacts</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-3">
					<p>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;
						<script>
							document.write(new Date().getFullYear());
						</script>
						All rights reserved | This template is made with <i
							class="fa fa-heart" aria-hidden="true"></i> by <a
							href="https://colorlib.com" target="_blank">Colorlib</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</p>

				</div>
			</div>
		</div>
	</footer>
	<!-- Footer Section End -->

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

	<!-- /js Plugins -->
	<script src="/js/jquery-3.3.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/player.js"></script>
	<script src="/js/jquery.nice-select.min.js"></script>
	<script src="/js/mixitup.min.js"></script>
	<script src="/js/jquery.slicknav.js"></script>
	<script src="/js/owl.carousel.min.js"></script>
	<script src="/js/main.js"></script>
	<script src="/js/boxoffice.js"></script>
</body>

</html>