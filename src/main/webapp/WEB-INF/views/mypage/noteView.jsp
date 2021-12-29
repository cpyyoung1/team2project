<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NOTE VIEW</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/mypage.css"/>" rel='stylesheet' />
</head>
<body>
<jsp:include page="../Header.jsp"/>
<div class="container">
   <div class="mypage-wrap">
      <div class="mypage-header clear">
      <c:if test="${authInfo.memberGrade!=0}">
         <h2 class="fl">쪽지함</h2>
      </c:if>
      <c:if test="${authInfo.memberGrade==0}">
         <h2 class="fl">1 : 1 문의사항</h2>
      </c:if>
         <div class="mypage-modify fr">
         <c:if test="${authInfo.memberId != readMsg.sender}">
         <button onclick="window.open('<c:url value='/product/message/${readMsg.sender}'/>','msg','width=500,height=400')"class="btn-form2">답장</button>
         </c:if>
         <button onclick="location.href='<c:url value='/mypage/msgDelete/${readMsg.mno}'/>'" class="btn-form2">삭제</button>
            <button class="btn-form2" onclick="window.history.back()">뒤로가기</button>
         </div>
      </div>      <!-- class="mypage-header" -->
      <div class="note-area">
         <div class="note-header clear">
            <div class="note-info">
             <c:if test="${authInfo.memberId == readMsg.sender}">
             <h2 class="fl">받는사람</h2><h3 class="fl">${readMsg.reciver}</h3>
             </c:if>
             <c:if test="${authInfo.memberId != readMsg.sender}">
               <h2 class="fl">보낸사람</h2><h3 class="fl">${readMsg.sender}</h3>
             </c:if>
            </div>
            <div class="note-info">
               <h2 class="fl">받은시간</h2><h3 class="fl">${readMsg.regdate }</h3>
            </div>
         </div>
         <div class="note-content">
            ${readMsg.content}
         </div>
      </div>
   </div>   <!-- class="mypage-wrap" -->
</div>   <!-- class="container" -->
<jsp:include page="../Footer.jsp"/>
</body>
</html>