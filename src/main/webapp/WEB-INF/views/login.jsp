<%@include file="./include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<!-- Normal Breadcrumb Begin -->
<section class="normal-breadcrumb set-bg"
	data-setbg="/img/normal-breadcrumb.jpg">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="normal__breadcrumb__text">
					<h2>로그인</h2>
					<p></p>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Normal Breadcrumb End -->

    <!-- Login Section Begin -->
    <section class="login spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="login__form">
                        <h3>로그인</h3>
                        <form method="post" action='<c:url value="/login"/>' id="login-form">
						    <div class="input__item">
						        <input type="text" id="userid" name="username" placeholder="아이디 입력" required>
						        <span class="icon_profile"></span>
						    </div>
						    <div class="input__item">
						        <input type="password" id="password" name="password" placeholder="비밀번호 입력" required>
						        <span class="icon_lock"></span>
						    </div>
						    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						    <button type="submit" class="site-btn">로그인</button>
						</form>
						
						<security:authorize access="isAuthenticated()">
						    <!-- 로그인 성공한 경우에만 실행됩니다 -->
						    <%-- 세션에 저장된 userid 값을 가져옵니다 --%>
						    <c:set var="userid" value="${sessionScope.userid}" />
						</security:authorize>
					    
					    
					    
                        <a href="#" class="forget_pass" id="findPassword">비밀번호 찾기</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="login__register">
                        <h3>아이디가 없으십니까?</h3>
                        <a href="#" class="primary-btn" id="registerBtn">회원가입</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Login Section End -->

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
    <script>
	    var error = "${error}";
	    if (error !== "") {
	        alert(error);
	    }
	</script>
	
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