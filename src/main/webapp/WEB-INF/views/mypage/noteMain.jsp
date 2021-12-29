<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NOTE</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/mypage.css"/>" rel='stylesheet' />
</head>
<body>
   <jsp:include page="../Header.jsp" />
   <div class="container">
      <div class="mypage-wrap">
         <div class="mypage-header clear">
            <c:if test="${authInfo.memberGrade!=0}">
               <h2 class="fl"><a href="mypage/noteMain">쪽지함</a></h2>
            </c:if>
            <c:if test="${authInfo.memberGrade==0}">
               <h2 class="fl">1 : 1 문의사항</h2>
            </c:if>
            <div class="mypage-modify fr">
               <button class="btn-form2" onclick="window.history.back()">뒤로가기</button>
            </div>
         </div>
         <!-- class="mypage-header" -->
         <div class="note-area">
            <c:if test="${authInfo.memberGrade!=0}">
               <div class="btn-class-r">
                  <button class="btn-form2 fr"
                     onclick="location.href='<c:url value='/mypage/noteSend/${readMsg.mno}'/>'">쪽지쓰기</button>
               </div>
            </c:if>
            <div class="note-list-header">
               <strong onclick="location.href='allReciveList.do'">받은 쪽지<span></span></strong>
            </div>
            <div class="note-list">
               <table border="1">
                  <colgroup>
                     <col style="width: 88px">
                     <col style="width: 620px">
                     <col style="width: 125px">
                     <col style="width: 80px">
                  </colgroup>
                  <thead>
                     <tr>
                        <th>보낸사람</th>
                        <th>내용</th>
                        <th>날짜</th>
                        <th>삭제</th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach var="msg" begin="0" end="5" items="${msgList}">
                     <c:if test="${msg.reciver == authInfo.memberId}">
                        <tr>
                           <td>${msg.sender}</td>
                           <td class="msgHover" onclick="location.href='<c:url value='/mypage/noteView/${msg.mno }'/>'">${msg.content }</td>
                           <td>${msg.regdate}</td>
                           <td><button class="btn-form-del" onclick = "location.href = '<c:url value='/mypage/msgDelete/${msg.mno }'/>'">삭제</button></td>
                        </tr>
                        </c:if>
                     </c:forEach>
                  </tbody>
               </table>
            </div>
            <!-- class="note-list" -->

            <div class="note-list-header">
               <strong onclick="location.href='allSendList.do'">보낸 쪽지<span></span></strong>
            </div>
            <div class="note-list">
               <table border="1" class="msgTbl">
                  <colgroup>
                     <col style="width: 88px">
                     <col style="width: 620px">
                     <col style="width: 125px">
                     <col style="width: 80px">
                  </colgroup>
                  <thead>
                     <tr>
                        <th>받는사람</th>
                        <th>내용</th>
                        <th>날짜</th>
                        <th>삭제</th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach var="msg" begin="0" end="5" items="${msgList}">
                     <c:if test="${msg.sender == authInfo.memberId}">
                        <tr>
                           <td>${msg.reciver}</td>
                           <td class="msgHover" onclick="location.href='<c:url value='/mypage/noteView/${msg.mno }'/>'">${msg.content }</td>
                           <td>${msg.regdate}</td>
                           <td><button class="btn-form-del" onclick = "location.href = '<c:url value='/mypage/msgDelete/${msg.mno }'/>'">삭제</button></td>
                        </tr>
                        </c:if>
                     </c:forEach>
                  </tbody>
               </table>
            </div>
            <!-- class="note-list" -->

         </div>
         <!-- class="note-area" -->
      </div>
      <!-- class="mypage-wrap" -->
   </div>
   <!-- class="container" -->
   <jsp:include page="../Footer.jsp" />
</body>
</html>