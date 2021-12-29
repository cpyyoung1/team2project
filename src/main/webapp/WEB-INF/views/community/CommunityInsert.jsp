<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COMMUNITY INSERT</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/community.css"/>" rel='stylesheet' />
</head>
<body>
<div class="container">
   <jsp:include page="../Header.jsp"/>
      <div class="community-wrap">
         <div class="content-area">
            <div class="community-wrap">
            
            <form action="write" method="POST">
            <input type="hidden" value="${authInfo.memberId}" name="Id">
               <div class="content-header">
                  <span>자유게시판</span> <!-- 게시판 종류 --> 
               </div>                        <!-- class="content-header" -->
               <div class="content-writer">
                  <div style="height:60px">
                     <textarea class="title-input" id="" name="title" placeholder="제목을 입력해 주세요."></textarea>
                  </div>
                  <div>
                     <textarea class="content-input" id="" name="content" placeholder="내용을 입력해 주세요."></textarea>
                  </div>
                  <div class="view-control-area">
                     <a href="/comunity/CommunityList" class="btn-form fr">취소</a>
                     <input type="submit" class="btn-form2 fr" value="등록">
                  </div>                        <!-- class="view-control-area" -->
               </div>                        <!-- class="content-writer" -->
               
            </form>
               
            </div>                        <!-- class="community-wrap" -->
         
         </div>                        <!-- class="content-area" -->
      </div>                         <!-- class="community-wrap" --> 
      
   <jsp:include page="../Footer.jsp"/>
</div> <!-- class="container" --> 

</body>
</html>