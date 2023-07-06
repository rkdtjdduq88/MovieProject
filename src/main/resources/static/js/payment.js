/**
 * 카카오페이 결제 버튼 클릭 이벤트 핸들러
 */
function handlePayment() {
  var IMP = window.IMP;
  IMP.init("imp07885133");

  // 결제 정보 설정
  var paymentInfo = {
    pg: "kakaopay", // PG사 종류 (예시: html5_inicis, kakaopay)
    pay_method: "card", // 결제 수단 (예시: card, vbank, trans, phone, samsung, kpay, cultureland)
    merchant_uid: "merchant_" + new Date().getTime(), // 상점에서 관리하는 주문번호
    name: "구독 결제", // 주문명
    amount: 10000, // 결제금액 (원하는 금액으로 설정)
    buyer_email: "OHAL", // 구매자 이메일
    buyer_name: "POHAHOLE", // 구매자 이름
    buyer_tel: "구매자 번호", // 구매자 전화번호
    buyer_addr: "POHAH F1", // 구매자 주소
    buyer_postcode: "701", // 구매자 우편번호
    m_redirect_url: "결제 완료 후 리다이렉트할 URL", // 결제 완료 후 리다이렉트할 URL
  };

  // Iamport 결제 요청
  IMP.request_pay(paymentInfo, function (response) {
    if (response.success) {
      // 결제 성공 시 수행할 작업
      var msg = "결제가 완료되었습니다.";
      location.href = "결제 완료 페이지 URL";
    } else {
      // 결제 실패 시 수행할 작업
      var msg = "결제에 실패하였습니다. 에러 메시지: " + response.error_msg;
      alert(msg);
    }
  });
}
