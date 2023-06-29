<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
    <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="img/normal-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>비밀번호 찾기</h2>
                        <p></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->
    
    <!-- FindPassword Section Begin -->
    <section class="findPassword spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="findPassword__form">
                        <h3>비밀번호 찾기</h3> 
                        <div id="notification" class="notification"></div>
                        <form id="findPassword-form" method="post">
                            <div class="input__item">
                            	<input type="password" placeholder="변경할 비밀번호" id="password" name="password" maxlength="20" pattern="^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d@$!%*?&]{8,20}$" 
                            	title="대문자 또는 소문자와 숫자를 반드시 포함한 8자 이상 20자 이하의 비밀번호를 입력해야 합니다.">
                            	<span class="icon_lock"></span>
                        	</div>
                        	<div class="input__item">
                            	<input type="password" placeholder="변경할 비밀번호 확인" id="password2" name="password2" maxlength="20" pattern="^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d@$!%*?&]{8,20}$" 
                            	title="대문자 또는 소문자와 숫자를 반드시 포함한 8자 이상 20자 이하의 비밀번호를 입력해야 합니다.">
                            	<span class="icon_lock"></span>
                        	</div>
                            <button type="submit" class="site-btn">비밀번호 변경</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- FindPassword Section End -->

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
    <script src="/js/register.js"></script>


</body>

</html>