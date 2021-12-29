<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 확인 페이지</title>
<link href="<c:url value="/resources/css/payPage.css"/>"
	rel='stylesheet' />
</head>
<script>
function buyNow(){
	if(${authInfo.memberPoint}<${product.productPrice}){
		alert('포인트가 부족합니다.');
		location.href='<c:url value='/mypage/Payment'/>';
	}else{
		alert('구매하시겠습니까? 포인트가 즉시 차감됩니다.');
		location.href='<c:url value='/product/buy/${product.productNumber}'/>';
	}
}
</script>
<body>
<jsp:include page="../Header.jsp"/>
 <div id="sTitle"><strong>Payment</strong> page</div>
    <div id="titleLine"></div>
    <div class="main">
            <div class="pay">
                <div class="orderTitle">거래방식을 선택해주세요.</div>
                <div class="radioBtn">
                    <input type="radio" name="transaction" id="delivery" value="1" checked>
                    <label for="delivery">배송</label>
                    <input type="radio" name="transaction" id="direct" value="2">
                    <label for="direct">직접거래</label>
                </div>
                <hr>
                
                <hr>
                <div class="bigBox">
                    <div class="orderTitle">배송지 정보</div>
                    <div id="smallText">* 배송을 원하시는 경우에만 입력해주세요.</div>
                    <div class="address">
                        <div class="pText"><strong>주문자</strong> : 
                            <input class="textBox" type="text" name="orderer" id="orderer" value="${authInfo.memberName}">
                            </div>
                    <div class="pText"><strong>수령인</strong> : 
                    <input class="textBox" type="text" name="recipient" id="recipient" value="${authInfo.memberName}">
                    </div>
                    <div class="pText"><strong>주&nbsp;&nbsp;&nbsp;소</strong> : 
                    <input class="textBox" type="text" name="memberAddress" id="memberAddress" value="${authInfo.memberAddress}">
                    </div>
                    <div class="pText"><strong>연락처</strong> :
                    <input class="textBox" type="text" name="memberTel" id="memberTel" value="${authInfo.memberTel}">
                    </div>
                    <div id="margin"></div>
                    <label class="message" for="message">배송메세지를 선택해주세요.</label><br>
                    <select name="dMsg" id="dMsg">
                        <option value="1">선택</option>
                        <option value="2">마음의 준비가 필요합니다. 미리 전화주세요</option>
                        <option value="4">만나지 못해 아쉬워요! 경비실에 맡겨주세요.</option>
                        <option value="5">집으로 배송해주세요.</option>
                        <option value="6">문 앞에 두고 벨 눌러주세요.</option>
                        <option value="7">문 앞에 두고 조용히 가주세요.</option>
                        <option value="8">조심히 와주세요.</option>
                    </select>
                    </div>
                </div>
                <hr>

            </div>
            <div class="payMoney">
                <div class="bigBox2">
                    <div class="orderTitle">주문 상품정보</div>
                    <div class="productContent">
                        <div>
                            <img src="<c:url value="/resources/img/categoryMain/${product.productPictureNameURL}"/>" alt="" width="150" height="150">
                        </div>
                        <div class="productText">
                            <div><strong>상품이름</strong> : ${product.productName}</div>
                            <div><strong>금액</strong> : <fmt:formatNumber value="${product.productPrice}"/>원</div>
                        </div>
                    </div>
                </div>
                <div class="innerPayMoney">
                <div class="payTitle">결제 예상금액</div>
                <div class="pText"><strong>제품금액</strong> : <fmt:formatNumber value="${product.productPrice}"/>원</div>
                <div class="pText"><strong>+ 배송비</strong> : 3,000원</div>
                <div id="line"></div>
                <div class="pText total"><strong><span style="color: blue;">총 결제금액</span></strong> : <fmt:formatNumber value="${product.productPrice+3000}"/>원</div>
                </div>
            </div>
            <hr>
    </div>
    <div id="btnBox">
        <input type="button" value="결제하기" class="btn-form2" onclick="return buyNow()">
    </div>
<jsp:include page="../Footer.jsp"/>
</body>
</html>