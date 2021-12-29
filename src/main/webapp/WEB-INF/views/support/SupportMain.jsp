<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SUPPORT</title>
<script type="text/javascript"
   src="<c:url value="/resources/js/HideToggle.js"/>"></script>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/support.css"/>"
   rel='stylesheet' />
<script>
function confirm(){
	if(${authInfo==null}){
		alert('1:1 문의는 회원만 할 수 있습니다.');
	}else{
		location.href='<c:url value='/support/Counsel'/>';
	}
}
</script>
</head>
<body>
   <jsp:include page="../Header.jsp" />
   <div class="container">
      <div class="support-header">
         <div class="header-title">
            <h2>SUPPORT</h2>
            <h3>고객센터</h3>
         </div>
      </div>
      <!-- class="support-header" -->
      <div class="support-navi clear">
         <div class="support-navi-area">
            <div class="navi-wrap">
               <div class="support-navi-menu" onclick="location.href='findInfo'">
                  <img src="<c:url value="/resources/img/SupportMain/user.png"/>">
                  <h3>ID/비밀번호 찾기</h3>
               </div>
               <div class="support-navi-menu" onclick="location.href='#faq'">
                  <img src="<c:url value="/resources/img/SupportMain/light_bulb.png"/>">
                  <h3>자주묻는 질문</h3>
               </div>
               <div class="support-navi-menu" onclick="return confirm()">
                  <!-- onclick="location.href='Counsel'" -->
                  <img src="<c:url value="/resources/img/SupportMain/speech_bubble.png"/>">
                  <h3>1:1 문의</h3>
               </div>
            </div>
         </div>
      </div>
      <div class="support-wrap">
         <div class="notice-area">
            <div class="notice-title">
               <h2>
                  NOTICE<span></span>
               </h2>
               <h3>공지사항</h3>
            </div>
            <div class="notice-list">
               <ul>
               <c:forEach var="noticeList" items="${noticeList}">
                      <li>
                        <div class="notice-content clear" onclick="menu_toggle(this)">
                           <c:if test="${authInfo.memberGrade==0}">
                              <button class="btn-form2 fr" onclick="location.href='<c:url value='/admin/deleteNotice/${noticeList.noticeNumber}'/>'">삭제</button>
                              <button class="btn-form2 fr mgr" onclick="location.href='<c:url value='/admin/modifyNoticeForm/${noticeList.noticeNumber}'/>'">수정</button>
                           </c:if>
                           <h3>${noticeList.noticeTitle}</h3>
                           <span>${noticeList.noticeDate}</span>
                        </div>
                        <div class="notice-content-inner hide">
                           <pre>${noticeList.noticeContent}</pre>
                        </div>
                    </li>
               </c:forEach>
               </ul>
            </div>
            <!-- class="notice-list" -->
         </div>
         <!-- class="notice-area" -->
         <div class="faq-area" id="faq">
            <div class="notice-title">
               <h2>
                  FAQ<span></span>
               </h2>
               <h3>자주 묻는 질문</h3>
            </div>
            <div class="faq-category">
               <div class="category-wrap" id="faqMenuParent">
               <c:forEach var="faqMenuList" items="${faqMenuList}">
                  <a class="category_list<c:if test="${faqMenuList.faqMenuNumber==1 }"> current</c:if>" onclick="openFaqMenu(event, ${faqMenuList.faqMenuNumber})">${faqMenuList.faqMenuTitle}</a>
               </c:forEach>
               </div>
            </div>
            <div class="notice-list">
               <ul id="faqParent">
                    <c:forEach var="faqList" items="${faqList}">
                  <li class="faq_cell ${faqList.faqMenuNumber}<c:if test="${faqList.faqMenuNumber!=1}"> hide</c:if>">
                     <div class="faq-content" onclick="menu_toggle(this)">
                     <c:if test="${authInfo.memberGrade==0}">
                        <button class="btn-form2 fr" onclick="location.href='<c:url value='/admin/deleteFaq/${faqList.faqNumber}'/>'">삭제</button>
                        <button class="btn-form2 fr mgr" onclick="location.href='<c:url value='/admin/modifyFaqForm/${faqList.faqNumber}'/>'">수정</button>
                     </c:if>
                        <h3>${faqList.faqTitle}</h3>
                     </div>
                     <div class="notice-content-inner hide">
                        <p>${faqList.faqContent}</p>
                     </div>
                  </li>
                  </c:forEach> <!-- forEach faqList -->
               </ul>
            </div>
            <!-- class="notice-list" -->
         </div>



      </div>
      <!-- class="support-wrap" -->
   </div>
   <!-- class="container" -->
   <jsp:include page="../Footer.jsp" />
</body>
</html>