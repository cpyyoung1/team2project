<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HEADER</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
</head>
<body>
   <div
      style="background-position: center; padding-top: 0px; padding-right: 30px; padding-left: 30px;">
      <div id="top-header"><div id="title" onclick="location.href='${pageContext.request.contextPath}/main'">team two</div>
         
         
         <div class="sub-navi">
            <ul>
               <c:if test="${empty authInfo}">
                        <li class="login">
                            <a href="<c:url value='/login'/>">LOGIN</a>
                        </li>
                    </c:if>
                    <c:if test="${authInfo.memberGrade==1}">
                        <li class="login">              
                            <a href="<c:url value="/product/productRegistration"/>">SELL  &nbsp;</a>
                            <a href="<c:url value="/mypage/MypageMain"/>">MY PAGE  &nbsp;</a>
                            <a href="<c:url value='/logout'/>">LOGOUT</a>
                        </li>
                    </c:if>
                    <c:if test="${authInfo.memberGrade==0}">
                        <li class="login">              
                            <a href="<c:url value="/admin/adminpageMain"/>">ADMIN PAGE  &nbsp;</a>
                            <a href="<c:url value='/logout'/>">LOGOUT</a>
                        </li>
                    </c:if>
            </ul>
         </div>
         <div class="main-navi">
            <ul>
               <li><a href="<c:url value='/product/productMain'/>">SHOPPING</a>
                  <ul class="main-navi-sub">
                     <li>
                       <div class="inner-menu">
										<a href="<c:url value='/product/1'/>">sofa</a> <a
											href="<c:url value='/product/2'/>">bed</a> <a
											href="<c:url value='/product/3'/>">table</a> <a
											href="<c:url value='/product/4'/>">lighting</a> <a
											href="<c:url value='/product/5'/>">drawer</a> <a
											href="<c:url value='/product/6'/>">acc</a>
									</div>
                     </li>
                  </ul></li>
               <li><a href="<c:url value='/community/CommunityList'/>">BOARD</a>
                  <!--  <ul class="main-navi-sub">
                     <li>
                        <div class="inner-menu">
                           <a href="#">BBB</a>
                        </div>
                     </li>
                  </ul>-->
                  </li>
               <li><a href="<c:url value='/product/gallery'/>">GALLERY</a></li>
               <li><a href="<c:url value='/support/SupportMain'/>">SUPPORT</a></li>
            </ul>
         </div>
      </div>
   </div>
</body>
</html>