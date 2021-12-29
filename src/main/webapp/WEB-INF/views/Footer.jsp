<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FOOTER</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
</head>
<script>
function confirm(){
	if(${authInfo==null}){
		alert('1:1 문의는 회원만 할 수 있습니다.');
	}else{
		location.href='<c:url value='/support/Counsel'/>';
	}
}
</script>
<body>
<div class="footer footerMain">


   <div class="footer-navi">
      <ul>
         <li><a href="<c:url value="/support/SupportMain"/>">공지사항</a></li>
				<li><a href="<c:url value="/support/Privacy"/>">개인정보처리방침</a></li>
				<li><a href="#" onclick="return confirm()">1:1문의</a></li>
				<li><a href="<c:url value="/support/SupportMain"/>">고객센터</a></li>
      </ul>
   </div>
   
   
        <div class="copyright">
         <strong>TEAM TWO</strong>
         <h2>Copyright © TEAM TWO Corp. All rights reserved.</h2>
      </div>

   
   
</div>
</body>
</html>