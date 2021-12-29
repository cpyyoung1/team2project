<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 충전</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/mypage.css"/>" rel='stylesheet' />
<script src='<c:url value="/resources/js/payment.js"/>'></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
	<jsp:include page="../Header.jsp" />
	<div class="container">
		<div class="mypage-wrap">

			<div class="mypage-header clear">
				<h2 class="fl">포인트 충전</h2>
				<div class="mypage-modify fr">
					<button class="btn-form2"
						onclick="window.history.back()">뒤로가기</button>
				</div>
			</div>

			<div class="note-area">
				<div class="payment-area">


					<div class="current-point clear">
						<h2 class="fl">현재 포인트</h2>
						<h3 class="fl">${authInfo.memberPoint}P</h3>
					</div>

					<div class="payment-item clear">
						<div class="payment-content fl">
							<div class="payment-point">
								<h2 class="fl">10000</h2>
								<h3 class="fl">P</h3>
							</div>
							<div class="payment-cash">
								<div>
									<h2 class="fl">10000</h2>
									<h3 class="fl">원</h3>
								</div>
								<div>
									<h3>+0%</h3>
								</div>
								<div>
									<button class="btn-form2" onclick="changePrice10000()">선택</button>
								</div>
							</div>
						</div>
						<!-- class="payment-content" -->
						<div class="payment-content fl">
							<div class="payment-point">
								<h2 class="fl">22000</h2>
								<h3 class="fl">P</h3>
							</div>
							<div class="payment-cash">
								<div>
									<h2 class="fl">20000</h2>
									<h3 class="fl">원</h3>
								</div>
								<div>
									<h3>+10%</h3>
								</div>
								<div>
									<button class="btn-form2" onclick="changePrice20000()">선택</button>
								</div>
							</div>
						</div>
						<!-- class="payment-content" -->
						<div class="payment-content fl">
							<div class="payment-point">
								<h2 class="fl">33300</h2>
								<h3 class="fl">P</h3>
							</div>
							<div class="payment-cash">
								<div>
									<h2 class="fl">30000</h2>
									<h3 class="fl">원</h3>
								</div>
								<div>
									<h3>+11%</h3>
								</div>
								<div>
									<button class="btn-form2" onclick="changePrice30000()">선택</button>
								</div>
							</div>
						</div>
						<!-- class="payment-content" -->
						<div class="payment-content fl">
							<div class="payment-point">
								<h2 class="fl">44800</h2>
								<h3 class="fl">P</h3>
							</div>
							<div class="payment-cash">
								<div>
									<h2 class="fl">40000</h2>
									<h3 class="fl">원</h3>
								</div>
								<div>
									<h3>+12%</h3>
								</div>
								<div>
									<button class="btn-form2" onclick="changePrice40000()">선택</button>
								</div>
							</div>
						</div>
						<!-- class="payment-content" -->
						<div class="payment-content fl">
							<div class="payment-point">
								<h2 class="fl">57000</h2>
								<h3 class="fl">P</h3>
							</div>
							<div class="payment-cash">
								<div>
									<h2 class="fl">50000</h2>
									<h3 class="fl">원</h3>
								</div>
								<div>
									<h3>+14%</h3>
								</div>
								<div>
									<button class="btn-form2" onclick="changePrice50000()">선택</button>
								</div>
							</div>
						</div>
						<!-- class="payment-content" -->

					</div>
					<!-- class="payment-item" -->
					
					<div class="payment-type">
						<div class="payment-type-name">
							<h2>직접 입력</h2>
						</div>
						<div class="payment-type-sel">
							<input type="number" id="changePrice">원
							<input type="button" class="btn-form2" id="changePriceBtn" onclick="changePrice()" value="확인">
						</div>
					</div>

					<div class="payment-type">
						<div class="payment-type-name">
							<h2>결제금액</h2>
						</div>
						<div class="payment-type-sel">
							<span id="paymentPrice">0</span>&nbsp;원
						</div>
					</div>

					<div class="payment-type">
						<div class="payment-type-name">
							<h2>결제수단</h2>
						</div>
						<div class="payment-type-sel">
							<input type="radio" value="1" checked="checked"> 신용/체크카드
						</div>
					</div>
					<div class="btnBox">
						<input type="submit" class="btn-form2" value="결제하기"
							onclick="openImp()">
					</div>
				</div>
				<!-- class="payment-area" -->
			</div>
			<!-- class="note-area" -->
		</div>
		<!-- class="mypage-wrap" -->

	</div>
	<jsp:include page="../Footer.jsp" />
</body>
<script>
function openImp(){
	var IMP = window.IMP;
	IMP.init('imp91948771');

	var price = parseInt(document.getElementById('paymentPrice').innerHTML);
	sessionStorage.setItem("payMoney",price);

	if(price<1000){
		alert('최소 충전 금액은 1,000원입니다.');
	}else if(price>1000000){
		alert('최대 충전 금액은 1,000,000원 입니다.');
	}else{
	
	IMP.request_pay({
	    pg : 'inicis', // version 1.1.0부터 지원.
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : 'TEAM TWO 포인트 충전',
	    amount : price,
	    buyer_email : 'iamport@siot.do',
	    buyer_name : '구매자이름',
	    buyer_tel : '010-1234-5678',
	    buyer_addr : '서울특별시 강남구 삼성동',
	    buyer_postcode : '123-456',
	    m_redirect_url : 'https://www.yourdomain.com/payments/complete'
	}, function(rsp) {
	    if ( rsp.success ) {
	        var msg = '결제가 완료되었습니다.';
	        msg += '결제 금액 : ' + rsp.paid_amount;
	        msg += '카드 승인번호 : ' + rsp.apply_num;
	    } else {
	        var msg = '결제에 실패하였습니다.';
	        msg += '에러내용 : ' + rsp.error_msg;
	    }
	    alert(msg);
	    location.href= "<c:url value='/mypage/payNow?payMoney="+price+"'></c:url>"
	   
	    
	});	
	}
}
</script>
</html>