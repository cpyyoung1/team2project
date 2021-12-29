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
         <h2 class="fl">문의 글</h2>
      </c:if>
      <c:if test="${authInfo.memberGrade==0}">
         <h2 class="fl">1 : 1 문의사항</h2>
      </c:if>
         <div class="mypage-modify fr">
         <button onclick="window.open('<c:url value='/product/message/${readQA.qid}'/>','msg','width=500,height=400')"class="btn-form2">답장</button>
         <button onclick="location.href='<c:url value='/support/deleteQA/${readQA.qaNum }'/>'" class="btn-form2">삭제</button>
            <button type="button" class="btn-form2" onclick="location.href='<c:url value='/support/SupportMain'/>'">뒤로가기</button>
         </div>
      </div>      <!-- class="mypage-header" -->
      <div class="note-area">
         <div class="note-header clear">
            <div class="note-info">
               <h2 class="fl">보낸사람</h2><h3 class="fl">${readQA.qid}</h3>
            </div>
            <div class="note-info">
               <h2 class="fl">받은시간</h2><h3 class="fl">${readQA.regDate }</h3>
            </div>
         </div>
         <div class="note-content">
            ${readQA.faqContent}
         </div>
      </div>
   </div>   <!-- class="mypage-wrap" -->
</div>   <!-- class="container" -->
<jsp:include page="../Footer.jsp"/>
</body>
</html>