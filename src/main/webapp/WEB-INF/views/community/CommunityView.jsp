<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COMMUNITY VIEW</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/community.css"/>" rel='stylesheet' />
<script src='<c:url value="/resources/jquery/jquery-3.5.1.js"/>'></script>
<script src='<c:url value="/resources/jquery/jquery-ui.js"/>'></script>
</head>
<!-- <script>
   function confirm(){
      if(${authInfo.memberId}==${BoardVO.id}){
         if (confirm('정말 삭제하시겠습니까??') == true){    //확인
               location.href='<c:url value='/community/CommunityList/delete/${BoardVO.bno}'/>'
            }else{   //취소     retu
           rn;
            }
      }else{
         alert('본인 글만 삭제 가능합니다 .');}
      }
      
      //<a href="#" class="btn-form fr" onclick="location.href='<c:url value='/community/CommunityList/delete/${BoardVO.bno}'/>'">삭제</a>
      /*location.href='<c:url value='/admin/delete/${member.memberNumber}'/>';*/
   }
</script> -->
<body>
   <div class="container">
      <jsp:include page="../Header.jsp" />
      <div class="community-wrap">

         <div class="content-area">
            <div class="community-wrap">

               <div class="content-header">
                  <span>자유게시판</span>
                  <!-- 게시판 종류 -->
               </div>
               <div class="content-board">
                  <div class="content-view">
                     <div class="content-view-header clear">
                        <div class="view-title">
                           <span>${BoardVO.title}</span>
                        </div>
                        <div class="view-info">
                           <span class="info-id">${BoardVO.id}</span>
                           <div class="info-data">
                              <p>조회 ${BoardVO.viewCnt}</p>
                              <p>${BoardVO.regDate}</p>
                           </div>
                        </div>
                        <!-- class="view-info" -->
                     </div>
                     <!-- class="content-view-header" -->
                     <div class="content-view-box">${BoardVO.content}</div>
                     <div class="comment-wrap clear">
                        <div class="comment-header">
                           <h2>
                              댓글<span>${replyNum}</span>
                           </h2>
                        </div>
                        <%--  
                            <c:forEach var="list" items="${list}">
                        <tr>
                           <td>${list.bno}</td>
                           <td class="titlehover" onclick="location.href='<c:url value='/community/CommunityView/${list.bno}'/>'">${list.title}</td>
                           <td>${list.id}</td>
                           <td>${list.regDate}</td>
                           <td>${list.viewCnt}</td>
                        </tr>
                        </c:forEach> --%>
                        <ul class="comment-list">
                           <c:forEach var="list" items="${list}">
                              <li>
                                 <div class="comment-info clear">
                                    <div class="fl replyId">${list.id}</div>
                                    <div class="fl">${list.regDate}</div>
                                    <div class="comment-text fl">${list.content}</div>
                                    <c:if test="${list.id == authInfo.memberId}">
                                    <a href="<c:url value='/community/CommunityView/replydelete/${list.no}/${BoardVO.bno}'/>" class="fr">삭제</a>
                                    </c:if>
                                 </div>
                              </li>
                           </c:forEach>
                        </ul>
                     </div>
                  </div>
                  <!-- class="comment-wrap" -->

                  <form
                     action="${pageContext.request.contextPath}/community/replywrite"
                     method="POST">
                     <input type="hidden" value="${authInfo.memberId}" name="Id">
                     <input type="hidden" value="${BoardVO.bno}" name="bno">
                     <c:if test="${not empty authInfo.memberId}">
                        <div class="comment-writer">
                           <div class="comment-inbox">
                              <textarea name="content" class="DOC_TEXT"></textarea>
                              <div class="comment-inbox-btn">
                                 <span id="counter">(0/200)</span>
                                 <span> <input type="submit" value="등록" class="btn-form2 fr"></span>
                              </div>
                           </div>
                        </div>
                     </c:if>
                  </form>
               </div>
            </div>
         
         <div class="view-control-area clear"">
            <a href="#" class="btn-form fr" onclick="window.history.back()">목록</a>
            <c:if test="${authInfo.memberId eq BoardVO.id}">
               <a href="#" class="btn-form fr"
                  onclick="location.href='<c:url value='/community/CommunityList/delete/${BoardVO.bno}'/>'">삭제</a>
               <a href="#" class="btn-form2 fr"
                  onclick="location.href='<c:url value='/community/CommunityModify/update/${BoardVO.bno}'/>'">수정</a>
            </c:if>
         </div>
         </div>
         <!-- class="view-control-area" -->



      </div>

   </div>
   <jsp:include page="../Footer.jsp" />
   </div>
</body>
<script>
$('.DOC_TEXT').keyup(function (e){
    var content = $(this).val();
    $('#counter').html("("+content.length+" / 200자)");    //글자수 실시간 카운팅

    if (content.length > 200){
        alert("최대 200자까지 입력 가능합니다.");
        $(this).val(content.substring(0, 200));
        $('#counter').html("(200 / 최대 200자)");
    }
});
</script>
</html>