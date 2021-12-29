<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COMMUNITY</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/community.css"/>" rel='stylesheet' />
</head>

<body>
<jsp:include page="../Header.jsp"/>
<div class="container">
   <div class="community-wrap">
      <div class="content-area">
         <div class="community-wrap">
            <div class="content-header">
               <span>문의 답변</span>
            </div>
            <div class="content-board">
               <div class="content-board-area-notice">
                  <table>
                     <colgroup>
                        <col style="width:88px">
                        <col style="width:508px">
                        <col style="width:118px">
                        <col style="width:80px">
                        <col style="width:68px">
                     </colgroup>
                     <thead>
                        <tr>
                           <th>글번호</th>
                           <th>제목</th>
                           <th>작성자</th>
                           <th>작성일</th>     
                        </tr>
                     </thead>
                  </table>
               </div>            <!-- class="content-board-area-notice" -->
               <div class="content-board-area">
                  <table>
                     <colgroup>
                        <col style="width:88px">
                        <col style="width:508px">
                        <col style="width:118px">
                        <col style="width:80px">
                        <col style="width:68px">
                     </colgroup>
                     <tbody>
                     <c:forEach var="qaList" items="${qaList}">
                        <tr>
                           <td>${qaList.qaNum}</td>
                           <td class="titlehover" onclick="location.href='<c:url value='/support/supportView/${qaList.qaNum}'/>'">${qaList.faqContent}</td>
                           <td>${qaList.qid}</td>
                           <td>${qaList.regDate}</td>
                        </tr>
                        </c:forEach>
                     </tbody>
                  </table>
               
               
               </div>
            </div>               <!-- class="content-board" -->
         </div>               <!-- class="community-wrap" -->
      </div>               <!-- class="content-area" -->
   </div>                <!-- class="community-wrap" -->
</div>
<jsp:include page="../Footer.jsp"/>
</body>
</html>