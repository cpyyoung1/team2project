<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원상세정보</title>
     <link href="<c:url value="/resources/css/memberDetails.css"/>" rel='stylesheet' />
</head>
<script>
	function confirm(){
		alert('정말로 삭제하시겠습니까?');
		/*location.href='<c:url value='/admin/delete/${member.memberNumber}'/>';*/
		window.open('<c:url value='/admin/delete/${member.memberNumber}'/>','allMemberViews');
	}
	
</script>

<body>
    <div class="main">
        <div class="container">
            <div id="title">member details</div>
            <div>
                <ol>
                    <li>
                    <c:if test="${member.memberProfile==null}">
                        <img id="memberProfile" src="<c:url value="/resources/img/memberprofile.png"/>">
                    </c:if>
                     <c:if test="${member.memberProfile!=null}">
                        <img id="memberProfile" src="<c:url value="/resources/img/${member.memberProfile}"/>">
                    </c:if>
                    </li>
                    <li>
                        <strong>num</strong> : ${member.memberNumber}
                    </li>
                    <li>
                        <strong>name</strong> : ${member.memberName}
                    </li>
                    <li>
                        <strong>id</strong> : ${member.memberId}
                    </li>
                    <li>
                        <strong>tel</strong> : ${member.memberTel}
                    </li>
                    <li>
                        <strong>address</strong> : ${member.memberAddress}
                    </li>
                    <li>
                        <strong>nickname</strong> : ${member.memberNickname}
                    </li>
                    <li>
                        <strong>point</strong> : <fmt:formatNumber value="${member.memberPoint}"/>원
                    </li>
                    <li class="btns">
                        <input class="btn" type="button" value="send a message" onclick="window.open('<c:url value='/product/message/${member.memberId}'/>','msg','width=500,height=400')">
                        <input class="btn" type="button" value="delete a member" onclick="return confirm()">
                    </li>
                </ol>
            </div>
        </div>
    </div>


</body>

</html>