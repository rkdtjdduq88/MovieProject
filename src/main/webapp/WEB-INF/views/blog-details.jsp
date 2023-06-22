<%@include file="./include/header.jsp"%>

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
					<img src="img/blog/details/blog-details-pic.jpg" alt="">
				</div>
			</div>
			<div class="col-lg-8">
				<div class="blog__details__content">
					<div class="blog__details__text">
						<p>${boardDto.content}</p>
					</div>
					<div class="blog__details__item__text">
						<h4>Tobio-Nishinoya showdown:</h4>
						<img src="img/blog/details/bd-item-1.jpg" alt="">
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
					<div class="blog__details__comment">
						<h4>3 Comments</h4>
						<div class="blog__details__comment__item">
							<div class="blog__details__comment__item__pic">
								<img src="img/blog/details/comment-1.png" alt="">
							</div>
							<div class="blog__details__comment__item__text">
								<span>Sep 08, 2020</span>
								<h5>John Smith</h5>
								<p>Neque porro quisquam est, qui dolorem ipsum quia dolor
									sit amet, consectetur, adipisci velit, sed quia non numquam
									eius modi</p>
								<a href="#">Like</a> <a href="#">Reply</a>
							</div>
						</div>
						<div
							class="blog__details__comment__item blog__details__comment__item--reply">
							<div class="blog__details__comment__item__pic">
								<img src="img/blog/details/comment-2.png" alt="">
							</div>
							<div class="blog__details__comment__item__text">
								<span>Sep 08, 2020</span>
								<h5>Elizabeth Perry</h5>
								<p>Neque porro quisquam est, qui dolorem ipsum quia dolor
									sit amet, consectetur, adipisci velit, sed quia non numquam
									eius modi</p>
								<a href="#">Like</a> <a href="#">Reply</a>
							</div>
						</div>
						<div class="blog__details__comment__item">
							<div class="blog__details__comment__item__pic">
								<img src="img/blog/details/comment-3.png" alt="">
							</div>
							<div class="blog__details__comment__item__text">
								<span>Sep 08, 2020</span>
								<h5>Adrian Coleman</h5>
								<p>Neque porro quisquam est, qui dolorem ipsum quia dolor
									sit amet, consectetur, adipisci velit, sed quia non numquam
									eius modi</p>
								<a href="#">Like</a> <a href="#">Reply</a>
							</div>
						</div>
					</div>
					<div class="blog__details__form">
						<h4>Leave A Commnet</h4>
						<form action="#">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" placeholder="Name">
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6">
									<input type="text" placeholder="Email">
								</div>
								<div class="col-lg-12">
									<textarea placeholder="Message"></textarea>
									<button type="submit" class="site-btn">Send Message</button>
								</div>
							</div>
						</form>
					</div>
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
	<input type="hidden" name="bno" value="${boardDto.bno}" />
</form>

<script>
	//게시물 글번호 가져오기
	const bno = ${read.bno};
</script>

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

</html>