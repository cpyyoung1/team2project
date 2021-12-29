<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1 문의</title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/counsel.css"/>" rel='stylesheet' />
 <script src='<c:url value="/resources/js/chkReciver.js"/>'></script>
</head>
<body>
<jsp:include page="../Header.jsp"/>

<div class="container">
	<div class="community-wrap">
		<h2>1:1 문의하기</h2>	
		<form action="toAdmin" method="POST">
		<div class="counsel-wrap">
			<div class="counsel-element">
				<strong>문의유형</strong>
				<div class="counsel-form">
					<select name="faqMenuNumber" class="select-box">
						<option value="1">회원 관련</option>
						<option value="2">기타</option>
						<option value="3">신고</option>
					</select>
				</div>
			</div>				<!-- class="counsel-element" -->
			<div class="counsel-element">
				<strong>문의제목</strong>
				<div class="counsel-form">
					<input type="text" class="textbox" name="faqTitle" id="faqTitle" placeholder="제목을 입력해 주세요">
				</div>
			</div>				<!-- class="counsel-element" -->
			<div class="counsel-element">
				<strong>문의내용</strong>
				<div class="counsel-form">
					<textarea class="textarea" name="faqContent" id="faqContent" placeholder="문의유형을 선택후 문의내용을 자세하게 작성해주세요"></textarea>
				</div>
			</div>				<!-- class="counsel-element" -->
				<!-- class="counsel-element" -->
		</div>				<!-- class="counsel-wrap" -->
		<div style="text-align: center; padding-top: 50px;">
			<input type="submit" class="btn-form3" value="문의접수" onclick="return checkBox()">
		</div>
		<input type=hidden name="qid" value="${authInfo.memberId }"> 
		
		
		</form>
		
		
	</div>				<!-- class="community-wrap" -->
</div>				<!-- class="container" -->
<jsp:include page="../Footer.jsp"/>
</body>
</html>