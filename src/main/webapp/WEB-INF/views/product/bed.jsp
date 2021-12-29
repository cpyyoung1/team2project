<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SOFA / CHAIR</title>
<link href="<c:url value="/resources/css/productView.css"/>"
	rel='stylesheet' />
</head>

<body>
	<div class="main" id="top">
		<div class="hBar">
			<div id="title">bed / mattress</div>
			<div>
				<ul class="productUl">
					<li class="bList"><a href="<c:url value='/product/1'/>">sofa&chair</a></li>
					<li class="bList now"><a href="<c:url value='/product/2'/>">bed</a></li>
					<li class="bList"><a href="<c:url value='/product/3'/>">table</a></li>
					<li class="bList"><a href="<c:url value='/product/4'/>">lighting</a></li>
					<li class="bList"><a href="<c:url value='/product/5'/>">drawer</a></li>
					<li class="bList"><a href="<c:url value='/product/6'/>">acc</li>
					</a>
				</ul>
			</div>
		</div>
		<div class="sidebar">
            <div class="btn" onclick="location.href='${pageContext.request.contextPath}/main'">
                main
            </div>
            <a id="up" href="#top"><div class="btn">
                top
            </div></a>
            <c:if test="${authInfo != null && authInfo.memberGrade == 1}">
            <div class="btn" onclick="location.href='<c:url value="/product/productRegistration"/>'">sell</div>
        	</c:if>
        </div>
		<div class="container">
			<div class="bigBox">
				<c:forEach var="p" items="${products}">
					<c:if test="${p.categoryNumber==2}">
						<div class="box">
							<a
								href="<c:url value='/product/productDetails/${p.productNumber}'/>">
								<img class="productPictureName"
								src="<c:url value="/resources/img/categoryMain/${p.productPictureNameURL}"/>">
								<span class="text">click me</span>
								<div class="productName">${p.productName}</div>
								<div class="productPrice"><fmt:formatNumber value="${p.productPrice}"/>원</div>
							</a>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
	<jsp:include page="../Footer.jsp" />
</body>

</html>