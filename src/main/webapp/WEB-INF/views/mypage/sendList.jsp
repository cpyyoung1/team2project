<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보낸 편지함</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/community.css"/>" rel='stylesheet' />
</head>

<body>
<jsp:include page="../Header.jsp"/>
<div class="container">
   <div class="community-wrap">
      <div class="content-area">
         <div class="community-wrap">
             <div class="note-list-header">
               <strong onclick="location.href='allSendList.do'">보낸 쪽지<span></span></strong> 
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
                        <th>받는 사람</th>
                        <th>내용</th>
                        <th>날짜</th>
                        <th>삭제</th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach var="msg" items="${msgList}">
                     <c:if test="${msg.sender == authInfo.memberId}">
                        <tr>
                           <td>${msg.reciver}</td>
                           <td onclick="location.href='<c:url value='/mypage/noteView/${msg.mno }'/>'">${msg.content }</td>
                           <td>${msg.regdate}</td>
                           <td><button class="btn-form-del" onclick = "location.href = '<c:url value='/mypage/msgDelete/${msg.mno }'/>'">삭제</button></td>
                        </tr>
                        </c:if>
                     </c:forEach>
                  </tbody>
               </table>
            </div>
            <!-- class="note-list" -->       

         </div>               <!-- class="community-wrap" -->
      </div>               <!-- class="content-area" -->
   </div>                <!-- class="community-wrap" -->
</div>
<jsp:include page="../Footer.jsp"/>
</body>
</html>