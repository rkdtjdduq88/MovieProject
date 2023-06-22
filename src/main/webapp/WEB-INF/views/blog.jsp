<%@include file="./include/header.jsp"%>

<!-- Normal Breadcrumb Begin -->
<section class="normal-breadcrumb set-bg"
	data-setbg="/img/normal-breadcrumb.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="normal__breadcrumb__text">
					<h2>Our Blog</h2>
					<p>Welcome to the official AnimeÂ blog.</p>
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
                            <div class="blog__item set-bg" data-setbg="./img/${board.attach}.jpg">
                                <div class="blog__item__text">
                                    <p><span class="icon_calendar"></span> ${board.regdate}</p>
                                    <h4><a href="#">${board.title}</a></h4>
                                </div>
                            </div>
                        </div>
                        <!-- Repeat the above structure for other blog items -->
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- Blog Section End -->


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

<!-- Js Plugins -->
<script src="/js/jquery-3.3.1.min.js"></script>

<script src="/js/player.js"></script>
<script src="/js/jquery.nice-select.min.js"></script>
<script src="/js/mixitup.min.js"></script>
<script src="/js/jquery.slicknav.js"></script>
<script src="/js/owl.carousel.min.js"></script>


</body>

</html>