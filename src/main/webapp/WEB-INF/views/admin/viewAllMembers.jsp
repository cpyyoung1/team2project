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
<title>ADMIN PAGE</title>
<link href="<c:url value="/resources/css/viewAllMembers.css"/>"
	rel='stylesheet' />
</head>
<script>
function deleteMember(){
    alert("정말로 삭제하시겠습니까?");
}    

function searchID(){
	var searchID = document.getElementById("searchID").value;
	location.href= "<c:url value='/admin/searchMember?memberId="+searchID+"'></c:url>"
}


</script>
<body>
	<jsp:include page="../Header.jsp" />
	<div class="main">
		<div class="container">
			<div id="title2">
				<strong>view</strong> all members
			</div>
			<div class="searchId">
				회원 검색 : <input type="text" name="searchID" id="searchID" placeholder="ID를 입력해주세요.">
				<input id="btn" type="button" value="검색" onclick="return searchID()">
			</div>
			<table class="tbl" border="1">
				<tr class="property">
					<td>num</td>
					<td>name</td>
					<td>id</td>
					<td>nickname</td>
					<td>point</td>
					<td>details</td>
				</tr>
				<c:forEach var="m" items="${members}">
					<tr>
						<td>${m.memberNumber}</td>
						<td>${m.memberName}</td>
						<td>${m.memberId}</td>
						<td>${m.memberNickname}</td>
						<td><fmt:formatNumber value="${m.memberPoint}"/>원</td>
						<td class="click"
							onclick="window.open('<c:url value='/admin/memberDetails/${m.memberNumber}'/>','memberDetails','width=600,height=850')">click</td>
					</tr>
				</c:forEach>
			</table>
			<div id="miniSize"><strong>TOTAL</strong> : ${num}명</div>
		</div>
	</div>
</body>
<jsp:include page="../Footer.jsp" />
</html>