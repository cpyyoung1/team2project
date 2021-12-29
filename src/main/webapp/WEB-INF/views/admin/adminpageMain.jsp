<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/adminPageMain.css"/>" rel='stylesheet' />
</head>
<body>
   <jsp:include page="../Header.jsp" />
      <div class="mypage-wrap">
         <div class="mypage-header clear">
            <h2 class="fl">ADMIN PAGE</h2>
            <!-- <div class="mypage-modify fr">
               <button class="btn-form2"
                  onclick="location.href='<c:url value='#'/>'">-</button>
            </div> -->
         </div>
         <div class="mypage-area">
            <div class="info-area clear">
                  <div class="info-box fl">
                     <div class="info-halfbox mailbox">
                        <div class="info-tabl fl">
                           <img src="<c:url value="/resources/img/group.png"/>">
                        </div>
                        <div class="info-tabr fr"
                           onclick="location.href='<c:url value='/admin/viewAllMembers'/>'">
                           <h2>전체 회원 보기</h2>
                        </div>
                     </div>
                     <div class="info-halfbox"
                        onclick="location.href='<c:url value='/admin/inputNotice'/>'">
                        <div class="info-tabl fl">
                           <img src="<c:url value="/resources/img/notification.png"/>">
                        </div>
                        <div class="info-tabr fr">
                           <h2>공지사항 입력</h2>
                        </div>
                     </div>
                  </div>
                  <!-- class="info-box" -->
                  <div class="info-box fl">
                     <div class="info-halfbox mailbox">
                        <div class="info-tabl fl">
                           <img src="<c:url value="/resources/img/list.png"/>">
                        </div>
                        <div class="info-tabr fr"
                           onclick="location.href='<c:url value='/product/productMain'/>'">
                           <h2>상품 관리</h2>
                        </div>
                     </div>
                     <div class="info-halfbox" onclick="location.href='<c:url value='/admin/inputFaq'/>'">
                        <div class="info-tabl fl">
                           <img src="<c:url value="/resources/img/documents.png"/>">
                        </div>
                        <div class="info-tabr fr">
                           <h2>FAQ 등록</h2>
                        </div>
                     </div>
                  </div>
                  <!-- class="info-box" -->
                  <div class="info-box fl">
                     <div class="info-halfbox mailbox"
                        onclick="location.href='<c:url value='/support/QAList'/>'">
                        <div class="info-tabl fl">
                           <img src="<c:url value="/resources/img/speech.png"/>">
                        </div>
                        <div class="info-tabr fr">
                           <h2>문의 답변하기</h2>
                        </div>
                     </div>
                     <div class="info-halfbox"
                        onclick="location.href='<c:url value='/admin/inputFaqMenu'/>'">
                        <div class="info-tabl fl">
                           <img src="<c:url value="/resources/img/document_add.png"/>">
                        </div>
                        <div class="info-tabr fr">
                           <h2>FAQ메뉴 등록</h2>
                        </div>
                     </div>
                  </div>
                  <div class="info-box fl">
                     <div class="info-halfbox"
                        onclick="location.href='<c:url value='/admin/deleteFaqMenuForm'/>'">
                        <div class="info-tabl fl">
                           <img src="<c:url value="/resources/img/document_del.png"/>">
                        </div>
                        <div class="info-tabr fr">
                           <h2>FAQ메뉴 삭제</h2>
                        </div>
                     </div>
                  </div>
                  <div class="info-box fl">
                     <div class="info-halfbox"
                        onclick="location.href='<c:url value='/community/CommunityList'/>'">
                        <div class="info-tabl fl">
                           <img src="<c:url value="/resources/img/layers.png"/>">
                        </div>
                        <div class="info-tabr fr">
                           <h2>게시판글 확인</h2>
                        </div>
                     </div>
                  </div>
                  <div class="info-box fl">
                     <div class="info-halfbox"
                        onclick="location.href='<c:url value='/admin/viewAllOrders'/>'">
                        <div class="info-tabl fl">
                           <img src="<c:url value="/resources/img/zoom-in.png"/>">
                        </div>
                        <div class="info-tabr fr">
                           <h2>거래현황 확인</h2>
                        </div>
                     </div>
                  </div>
            </div>   <!-- class="info-area" -->
            </div>
         </div>
      </div>
      <jsp:include page="../Footer.jsp" />
</body>
</html>