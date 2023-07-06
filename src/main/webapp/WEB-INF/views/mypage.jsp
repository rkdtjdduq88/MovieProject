<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" crossorigin="anonymous" />





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
		        <img src="https://avatars.dicebear.com/api/bottts/${comment.userid}.jpg" alt="img" style=" border-radius: 50%;">
		    </div>
		      <div class="profile-info">
			  <h3 class="userid">사용자 ID</h3>
			  <p class="userid">${member.userid}</p>
			  <div class="buttons">
			    <button id="change-password-button" class="btn_change" onclick="openPopup('${sessionScope.userid}')">
			      <span class="text">비밀번호 변경</span>
			    </button>
			    <button id="delete-profile-button" class="btn_unregister" onclick="delPopup('${sessionScope.userid}')">
			      <span class="text">회원 탈퇴</span>
			    </button>
				<button id="subscribe-button" class="btn_subscribe" onclick="handlePayment()">
  <span class="text">구독하기</span>
  <img src="https://www.tfmedia.co.kr/data/photos/20211042/art_16346976902789_aea105.jpg" alt="KakaoPay Icon" class="kakaopay-icon">
</button>


			  </div>
			</div>
		    </div>
		    <div class="edit-info">
		        <div class="user-info">
		            <h3 class="userinfo">사용자 정보</h3>
		            <div class="form-group">
		                <label for="name">이름</label>
		                <div class="row_item">
		                    <input type="text" id="name" name="name" value="${member.name}" readonly>
		                </div>
		            </div>
		
		            <div class="form-group">
		                <label for="email">email</label>
		                <div class="row_item">
		                    <input type="email" id="email" name="email" value="${member.email}" readonly>
		                </div>
		            </div>
		
		            <form action="/updateAddress" method="POST" id="updateAddressForm">
		                <div class="form-group">
		                    <label for="address">주소</label>
		                    <div class="row_item">
		                        <input type="text" id="address" name="address" value="${member.address}" required readonly>
		                        <button type="button" class="btn_edit" onclick="">
								    <span class="text">수정</span>
								</button>
								
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<button type="submit" class="btn_save" style="display: none;" onclick="">
								    <span class="text">저장</span>
								</button>
		                    </div>
		                </div>
		                <input type="hidden" name="userid" value="${member.userid}" />
		            </form>
		
		            <form action="/updateMobile" method="POST" id="updateTelForm">
		                <div class="form-group">
		                    <label for="mobile">전화번호</label>
		                    <div class="row_item">
		                        <input type="tel" id="mobile" name="mobile" value="${member.mobile}" maxlength="13" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="000-0000-0000 형식으로 입력해야 합니다." required readonly>
		                        <button type="button" class="btn_edit2" onclick="">
								    <span class="text">수정</span>
								</button>
								
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<button type="submit" class="btn_save2" style="display: none;" onclick="">
								    <span class="text">저장</span>
								</button>
		                    </div>
		                </div>
		                <input type="hidden" name="userid" value="${member.userid}" />
		            </form>
		
		        </div>
		    </div>
		</section>
    <!-- myPage Section End -->
    
     <!-- 비밀번호 변경 팝업 창 -->

	  <div id="password-popup" class="popup" style="display: none; position: absolute;">
		    <label for="old-password">기존 비밀번호</label>
		    <input type="password" id="old-password" name="old-password">
		 
		    <label for="new-password">새 비밀번호</label>
		    <input type="password" id="new-password" name="new-password" maxlength="20">
		    
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		   		<button class="btn_popup-button" type="submit">변경</button>
		   		
				<button class="btn_popup-button" onclick="closePopup(event)">
				    <span class="text">취소</span>
				</button>
		</div>

	<!-- 회원탈퇴 팝업 창 -->

		<div id="delete-popup" class="popup" style="display: none; position: absolute;">
		    <label for="password-check">비밀번호 확인</label>
		    <input type="password" id="password-check" name="password-check">
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		    <button class="btn_popup-button" type="submit">회원 탈퇴</button>
		    
			<button class="btn_popup-button" onclick="closePopup(event)">
			    <span class="text">취소</span>
			</button>
		</div>

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
    <script src="/js/mypage.js"></script>
    <script src="/js/payment.js"></script>


</body>

</html>