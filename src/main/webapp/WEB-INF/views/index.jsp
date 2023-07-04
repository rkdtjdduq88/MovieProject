<%@page import="com.project.movie.response.KmdbRes"%>
<%@page import="java.util.List"%>
<%@page import="com.project.movie.domain.MovieDetailReplyDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ include file="include/header.jsp" %>
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
							<h5>별점 순위</h5>
						</div>						
						 <%       
						 	List<MovieDetailReplyDTO> rankGradeDtoList = (List<MovieDetailReplyDTO>) request.getAttribute("rankGradeDtoList");						 
						 
						 	for(MovieDetailReplyDTO dto:rankGradeDtoList){						 		
						       
							 	int rating = dto.getGrade();
							 	
							 	out.print("<div class='filter__gallery'>");
							 	out.print("<div class='product__sidebar__view__item set-bg mix day' data-setbg='"+dto.getPosterUrl()+"'>");
							 	out.print("<div class='view'>");
								for (int i = 1; i <= 5; i++) {
						            if (i <= rating) {                
							 			out.print("<i class='fa fa-star'></i>");
						            } else {               
						            	out.print("<i class='fa fa-star-o'></i>");
						            }
						        } 
								out.print("</div>");
								out.print("<h5><a href=''>"+dto.getTitle()+"</a></h5>");
								out.print("</div>	");
						 	}							
				    	%>													
						</div>
					</div>					
				</div>
			</div>
			<!-- product__sidebar End -->
		</div>	
</section>
<!-- Movie Rank List End -->

<%@ include file="include/footer.jsp" %>

<!-- Search model Begin -->
	<div class="search-model">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-switch">
				<i class="icon_close"></i>
			</div>
			<form class="search-model-form" action="/search">
				<input type="text" id="search-input" placeholder="Search here....." name="query">
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
</body>

</html>      
