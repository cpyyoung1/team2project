<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 글 조회</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/mypage.css"/>" rel='stylesheet' />
</head>
<body>
<jsp:include page="../Header.jsp"/>
<div class="container">
	<div class="mypage-wrap">
		<div class="mypage-header clear">
			<h2 class="fl">내 글 조회</h2>
			<div class="mypage-modify fr">
				<button class="btn-form2" onclick="window.history.back()">뒤로가기</button>
			</div>
		</div>
		<div class="note-area">
			<div class="note-list-header">
				<strong>자유게시판<span></span></strong>
			</div>
			<div class="myboardlist">
				<table>
					<colgroup>
						<col style="width:75px">
						<col style="width:500px">
						<col style="width:100px">
						<col style="width:100px">
					</colgroup>
					<thead>
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>작성일</th>
							<th>조회</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="list" items="${list}">
					<c:if test="${list.id == authInfo.memberId}">
						<tr>
							<td>${list.bno}</td>
							<td>
								<div class="inner-list">
									<a href="<c:url value='/community/CommunityView/${list.bno}'/>">${list.title}</a>
									<a class="cmt"></a>
								</div>
							</td>
							<td>${list.regDate}</td>
							<td>${list.viewCnt}</td>
						</tr>
					</c:if>
					</c:forEach>
						<!-- 
						<tr>
							<td>14</td>
							<td>
								<div class="inner-list">
									<a href="#">TITLE13</a>
									<a class="cmt">[1]</a>
								</div>
							</td>
							<td>2020/11/12</td>
							<td>535</td>
						</tr>
						<tr>
							<td>15</td>
							<td>
								<div class="inner-list">
									<a href="#">TITLE22</a>
									<a class="cmt">[3]</a>
								</div>
							</td>
							<td>2020/11/12</td>
							<td>535</td>
						</tr>
						 -->
					</tbody>
				</table>
			</div>		<!-- class="myboardlist" -->
			
			
			<div class="note-list-header">
				<strong>상품목록<span></span></strong>
			</div>
			<div class="like-area clear">
				<ul>
					<c:forEach var="p" items="${product}">
					<c:if test="${p.memberNumber == authInfo.memberNumber}">
					<li class="like-item">
						<div class="purchase-list-info clear">
							<a href="<c:url value='/product/productDetails/${p.productNumber}'/>" class="fl"><img class="like-pic" src="<c:url value="/resources/img/categoryMain/${p.productPictureNameURL}"/>"></a>
							<div class="like-info">
								<div class="like-name">
									<a href="#">${p.productName}</a>
								</div>
								<div class="like-writer">
									<span>${p.productDate}</span>
								</div>
								<div>
									<span class="like-price">${p.productPrice}원</span>
								</div>
							</div>
						</div>
					</li>	
					</c:if>
					</c:forEach>
					<!--  <li class="like-item">
						<div class="purchase-list-info clear">
							<a href="#" class="fl"><img class="like-pic" src="<c:url value="/resources/img/item2.jpg"/>"></a>
							<div class="like-info">
								<div class="like-name">
									<a href="#">의자</a>
								</div>
								<div class="like-writer">
									<span>DOWNER</span>
								</div>
								<div>
									<span class="like-price">350,500원</span>
								</div>
							</div>
						</div>	
					</li>	
					<li class="like-item">
						<div class="purchase-list-info clear">
							<a href="#" class="fl"><img class="like-pic" src="<c:url value="/resources/img/item1.jpg"/>"></a>
							<div class="like-info">
								<div class="like-name">
									<a href="#">의자</a>
								</div>
								<div class="like-writer">
									<span>DOWNER</span>
								</div>
								<div>
									<span class="like-price">350,500원</span>
								</div>
							</div>
						</div>	
					</li>	
					<li class="like-item">
						<div class="purchase-list-info clear">
							<a href="#" class="fl"><img class="like-pic" src="<c:url value="/resources/img/item2.jpg"/>"></a>
							<div class="like-info">
								<div class="like-name">
									<a href="#">의자</a>
								</div>
								<div class="like-writer">
									<span>DOWNER</span>
								</div>
								<div>
									<span class="like-price">350,500원</span>
								</div>
							</div>
						</div>	
					</li>	
					<li class="like-item">
						<div class="purchase-list-info clear">
							<a href="#" class="fl"><img class="like-pic" src="<c:url value="/resources/img/item1.jpg"/>"></a>
							<div class="like-info">
								<div class="like-name">
									<a href="#">의자</a>
								</div>
								<div class="like-writer">
									<span>DOWNER</span>
								</div>
								<div>
									<span class="like-price">350,500원</span>
								</div>
							</div>
						</div>	
					</li>-->	<!-- class="like-item" -->
				</ul>
			</div>	<!-- class="like-area" -->
			
			
			
		</div>		<!-- class="note-area" -->
	</div>		<!-- class="mypage-wrap" -->
</div>	<!-- class="container" -->
<jsp:include page="../Footer.jsp"/>
</body>
</html>