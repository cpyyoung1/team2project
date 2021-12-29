<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
<script src='<c:url value="/resources/js/HideToggle.js"/>'></script>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/mypage.css"/>" rel='stylesheet' />
</head>
<body>
<jsp:include page="../Header.jsp"/>
<div class="container">
   <div class="mypage-wrap">
      <div class="mypage-header clear">
         <h2 class="fl">내 정보 수정</h2>
         <div class="mypage-modify fr">
            <button class="btn-form2" onclick="window.history.back()">뒤로가기</button>
         </div>
      </div>   <!-- class="mypage-header" -->
      <div class="note-area">
         <div class="modify-list clear">
            <ul>
               <li>
                  <div class="modify-info">
                     <div class="modify-info-element fl">
                        <h2>아이디</h2>
                     </div>
                     <div class="modify-info-value fl">
                        <h3>${authInfo.memberId}</h3>
                     </div>
                  </div>
               </li>
               <li>
               <form:form action="modifyPw" commandName="modifyPass">
                  <div class="modify-info" onclick="menu_toggle(this)">
                     <div class="modify-info-element fl">
                        <h2>비밀번호 *</h2>
                     </div>
                     <div class="modify-info-value fl">
                        <h3>*******</h3>
                        <span class="error"><form:errors /></span>
                     </div>
                  </div>
                  <div class="modify-info-inner hide">
                      <input type="hidden" name="memberId" value="${authInfo.memberId}">
                     <div class="modify-info-input">
                        <label for="currentPassword">현재 비밀번호</label>
                        <input type="password" class="m-input" name="currentPassword">
                        <span class="error"><form:errors path="currentPassword" /></span>
                     </div>
                     <div class="modify-info-input">
                        <label for="newPassword">신규 비밀번호</label>
                        <input type="password" class="m-input" name="newPassword">
                        <span class="error"><form:errors path="newPassword" /></span>
                     </div>
                     <div class="modify-info-input">
                        <label for="confirmPassword">비밀번호 확인</label>
                        <input type="password" class="m-input" name="confirmPassword">
                        <span class="error"><form:errors path="confirmPassword" /></span>
                     </div>
                     <div class="modify-info-input">
                        <input type="submit" class="btn-form2" value="완료">
                     </div>
                  </div>
                  </form:form>
               </li>
               <li>
                  <div class="modify-info">
                     <div class="modify-info-element fl">
                        <h2>연락처</h2>
                     </div>
                     <div class="modify-info-value fl">
                        <h3>${authInfo.memberTel}</h3>
                     </div>
                  </div>
               </li>
               <li>
                  <div class="modify-info">
                     <div class="modify-info-element fl">
                        <h2>이름</h2>
                     </div>
                     <div class="modify-info-value fl">
                        <h3>${authInfo.memberName}</h3>
                     </div>
                  </div>
               </li>
               <li>
               <form:form action="modifyNick" commandName="modifyNic">
                  <div class="modify-info" onclick="menu_toggle(this)">
                     <div class="modify-info-element fl">
                        <h2>닉네임 *</h2>
                     </div>
                     <div class="modify-info-value fl">
                        <h3>${authInfo.memberNickname}</h3>
                        <span class="error"><form:errors /></span>
                     </div>
                  </div>
                  <div class="modify-info-inner hide">
                  <input type="hidden" name="memberId" value="${authInfo.memberId}">
                     <div class="modify-info-input">
                        <label for="nickname">닉네임</label>
                        <input type="text" class="m-input" name="memberNickname" placeholder="닉네임을 입력해 주세요">
                        <span class="error"><form:errors path="memberNickname" /></span>
                     </div>
                     <div class="modify-info-input">
                        <input type="submit" class="btn-form2" value="완료">
                     </div>
                  </div>
                  </form:form>
               </li>
               <li>
               <form:form action="modifyAddress" commandName="modifyAddr">
                  <div class="modify-info" onclick="menu_toggle(this)">
                     <div class="modify-info-element fl">
                        <h2>주소 *</h2>
                     </div>
                     <div class="modify-info-value fl">
                        <h3>${authInfo.memberAddress}</h3>
                        <span class="error"><form:errors /></span>
                     </div>
                  </div>
                  <div class="modify-info-inner hide">
                  <input type="hidden" name="memberId" value="${authInfo.memberId}">
                     <div class="modify-info-input">
                        <label for="memberAddress">주소</label>
                        <input type="text" class="m-input" name="memberAddress" placeholder="주소를 입력해 주세요">
                        <span class="error"><form:errors path="memberAddress" /></span>
                     </div>
                     <div class="modify-info-input">
                        <input type="submit" class="btn-form2" value="완료">
                     </div>
                  </div>
                  </form:form>
               </li>
            </ul>
         </div>
      </div>      <!-- class="mypage-area" -->
   </div>      <!-- class="mypage-wrap" -->
</div>   <!-- class="container" -->
<jsp:include page="../Footer.jsp"/>
</body>
</html>