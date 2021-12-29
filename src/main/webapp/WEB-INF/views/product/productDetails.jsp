<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PRODUCT VIEW DETAILS</title>
     <link href="<c:url value="/resources/css/productDetails.css"/>" rel='stylesheet' />
</head>
<script>
function deleteAdmin(){
	alert('정말로 삭제하시겠습니까?');
	location.href='<c:url value='/admin/deleteProduct/${product.productNumber}/${product.categoryNumber}'/>';
	
}

function deleteNow(){
	alert('정말로 삭제하시겠습니까?');
	location.href='<c:url value='/product/delete/${product.productNumber}'/>';
	
}

function heart(){
	alert('본인이 올린 상품은 찜을 할 수 없습니다.');
}

function heart2(){
	alert('관리자는 찜을 할 수 없습니다.');
}

</script>
<body>
<jsp:include page="../Header.jsp"/>
    <div class="main">
        <div id="title2">view <strong>product</strong> details</div>
        <div class="productTitle">"${product.productTitle}"</div>
        <div class="container">
            <div class="imgBoxBorder">
                <div class="imgBox">
                    <img class="mainImg" src="<c:url value="/resources/img/categoryMain/${product.productPictureNameURL}"/>">
                </div>
            </div>
            <div class="contentBox">
                <table id="tbl">
                    <tr class="property">
                        <td class="property">상품이름</td>
                        <td>${product.productName}</td>
                    </tr>
                    <tr>
                        <td class="property">판매자 닉네임</td>
                        <td>${nickname}</td>
                    </tr>
                    <tr>
                        <td class="property">가격</td>
                        <td><fmt:formatNumber value="${product.productPrice}"/>원</td>
                    </tr>
                    <tr>
                        <td rowspan="3" class="property">설명</td>
                        <td rowspan="3">${product.productText}</td>
                    </tr>
                    <tr>
                    </tr>
                    <tr>
                    </tr>
                    <tr>
                        <td class="property">조회수</td>
                        <td>${product.productCount}</td>
                    </tr>
                    <tr>
                        <td class="property">상품등록일</td>
                        <td>${regDate}</td>
                    </tr>
                </table>
                <!-- 관리자가 아니면서 본인이 등록한 제품도 아닌 경우 -->
                <c:if test="${authInfo != null}">
                <c:if test="${authInfo.memberGrade!=0 && authInfo.memberNumber != product.memberNumber}">
                <div class="btns">
                    <img src="<c:url value="/resources/img/heart2.png"/>" width="45px" height="45px" id="wish" onclick="location.href='<c:url value='/product/likeProduct/${product.productNumber}'/>'">
                    <div id="buy" class="btn" onclick="location.href='<c:url value='/product/payPage/${product.productNumber}'/>'">buy now</div>
                    <div id="mail" class="btn" onclick="window.open('<c:url value='/product/message/${toSeller}'/>','msg','width=500,height=400')">Send
                        a message</div>
                </div>
                </c:if>
                <!-- 본인이 올린 상품인 경우 -->
                <c:if test="${authInfo.memberNumber == product.memberNumber}">
                <div class="btns">
                    <img src="<c:url value="/resources/img/heart2.png"/>" width="45px" height="45px" id="wish" onclick="return heart()">
                    <div id="buy" class="btn" onclick="return deleteNow()">delete product</div>
                    <div id="mail" class="btn" onclick="location.href='<c:url value='/product/productModify/${product.productNumber}'/>'">MODIFY</div>
                </div>
                </c:if>
                <!-- 관리자인 경우 -->
                <c:if test="${authInfo.memberGrade==0}">
                <div class="btns">
                    <img src="<c:url value="/resources/img/heart2.png"/>" width="45px" height="45px" id="wish" onclick="return heart2()">
                    <div id="buy" class="btn" onclick="return deleteAdmin()">delete product</div>
                    <div id="mail" class="btn" onclick="window.open('<c:url value='/product/message/${toSeller}'/>','msg','width=500,height=400')">Send
                        a message</div>
                </div>
                </c:if>
                </c:if>
                <c:if test="${authInfo == null}">
                	<div class="btns authIfnoNull">< 로그인 후 구매가능합니다. ></div>
                </c:if>
            </div>
        </div>
    </div>
    <jsp:include page="../Footer.jsp"/>
</body>
</html>