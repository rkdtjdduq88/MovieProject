<%@page import="com.project.movie.domain.MovieDetailReplyCntFavDTO"%>
<%@page import="com.project.movie.response.KmdbRes"%>
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
                        <a href="/">Categories</a>
                        <span><c:out value="${detail.genre}" /></span>
                    </div>
                </div>
            </div>
        </div>    
    </div>
    <!-- Breadcrumb End -->

    <!-- Anime Section Begin -->
    <section class="anime-details spad">
        <div class="container">
            <div class="anime__details__content">
           
                <div class="row">
                   
		            <div class="col-lg-3">
					  <div class="anime__details__pic set-bg" data-setbg="${empty detail.posterUrl ? 'https://www28.cs.kobe-u.ac.jp/wp-content/uploads/2021/04/noimage.png' : detail.posterUrl}">
					    <div class="comment"><i class="fa fa-comments"></i>${count}</div>
					    <div class="view"><i class="fa">평점:</i>${avg}</div>
					  </div>
					</div>
	
					 <div class="col-lg-9">
                        <div class="anime__details__text">
                            <div class="anime__details__title">
                                <h3>${detail.title}</h3>
                                <span>${detail.directorNm}</span>
                            </div>
                            <!-- 평점수정 -->
                            <div class="anime__details__rating">
                                <div class="rating">
                                	<h6></h6>
                                    <%       
								        KmdbRes res = (KmdbRes) request.getAttribute("detail");
								        int rating = res.getGrade();
								        
								        for (int i = 1; i <= 5; i++) {
								            if (i <= rating) {                
								                %><i class="fa fa-star"></i><%
								            } else {               
								                %><i class="fa fa-star-o"></i><%
								            }
								        } 
								    %>
                                </div>
                                 
                            </div>
                            <p>${detail.plot}</p>
                            <div class="anime__details__widget">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6">
                                        <ul>
                                            <li><span>Type:</span> ${detail.type}</li>
                                            <li><span>Studios:</span> ${detail.company}</li>
                                            <li><span>Genre:</span> ${detail.genre}</li>
                                          <%--   <li><span>Actors:</span> ${detail.actors}</li> --%>
                                          
					              
								<li>
  <span>Actors:</span>
  <div class="actor-container">
    <ul id="actor-list">
      <c:forEach items="${detail.actors}" var="actor" varStatus="status">
        <li class="actor">${actor}</li>
      </c:forEach>
    </ul>
  </div>
  <button id="toggle-actors-button" class="toggle-button">더보기</button>
</li>


                                        </ul>
                                    </div>
                                    <div class="col-lg-6 col-md-6">
                                        <ul>
                                           <!--  <li><span>Scores:</span> 7.31 / 1,515</li> -->
                                            <li><span>Rating:</span> ${detail.rating}</li>
                                            <li><span>Runtime:</span>${detail.runtime} 분</li>
                                           <!--  <li><span>Quality:</span> HD</li> -->
                                
									<c:forEach var="list" items="${list}">
									  <c:if test="${detail.title == list.movieNm}">
									    <li><span>Views:</span> ${list.audiAcc} 명</li>
									  </c:if>
									</c:forEach>
										 <li><span>ReleaseDate:</span> ${detail.releaseDate}</li>
       
 										</ul>
                                    </div>
                                </div>
                            </div>
                            <div class="anime__details__btn">
                                <a href="#" class="follow-btn"><i class="fa fa-heart-o"></i> Add wishlist</a>
                                <i class="mwatch">
                                <a href="#" class="watch-btn">
                                	<span>Watch Now</span> 
                                	<i class="fa fa-angle-right"></i>
                                </a>
                                </i>
                                </div>
                            </div>
                                    
                       <c:if test="${not empty detail.stills}">
			                    <div class="description-wrapper">
							        <div>still cut</div>
							    </div>
						<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
							  <div class="carousel-inner">
							    <c:forEach items="${detail.stills}" var="still" varStatus="status">
							      <div class="carousel-item ${status.first ? 'active' : ''}">
							        <img src="${still}" class="d-block w-100" alt="Still Image">
							      </div>
							    </c:forEach>
							  </div>
							  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
							    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
							    <span class="visually-hidden"></span>
							  </button>
							  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
							    <span class="carousel-control-next-icon" aria-hidden="true"></span>
							    <span class="visually-hidden"></span>
							  </button>
							</div>
						</c:if>                    
							
                        </div>
                    </div>
                    
                </div>
                <!-- 댓글 작업 시작 -->
                <div class="row justify-content-md-center"> <!-- 댓글 가운데 정렬함 -->
                    <div class="col-lg-8 col-md-8">
                        <div class="anime__details__review">
                            <div class="section-title">
                                <h5>Reviews</h5>
                            </div>
                          <!-- 댓글 스크립트 -->  
                        </div>
                       
                       
                    <security:authorize access="isAuthenticated()">                  
                        <!-- 댓글 수정 폼(모달) -->
						<div class="modal" tabindex="-1" id="replyModal">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title">댓글 수정</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						        <input type="hidden" name="rno" id="rno" />
						        <div class="form-group">
						        	<textarea name="replyContent" id="replyContent" rows="4" class="form-control"></textarea>
						        </div>
						        <div class="form-group">
						        	<input type="text" name="userid" id="userid" class="form-control" value="<security:authentication property="principal.username"/>" readonly/>
						        </div>
						      </div> 
							   
						      <div class="modal-footer">
								  <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
							      <button type="button" class="btn btn-primary">수정</button>

							        	
						      </div>
						    </div>
						  </div>
						</div>
		 				</security:authorize>		 
	                  <!-- 댓글 수정 폼 종료(모달) -->
	                  
					<security:authorize access="isAuthenticated()">
                        <div class="anime__details__form">
		                  <form action="" id="insertForm">
	                          <div class="section-title">
	                              <h5>Your Comment</h5>	                                
	                          	<input type="text" class="userid" id="userid2" value="<security:authentication property="principal.username"/>" readonly />
	                          </div>
	                             <textarea placeholder="Your Comment" id="replyContent"></textarea>
	                              <div class="rating">
	                                  <i class="fa fa-star-o" data-value="1"></i>
	                                  <i class="fa fa-star-o" data-value="2"></i>
	                              	<i class="fa fa-star-o" data-value="3"></i>
	                                  <i class="fa fa-star-o" data-value="4"></i>
	                                  <i class="fa fa-star-o" data-value="5"></i>	                                    
	                              </div>
	                          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />    
	                          <button type="submit"><i class="fa fa-location-arrow"></i> Review</button>
	                     </form>                            
                        </div>
                     </security:authorize>
                    </div>

                                                
                    <!-- 댓글 작업 종료 -->
                  <!--   <div class="col-lg-4 col-md-4">
                        <div class="anime__details__sidebar">
                            <div class="section-title">
                                <h5>you might like...</h5>
                            </div>
                            <div class="product__sidebar__view__item set-bg" data-setbg="/img/sidebar/tv-1.jpg">
                                <div class="ep">18 / ?</div>
                                <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                <h5><a href="#">Boruto: Naruto next generations</a></h5>
                            </div>
                            <div class="product__sidebar__view__item set-bg" data-setbg="/img/sidebar/tv-2.jpg">
                                <div class="ep">18 / ?</div>
                                <div class="view"><i class="fa fa-eye"></i> 9141</div>
                                <h5><a href="#">The Seven Deadly Sins: Wrath of the Gods</a></h5>
                            </div>
                        </div>
                    </div> -->
                </div>
            </div>
        </section>
        <!-- Anime Section End -->

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
      
  <form action="/wish/new" id="wishForm" method="post">
 	<input type="hidden" name="title" value="${detail.title}" />
 	<input type="hidden" name="directorNm" value="${detail.directorNm}" />
 	<input type="hidden" name="releaseDate" value="${detail.releaseDate}" />
 	<input type="hidden" name="posterUrl" value="${detail.posterUrl}" />
 	
 	  <security:authorize access="isAuthenticated()">   
 	  	<%-- <c:if test="${ }"> --%>
 		<input type="hidden" name="userid" value="<security:authentication property="principal.username"/>" />  
 	  <%-- 	</c:if> --%>
 	 </security:authorize> 
 	
 	  <security:authorize access="isAnonymous()">   
 		<input type="hidden" name="userid" value="" />  
 	 </security:authorize> 
 	
  	<%-- <input type="hidden" name="userid" value="${userid}" />   --%>
 </form>
    
	<script>
			const title = '${detail.title}';

		/* const userid = document.querySelector("#userid2").value; */
		
			const userid = document.querySelector("#wishForm [name='userid']").value;

			const csrfToken='${_csrf.token}';  
	</script>
	            
	<!-- Core plugin JavaScript-->
    <script src="/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- sweet alert -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.20/dist/sweetalert2.min.js"></script>
    <!-- Js Plugins -->
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/player.js"></script>
    <script src="/js/jquery.nice-select.min.js"></script>
    <script src="/js/mixitup.min.js"></script>
    <script src="/js/jquery.slicknav.js"></script>
    <script src="/js/owl.carousel.min.js"></script>
    <script src="/js/main.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/js/addWish.js"></script>
    <script src="../js/moviedetail.js"></script>
   <script src="/js/youtube.js"></script> 
  <link rel="stylesheet" type="text/css" href="/css/moviedetail.css">


</body>


</html>


  

