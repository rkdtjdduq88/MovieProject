<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.project.movie.response.BoxOfficeResponse.Movie"%>
<%@ page import="java.util.List"%>

<%@include file="./include/header.jsp"%>

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
							<a href="#" onclick="handlePayment()"><span>Watch Now</span>
								<i class="fa fa-angle-right"></i></a>
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
							<a href="#" onclick="handlePayment()"><span>Watch Now</span>
								<i class="fa fa-angle-right"></i></a>
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
							<a href="#" onclick="handlePayment()"><span>Watch Now</span>
								<i class="fa fa-angle-right"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Hero Section End -->
<!-- Product Section Begin -->
<!-- 생략 -->
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
                    <div class="row" id="movieRankList">
                        <%
                            List<Movie> movieRanking = (List<Movie>) request.getAttribute("movieRanking");
                            if (movieRanking != null) {
                                int movieCount = Math.min(movieRanking.size(), 9); // Limit the movie count to 9
                                for (int i = 0; i < movieCount; i++) {
                                    Movie movie = movieRanking.get(i);
                        %>
                        <div class="col-lg-4 col-md-6 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" data-setbg="<%= movie.getPoster_path() %>">
                                    <div class="ep"><%= i + 1 %></div>
                                </div>
                                <div class="product__item__text">
                                    <h6>
                                        <a href="#"><%= movie.getTitle() %></a>
                                    </h6>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Product Section End -->

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
									<a href="#">Fate/stay night: Heaven's Feel I. presage
										flower</a>
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
			<!-- product__sidebar End -->
		</div>
	</div>
</section>
<!-- Movie Rank List End -->

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
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
	// 결제 버튼 클릭 이벤트 핸들러
	function handlePayment() {
		var IMP = window.IMP;
		IMP.init('imp07885133');

		// 결제 정보 설정
		var paymentInfo = {
			pg : 'kakaopay', // PG사 종류 (예시: html5_inicis, kakaopay)
			pay_method : 'card', // 결제 수단 (예시: card, vbank, trans, phone, samsung, kpay, cultureland)
			merchant_uid : 'merchant_' + new Date().getTime(), // 상점에서 관리하는 주문번호
			name : '결제', // 주문명
			amount : 10000, // 결제금액
			buyer_email : 'OHAL', // 구매자 이메일
			buyer_name : 'POHAHOLE', // 구매자 이름
			buyer_tel : '구매자 번호', // 구매자 전화번호
			buyer_addr : 'POHAH F1', // 구매자 주소
			buyer_postcode : '701', // 구매자 우편번호
			m_redirect_url : '결제 완료 후 리다이렉트할 URL' // 결제 완료 후 리다이렉트할 URL
		};

		// Iamport 결제 요청
		IMP.request_pay(paymentInfo, function(response) {
			if (response.success) {
				var msg = '결제가 완료되었습니다.';
				location.href = '결제 완료 페이지 URL';
			} else {
				var msg = '결제에 실패하였습니다. 에러 메시지: ' + response.error_msg;
				alert(msg);
			}
		});
	}
</script>
</body>

</html>