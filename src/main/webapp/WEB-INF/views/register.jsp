<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
    <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="img/normal-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>회원가입</h2>
                        <p></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Register Section Begin -->
    <section class="register spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="register__form">
                        <h3>회원가입</h3>
                        <div id="notification" class="notification"></div>
                        <form id="register-form" method="post">
                            <div class="input__item">
                            	<input type="text" placeholder="아이디" id="userid" name="userid">
                            	<span class="icon_profile"></span>
                       		</div>
                        	<div class="input__item">
                            	<input type="password" placeholder="비밀번호" id="password" name="password">
                            	<span class="icon_lock"></span>
                        	</div>
	                        <div class="input__item">
	                            <input type="email" placeholder="이메일 주소" id="email" name="email">
	                            <span class="icon_mail"></span>
	                        </div>
	                        <div class="input__item">
	                            <input type="text" placeholder="이름" id="name" name="name">
	                            <span class="icon_profile"></span>
	                        </div>
	                        <div class="input__item">
	                            <input type="text" placeholder="주소" id="address" name="address">
	                            <span class="icon_profile"></span>
	                        </div>
	                        <div class="input__item">
	                            <input type="tel" placeholder="전화번호" id="mobile" name="mobile">
	                            <span class="icon_phone"></span>
	                        </div>
                            <button type="submit" class="site-btn">회원가입</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Register Section End -->

<%@ include file="include/footer.jsp" %>

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
