<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
    
 <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <!-- <div class="breadcrumb__links">
                        <a href="/"><i class="fa fa-home"></i> Home</a>
                        <span>MyWish</span>
                        <span>Romance</span>
                    </div> -->
                </div>
            </div>
        </div>
    </div>  
    <!-- Breadcrumb End -->

    <!-- Product Section Begin -->   
    <section class="product-page spad">
        <div class="container-fluid">
          <div class="row justify-content-md-center">
         
                <div class="col-lg-8">
                    <div class="product__page__content wish_content center-content" style="display: flex; justify-content: center; align-items: center;">
                        <div class="product__page__title">
                           
                                <div class="col-lg-8 col-md-8 col-sm-6">
                                    <div class="section-title">
                                        <h4>MY WISHLIST</h4>
                                    </div>  
                                </div>           
                           		<div class="row wishList center-content">

                                </div>     
                       
                        </div>                       
                    </div>     
                                                  
                     <div class="product__pagination">
						<div class="pagination-container"></div>
			         
			         
                    </div> 
	                    
	               </div> 
 				</div>
			
		</div>
</section>    
<!-- Product Section End -->


  <%@ include file="../include/footer.jsp" %>

  <!-- Search model Begin -->
  <div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch"><i class="icon_close"></i></div>
        <form class="search-model-form" action="/search">
            <input type="text" id="search-input" placeholder="Search here....." name="query">
        </form>
    </div>
</div> 
<!-- Search model end -->

	<script>
/* 		const title = '${detail.title}';	 */
		const userid = '<security:authentication property="principal.username"/>';	

		const csrfToken='${_csrf.token}';
	</script>
	
<!-- Js Plugins -->
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/player.js"></script>
<script src="/js/jquery.nice-select.min.js"></script>
<script src="/js/mixitup.min.js"></script>
<script src="/js/jquery.slicknav.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/main.js"></script>
<!-- <script src="/js/addWish.js"></script> -->
<script src="/js/wishList.js"></script>   

<!-- <script src="/js/wishList.js"></script>   -->        
<!-- <script src="/js/search.js"></script> -->     

<!-- sweet alert -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.20/dist/sweetalert2.min.js"></script>
</body>

</html>