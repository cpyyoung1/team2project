<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매목록</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/mypage.css"/>" rel='stylesheet' />
</head>
<body>
<jsp:include page="../Header.jsp"/>
<div class="container">
	<div class="mypage-wrap bigBox">
		<div class="mypage-header clear">
			<h2 class="fl">구매내역 조회</h2>
			<div class="mypage-modify fr">
				<button class="btn-form2" onclick="window.history.back()">뒤로가기</button>
			</div>
		</div>
		<div class="note-area">
			<div class="purchase-list">
				<table border="1">
					<colgroup>
						<col style="width:150px">
						<col style="width:500px">
						<col style="width:125px">
						<col style="width:125px">
					</colgroup>
					<thead>
						<tr>
							<th>주문번호</th>
							<th>상품정보</th>
							<th>구매날짜</th>
							<th>구매가격</th>
						</tr>
					</thead>
					<tbody class="orderList">
					<c:forEach var="o" items="${order}">
					<c:if test="${o.memberNumber == authInfo.memberNumber}">
						<tr>
							<td>${o.orderNumber}</td>
							<td>
								<div class="purchase-list-info clear orderBox">
									<a href="#" class="fl"><img class="purchase-list-pic" src="<c:url value="/resources/img/categoryMain/${o.productPicture}"/>"></a>
									<a href="#" class="purchase-list-name">${o.productName}</a>
								</div>
							</td>
							<td>${o.orderDate}</td>
							<td><fmt:formatNumber value="${o.productPrice}"/> 원</td>
						</tr>
						</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>	
		</div>	
	</div>	
	<div class="mypage-wrap bigBox">
		<div class="mypage-header clear">
			<h2 class="fl">판매내역 조회</h2>
		</div>
		<div class="note-area">
			<div class="purchase-list">
				<table border="1">
					<colgroup>
						<col style="width:150px">
						<col style="width:500px">
						<col style="width:125px">
						<col style="width:125px">
					</colgroup>
					<thead>
						<tr>
							<th>주문번호</th>
							<th>상품정보</th>
							<th>판매날짜</th>
							<th>판매가격</th>
						</tr>
					</thead>
					<tbody class="orderList">
				<c:forEach var="o" items="${order}">
					<c:if test="${o.sellerNumber == authInfo.memberNumber}">
						<tr>
							<td>${o.orderNumber}</td>
							<td>
								<div class="purchase-list-info clear orderBox">
									<a href="#" class="fl"><img class="purchase-list-pic" src="<c:url value="/resources/img/categoryMain/${o.productPicture}"/>"></a>
									<a href="#" class="purchase-list-name">${o.productName}</a>
								</div>
							</td>
							<td>${o.orderDate}</td>
							<td><fmt:formatNumber value="${o.productPrice}"/> 원</td>
						</tr>
						</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>	
		</div>	
	</div>	
</div>	<!-- class="container" -->
<jsp:include page="../Footer.jsp"/>
</body>
</html>