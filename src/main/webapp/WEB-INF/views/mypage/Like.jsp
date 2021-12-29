<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찜목록</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/mypage.css"/>" rel='stylesheet' />
</head>
<body>
<jsp:include page="../Header.jsp"/>
<div class="container">
	<div class="mypage-wrap">
		<div class="mypage-header clear">
			<h2 class="fl">찜목록</h2>
			<div class="mypage-modify fr">
				<button class="btn-form2" onclick="location.href='<c:url value='/mypage/MypageMain'/>'">뒤로가기</button>
			</div>
		</div>
		<div class="note-area">
			<div class="like-area clear">
				<ul>
				<c:forEach var="like" items="${like}">
				<c:if test="${like.memberNumber == authInfo.memberNumber}">
					<li class="like-item">
						<div class="purchase-list-info clear likeList">
							<a href="#" class="fl"><img class="like-pic" src="<c:url value="/resources/img/categoryMain/${like.productPicture}"/>"></a>
							<div class="like-info">
								<div class="like-name">
									<a href="#">${like.productName}</a>
								</div>
								<div class="like-writer">
									<span>${like.sellerNickname}</span>
								</div>
								<div>
									<span class="like-price"><fmt:formatNumber value="${like.productPrice}"/>원</span>
								</div>
								<div>
                                        <input class="like-btn" type="button" value="자세히" onclick="location.href='<c:url value='/product/productDetails/${like.productNumber}'/>'">
                                        <input class="like-btn" type="button" value="삭제" onclick="location.href='<c:url value='/mypage/deleteLike/${like.likeNumber}'/>'">
                                    </div>
							</div>
						</div>	
					</li>	
					</c:if>
					</c:forEach>
				</ul>
			</div>	
		</div>	
	</div>	
	
</div>
<jsp:include page="../Footer.jsp"/>
</body>
</html>