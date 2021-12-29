<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register"/></title>
<link href="<c:url value="/resources/css/style.css"/>" rel='stylesheet' />
<link href="<c:url value="/resources/css/etc.css"/>" rel='stylesheet' />
</head>
<body>
   <div class="container">
      <div class="info-box">
         <div class="info-box-upper">
            <spring:message code="register.done" arguments="${formData.memberName}"/>
         </div>
         <div class="info-box-bottom">
            <button class="btn-form4" onclick="location.href='<c:url value='/main'/>'"><spring:message code="go.main"/></button>
         </div>
      </div>
   </div>
</body>
</html>