<%@include file="./include/header.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Normal Breadcrumb Begin -->
<section class="normal-breadcrumb set-bg"
	data-setbg="img/normal-breadcrumb.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="normal__breadcrumb__text">
					<h2>Our Blog</h2>
				
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
                <c:set var="thumbnail" value="${board.uuid}_${board.attach}" />
                <div class="blog__item set-bg" data-setbg="/img/blog/${thumbnail}">
                
                    <div class="blog__item__text">
                        <p>
                            <span class="icon_calendar"></span>
                            <fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" />
                        </p>
                        <h4>
                            <a href="/blog-details/${board.bno}">${board.title}</a>
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>
		</div>
	</div>
<!--Pagenation begin  -->
<div class="pagination">
  <c:if test="${currentPage > 1}">
    <a href="/blog?page=${currentPage - 1}">Previous</a>
  </c:if>
  
  <c:set var="startPage" value="${currentPage - 2}" />
  <c:choose>
    <c:when test="${startPage < 1}">
      <c:set var="startPage" value="1" />
    </c:when>
  </c:choose>
  
  <c:set var="endPage" value="${currentPage + 2}" />
  <c:choose>
    <c:when test="${endPage > totalPages}">
      <c:set var="endPage" value="${totalPages}" />
    </c:when>
  </c:choose>
  
  <c:forEach var="pageNumber" begin="${startPage}" end="${endPage}">
    <c:choose>
      <c:when test="${pageNumber == currentPage}">
        <a class="active" href="/blog?page=${pageNumber}">${pageNumber}</a>
      </c:when>
      <c:otherwise>
        <a href="/blog?page=${pageNumber}">${pageNumber}</a>
      </c:otherwise>
    </c:choose>
  </c:forEach>
  
  <c:if test="${currentPage < totalPages}">
    <a href="/blog?page=${currentPage + 1}">Next</a>
  </c:if>
</div>

<!--Pagenation end-->
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
<script src="/js/bootstrap.min.js"></script>
<script src="/js/player.js"></script>
<script src="/js/jquery.nice-select.min.js"></script>
<script src="/js/mixitup.min.js"></script>
<script src="/js/jquery.slicknav.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/main.js"></script>

</body>

</html>