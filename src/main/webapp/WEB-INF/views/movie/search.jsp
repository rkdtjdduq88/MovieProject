<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>


    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="/"><i class="fa fa-home"></i> Home</a>

                        <span>Search</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Product Section Begin -->
    <section class="product-page spad">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-lg-8">
                    <div class="product__page__content">
                        <div class="product__page__title">
                            <div class="row">
                                <div class="col-lg-8 col-md-8 col-sm-6">
                                    <div class="section-title">
                                        <h4>${query}에 대한 검색 결과 입니다</h4>
                                    </div>
                                </div>
<!--                                 <div class="col-lg-4 col-md-4 col-sm-6">
                                    <div class="product__page__filter">
                                        <p>Order by:</p>
                                        <select>
                                            <option value="">A-Z</option>
                                            <option value="">1-10</option>
                                            <option value="">10-50</option>
                                        </select>
                                    </div>
                                </div> -->
                            </div>
                        </div>
                        
                       <!--  <div class="row"> -->
                       
                        <!-- 영화 여러개 보여줄 곳 -->
                        
                      <%--   <div class="row center-content">
						  <c:forEach var="movie" items="${list}">
						    <div class="col-lg-3 col-md-4 col-sm-6">
						      <div class="product__item">
						        <div class="product__item__pic set-bg" data-setbg="${empty movie.posterUrl ? 'https://www28.cs.kobe-u.ac.jp/wp-content/uploads/2021/04/noimage.png' : movie.posterUrl}">
						          <!-- <div class="ep"> 18 / 18 </div> -->
						          <div class="comment"><i class="fa fa-comments"></i> <!-- 11 --></div>
						          <div class="view"><i class="fa fa-eye"></i> <!-- 9141 --></div>
						        </div>
						        <div class="product__item__text">
						          <ul>
						            <li>Active</li>
						            <li>Movie</li>
						          </ul>
						          <h5><a href="/movie/details?movieNm=${movie.title}&movieDt=${movie.releaseDate}">${movie.title}</a></h5>
						        </div>
						      </div>
						    </div>
						  </c:forEach>
						</div> --%>
                        
                      
						  <div class="row">
						
						  <c:forEach var="movie" items="${list}">
						    <div class="col-lg-4 col-md-6 col-sm-6">
						      <div class="product__item">
						        <div class="product__item__pic set-bg" data-setbg="${empty movie.posterUrl ? 'https://www28.cs.kobe-u.ac.jp/wp-content/uploads/2021/04/noimage.png' : movie.posterUrl}">
						       
						        </div>
						        <div class="product__item__text">
						       
						          <h5><a href="/movie/details?movieNm=${movie.title}&movieDt=${movie.releaseDate}">${movie.title}</a></h5>
						        </div>
						      </div>
						    </div>
						  </c:forEach>
						 
						</div> 
                  
                      
                        
                    </div>
<!--                     <div class="product__pagination">
                        <a href="#" class="current-page">1</a>
                        <a href="#">2</a>
                        <a href="#">3</a>
                        <a href="#">4</a>
                        <a href="#">5</a>
                        <a href="#"><i class="fa fa-angle-double-right"></i></a>
                    </div> -->
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

<!-- Js Plugins -->
<script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/player.js"></script>
<script src="/js/jquery.nice-select.min.js"></script>
<script src="/js/mixitup.min.js"></script>
<script src="/js/jquery.slicknav.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/main.js"></script>
<!-- <script src="/js/search.js"></script> -->

</body>

</html>