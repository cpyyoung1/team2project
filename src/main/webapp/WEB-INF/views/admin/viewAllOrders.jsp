<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 거래내역 보기</title>
<link href="<c:url value="/resources/css/viewAllOrders.css"/>" rel='stylesheet' />
</head>
<body>
<jsp:include page="../Header.jsp" />
	<div class="main">
		<div class="container">
			<div id="title2">
				<strong>view</strong> all orders
			</div>
			<table class="tbl" border="1">
				<tr class="property">
					<td>주문번호</td>
					<td>사진</td>
					<td>이름</td>
					<td>주문날짜</td>
					<td>가격</td>
					<td>판매자 닉네임</td>
					<td>구매자 닉네임</td>
				</tr>
				<c:forEach var="o" items="${order}">
					<tr>
						<td>${o.orderNumber}</td>
						<td>
							<img class="img" src="<c:url value="/resources/img/categoryMain/${o.productPicture}"/>">
						</td>
						<td>${o.productName}</td>
						<td>${o.orderDate}</td>
						<td><fmt:formatNumber value="${o.productPrice}"/>원</td>
						<td class="click" onclick="window.open('<c:url value='/admin/memberDetails/${o.sellerNumber}'/>','memberDetails','width=600,height=850')">${o.sellerNickname}</td>
						<td class="click" onclick="window.open('<c:url value='/admin/memberDetails/${o.memberNumber}'/>','memberDetails','width=600,height=850')">${o.memberNickname}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="totalPrice">총 거래금액 : <fmt:formatNumber value="${totalPrice}"/>원</div>
		</div>
	</div>
</body>
<jsp:include page="../Footer.jsp" />
</body>
</html>