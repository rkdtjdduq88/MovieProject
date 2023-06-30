<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ include file="include/header.jsp"%>
	
<!DOCTYPE html>
<html lang="zxx">
	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="hero__slider owl-carousel">
				<!-- carousel script -->
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

<!-- Movie Rank List Begin -->
<section class="product spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-8">
				<div class="trending__product">
					<div class="row">
						<div class="col-lg-8 col-md-8 col-sm-8">
							<div class="section-title">
								<h4>영화 랭킹</h4>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="btn__all">
								<a href="#" class="primary-btn">모두 보기 <span class="arrow_right"></span></a>
							</div>
						</div>
					</div>
					<div class="row" id="boxOfficeList">
						
						<!-- Add more movie ranking items here -->
						
					</div>
				</div>
			</div>
			<!-- product__sidebar Start -->
			<div class="col-lg-4 col-md-6 col-sm-4">
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
							<div class="product__sidebar__view__item set-bg mix day years" data-setbg="/img/sidebar/tv-1.jpg">
								<div class="ep">18 / ?</div>
								<div class="view">
									<i class="fa fa-eye"></i> 9141
								</div>
								<h5>
									<a href="#">Boruto: Naruto next generations</a>
								</h5>
							</div>
							<div class="product__sidebar__view__item set-bg mix month week" data-setbg="/img/sidebar/tv-2.jpg">
								<div class="ep">18 / ?</div>
								<div class="view">
									<i class="fa fa-eye"></i> 9141
								</div>
								<h5>
									<a href="#">The Seven Deadly Sins: Wrath of the Gods</a>
								</h5>
							</div>
							<div class="product__sidebar__view__item set-bg mix week years" data-setbg="/img/sidebar/tv-3.jpg">
								<div class="ep">18 / ?</div>
								<div class="view">
									<i class="fa fa-eye"></i> 9141
								</div>
								<h5>
									<a href="#">Sword art online alicization war of underworld</a>
								</h5>
							</div>
							<div class="product__sidebar__view__item set-bg mix years month" data-setbg="/img/sidebar/tv-4.jpg">
								<div class="ep">18 / ?</div>
								<div class="view">
									<i class="fa fa-eye"></i> 9141
								</div>
								<h5>
									<a href="#">Fate/stay night: Heaven's Feel I. presage flower</a>
								</h5>
							</div>
							<div class="product__sidebar__view__item set-bg mix day" data-setbg="/img/sidebar/tv-5.jpg">
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
			<!-- product__sidebar End -->
		</div>
	</div>
</section>
<!-- Movie Rank List End -->
</html>

<%@ include file="include/footer.jsp"%>

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
	<script src="/js/index.js"></script> 	
	<script src="/js/youtube.js"></script> 	
	
</body>

