<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />   
<link href="<c:url value="/resources/css/mypage.css"/>" rel='stylesheet' />
</head>
<body>
<jsp:include page="../Header.jsp"/>
<div class="container">
   <div class="mypage-wrap">
      <div class="mypage-header clear">
         <h2 class="fl">MY PAGE</h2>
         <div class="mypage-modify fr">
            <button class="btn-form2" onclick="location.href='<c:url value='/mypage/ModifyInfo'/>'">내 정보 수정</button>
         </div>
      </div>
      <div class="mypage-area">
         <div class="info-area clear">
            <div class="info-box fl">
               <div class="info-tabl fl">
                  <h3>이름</h3>
                  <h3>닉네임</h3>
                  <h3>포인트</h3>
               </div>
               <div class="info-tabr fl">
                  <h3>${authInfo.memberName}</h3>
                  <h3>${authInfo.memberNickname}</h3>
                  <h3><fmt:formatNumber value="${authInfo.memberPoint}"/> 원</h3>
               </div>
               <button class="btn-form4" onclick="location.href='<c:url value='/mypage/Payment'/>'">포인트 충전</button>
            </div>   <!-- class="info-box" -->
            <div class="info-box fl">
               <div class="info-halfbox mailbox">
                  <div class="info-tabl fl">
                     <img src="<c:url value="/resources/img/email.png"/>">
                  </div>
                  <div class="info-tabr fr" onclick="location.href='<c:url value='/mypage/noteMain'/>'">
                     <h2>쪽지함</h2>
                     <h4>받은 쪽지 수 : <span>${reciveMsgCnt}</span></h4>
                  </div>
               </div>
               <div class="info-halfbox" onclick="location.href='<c:url value='/mypage/Like'/>'">
                  <div class="info-tabl fl">
                     <img src="<c:url value="/resources/img/heart.png"/>">
                  </div>
                  <div class="info-tabr fr">
                     <h2>찜목록</h2>
                  </div>
               </div>
            </div>      <!-- class="info-box" -->
            <div class="info-box fl">
               <div class="info-halfbox mailbox" onclick="location.href='<c:url value='/mypage/MyContent'/>'">
                  <div class="info-tabl fl">
                     <img src="<c:url value="/resources/img/document.png"/>">
                  </div>
                  <div class="info-tabr fr">
                     <h2>내 글 조회</h2>
                  </div>
               </div>
               <div class="info-halfbox" onclick="location.href='<c:url value='/mypage/purchaseList'/>'">
                  <div class="info-tabl fl">
                     <img src="<c:url value="/resources/img/layers.png"/>">
                  </div>
                  <div class="info-tabr fr">
                     <h2>구매&nbsp;/&nbsp;판매 내역 조회</h2>
                  </div>
               </div>
            </div>      <!-- class="info-box" -->
         </div>      <!-- class="info-area" -->
      </div>      <!-- class="mypage-area" -->
   </div>      <!-- class="mypage-wrap" -->
</div> <!-- class="container" -->
<jsp:include page="../Footer.jsp"/>
</body>
</html>