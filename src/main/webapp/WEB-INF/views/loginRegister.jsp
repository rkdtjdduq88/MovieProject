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
                            	<input type="text" placeholder="아이디" id="userid" name="userid" maxlength="20" pattern="[a-zA-Z0-9]{8,20}" title="알파벳 대소문자와 숫자만 입력할 수 있고 8자이상 입력해야합니다." required>
                            	<button type="button" class="w-100 btn btn-danger">중복아이디</button>
                            	<span class="icon_profile"></span>
                       		</div>
                        	<div class="input__item">
                            	<input type="password" placeholder="비밀번호" id="password" name="password" maxlength="20" pattern="^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d@$!%*?&]{8,20}$" 
                            	title="대문자 또는 소문자와 숫자를 반드시 포함한 8자 이상 20자 이하의 비밀번호를 입력해야 합니다.">
                            	<span class="icon_lock"></span>
                        	</div>
                        	<div class="input__item">
                            	<input type="password" placeholder="비밀번호 확인" id="password2" name="password2" maxlength="20" pattern="^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d@$!%*?&]{8,20}$" 
                            	title="대문자 또는 소문자와 숫자를 반드시 포함한 8자 이상 20자 이하의 비밀번호를 입력해야 합니다.">
                            	<span class="icon_lock"></span>
                        	</div>
	                        <div class="form-group email-form">
								 <label for="email">이메일</label>
								 <div class="input-group">
								<input type="text" class="form-control" name="userEmail1" id="userEmail1" placeholder="이메일" required>
								<select class="form-control" name="userEmail2" id="userEmail2" >
								<option>@naver.com</option>
								<option>@daum.net</option>
								<option>@gmail.com</option>
								</select> 
								</div> 
							<div class="input-group-addon">
								<button type="button" class="btn btn-primary" id="mail-Check-Btn">본인인증</button>
							</div>
								<div class="mail-check-box">
							<input class="form-control mail-check-input" id="mail-Check-Input"placeholder="인증번호 6자리를 입력해주세요!" disabled="disabled" maxlength="6">
							</div> 
								<span id="mail-check-warn"></span>
							</div> 
	                        <div class="input__item">
	                            <input type="text" placeholder="이름" id="name" name="name" maxlength="10" pattern="[가-힣]{2,10}" title="한글 2글자 이상 10글자 이하로 입력해야 합니다." required>
	                            <span class="icon_profile"></span>
	                        </div>
	                        <div class="input__item">
	                            <input type="text" placeholder="주소" id="address" name="address" pattern="[가-힣0-9]+" title="한글과 숫자만 입력할 수 있습니다." required>
	                            <span class="icon_profile"></span>
	                        </div>
	                        <div class="input__item">
	                            <input type="tel" placeholder="전화번호" id="mobile" name="mobile" maxlength="13" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="000-0000-0000 형식으로 입력해야 합니다." required>
	                            <span class="icon_phone"></span>
	                        </div>
	                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <button type="submit" class="site-btn">회원가입</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Register Section End -->

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
    <script src="/js/loginRegister.js"></script>


</body>

</html>