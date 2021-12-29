<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NOTE SEND</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/mypage.css"/>" rel='stylesheet' />
 <script src='<c:url value="/resources/js/chkReciver.js"/>'></script>
</head>
<body>
<jsp:include page="../Header.jsp"/>

<div class="container">
   <div class="mypage-wrap">
   
      <form action="send" method="POST">
      <div class="mypage-header clear">
         <h2 class="fl">쪽지보내기</h2>
         <div class="mypage-modify fr">
            <input type="submit" class="btn-form2" value="전송" onclick="return chkReciver()">
          <button type="button" class="btn-form2" onclick="location.href='<c:url value='/mypage/noteMain'/>'">뒤로가기</button>
         </div>
      </div>   <!-- class="mypage-header" -->
      <div class="note-area">
         <div class="note-header clear">   
            <div class="note-info">
               <h2 class="fl">받는사람</h2>
               <div>
                  <textarea class="title-input" name="reciver" id="reciver"></textarea>
               </div>
            </div>
         </div>
         <div class="note-content">
            <textarea class="content-input" name="content" id="content"></textarea>
         </div>
      </div>
      <input type="hidden" name="sender" value="${authInfo.memberId}">
      </form>
      
   </div>   <!-- class="mypage-wrap" -->
</div>
<jsp:include page="../Footer.jsp"/>
</body>
</html>