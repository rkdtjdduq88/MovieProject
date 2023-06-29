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
                            	<input type="text" placeholder="아이디" id="userid" name="userid" maxlength="20" pattern="[a-zA-Z0-9]{8,20}" title="알파벳 대소문자와 숫자만 입력할 수 있고 8자이상 입력해야합니다." required>
                            	<span class="icon_profile"></span>
                       		</div>
	                        <div class="input__item">
	                            <input type="text" placeholder="이름" id="name" name="name" maxlength="10" pattern="[가-힣]{2,10}" title="한글 2글자 이상 10글자 이하로 입력해야 합니다." required>
	                            <span class="icon_profile"></span>
	                        </div>
	                        <div class="form-group email-form">
								 <label for="email">이메일</label>
								 <div class="input-group">
									<input type="text" class="form-control" name="userEmail1" id="userEmail1" placeholder="이메일" >
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
							<input class="form-control mail-check-input" placeholder="인증번호 6자리를 입력해주세요!" disabled="disabled" maxlength="6">
							</div>
								<span id="mail-check-warn"></span>
							</div>
                            <button type="submit" class="site-btn">비밀번호 찾기</button>
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
    <script src="/js/findPassword.js"></script>


</body>

</html>