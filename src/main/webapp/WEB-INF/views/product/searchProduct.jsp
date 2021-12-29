<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 찾기</title>
<link href="<c:url value="/resources/css/searchProduct.css"/>" rel='stylesheet' />
</head>
<script>
function searchProduct(){
	  if(document.getElementById("searchProduct").value.length == 0){
	        alert('검색하고자하는 제품 이름을 입력해주세요.');
	        document.getElementById("searchProduct").focus();
	        return false;
	    }
	var searchProduct = document.getElementById("searchProduct").value;
	location.href= "<c:url value='/product/searchProduct?searchProduct="+searchProduct+"'></c:url>"
}
</script>
<body>
<div class="searchProduct" id="top">
				<span id="sText">search : </span><input type="text" name="searchProduct" id="searchProduct"  value="${searchProductName}">
				<input id="btn" type="button" value="CLICK" onclick="return searchProduct()">
			</div>
			<div id="result">${msg}</div>
<div class="main">
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
				</c:forEach>
			</div>
		</div>
        </div>
</body>
</html>