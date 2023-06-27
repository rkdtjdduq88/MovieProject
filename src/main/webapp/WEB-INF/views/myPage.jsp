<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
    <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="img/normal-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>마이페이지</h2>
                        <p></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- myPage Section Begin -->
		<section class="my-page">
		  <div class="profile">
		    <div class="profile-image">
		      <!-- 프로필 사진 표시 -->
		    </div>
		    <div class="profile-info">
		      <h3 class="userid">사용자 ID</h3>
		      <p class="userid">${sessionScope.userid}</p>
		    </div>
		  </div>
		  <div class="edit-info">
		    <div class="user-info">
		      <h3 class="userinfo">사용자 정보</h3>
		      <div class="form-group">
		        <label for="email">이메일</label>
		        <div class="row_item">
		          <input type="email" id="email" name="email" value="${email}" readonly>
		          <button type="button" class="btn_edit" onclick="editEmail()">
		            <span class="text">수정</span>
		          </button>
		        </div>
		      </div>
		      <div class="form-group">
		        <label for="mobile">전화번호</label>
		        <div class="row_item">
		          <input type="tel" id="mobile" name="mobile" value="${mobile}" readonly>
		          <button type="button" class="btn_edit" onclick="editMobile()">
		            <span class="text">수정</span>
		          </button>
		        </div>
		      </div>
		    </div>
		  </div>
		</section>
    <!-- myPage Section End -->

<%@ include file="include/footer.jsp" %>

      <!-- Search model Begin -->
      <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch"><i class="icon_close"></i></div>
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
    <script src="/js/login.js"></script>


</body>

</html>