<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PRODUCT</title>
    <link href="<c:url value="/resources/css/productMain.css"/>" rel='stylesheet' />
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
	<div class="searchProduct">
				<span id="sText">search : </span><input type="text" name="searchProduct" id="searchProduct">
				<input id="btn" type="button" value="CLICK" onclick="return searchProduct()">
			</div>
	<div class="main">
    <marquee id="tText">PUBLICITÉS, CONTENU DE MARQUE, CONTENU ÉDITORIAL, MOTION DESIGN ET PLUS.</marquee>
	<div id="main">
        <div class="container1">
            <div class="category" id="sofa">
                <img src="<c:url value="/resources/img/categoryMain/sofa.jpg"/>" alt="sofa" class="cImg"><!-- ../img/categoryMain/sofa.jpg -->
                <div class="cText"><a class="cLink" href="<c:url value='/product/1'/>">sofa / chair</a></div>
            </div>
            <div class="category" id="table">
                <img src="<c:url value="/resources/img/categoryMain/table0.jpg"/>" alt="table" class="cImg">
                <div class="cText"><a class="cLink" href="<c:url value='/product/3'/>">table</a></div>
            </div>
            <div class="category" id="drawer">
                <img src="<c:url value="/resources/img/categoryMain/acceptance.jpg"/>" alt="drawer" class="cImg">
                <div class="cText"><a class="cLink" href="<c:url value='/product/5'/>">drawer</a></div>
            </div>
        </div>
        <div class="container1">
            <div class="category" id="bed">
                <img src="<c:url value="/resources/img/categoryMain/bed.jpg"/>" alt="bed" class="cImg">
                <div class="cText"><a class="cLink" href="<c:url value='/product/2'/>">bed / mattress</a></div>
            </div>
            <div class="category" id="lighting">
                <img src="<c:url value="/resources/img/categoryMain/lighting.jpg"/>" alt="lighting" class="cImg">
                <div class="cText"><a class="cLink" href="<c:url value='/product/4'/>">lighting</a></div>
            </div>
            <div class="category" id="acc">
                <img src="<c:url value="/resources/img/categoryMain/rug2.jpg"/>" alt="acc" class="cImg">
                <div class="cText"><a class="cLink" href="<c:url value='/product/6'/>">acc</a></div>
            </div>
        </div>
    </div>
    </div>
    <jsp:include page="../Footer.jsp"/>
</body>

</html>