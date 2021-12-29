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
               <span>자유게시판</span>
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
                           <th>조회</th>
                        </tr>
                     </thead>
                     <tbody>
                        <tr>
                           <td>123</td>
                           <strong><td id="boardNotice" onclick="location.href='<c:url value='/community/BoardNotice'/>'">게시판관련 공지사항입니다.</td></strong>
                           <td>관리자</td>
                           <td>2020.10.31</td>
                           <td>2313</td>
                        </tr>
                     </tbody>
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
                     <c:forEach var="list" items="${list}">
                        <tr>
                           <td>${list.bno}</td>
                           <td class="titlehover" onclick="location.href='<c:url value='/community/CommunityView/${list.bno}'/>'">${list.title}</td>
                           <td>${list.id}</td>
                           <td>${list.regDate}</td>
                           <td>${list.viewCnt}</td>
                        </tr>
                        </c:forEach>
                     </tbody>
                  </table>
               </div>            <!-- class="content-board-area" -->
               <div class="control-area clear">
               <!--  
                  <div class="page-navi">
                     <div class="wrapper">
                        <a><</a>
                        <a class="active">1</a>
                        <a>2</a>
                        <a>3</a>
                        <a>4</a>
                        <a>5</a>
                        <a>6</a>
                        <a>7</a>
                        <a>8</a>
                        <a>9</a>
                        <a>10</a>
                        <a>></a>
                     </div>
                  </div>
                  -->
                  <div>
                  <c:if test="${not empty authInfo.memberId}">
                     <a href="CommunityInsert" class="btn-form2 fr">글쓰기</a>
                     </c:if>
                  </div>
               </div>            <!-- class="control-area" -->
               
               
               
            </div>               <!-- class="content-board" -->
         </div>               <!-- class="community-wrap" -->
      </div>               <!-- class="content-area" -->
   </div>                <!-- class="community-wrap" -->
</div>
<jsp:include page="../Footer.jsp"/>
</body>
</html>