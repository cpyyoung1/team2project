<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title"/></title>
</head>
<body>
	<form:form commandName="loginCommand">
	<form:errors />
	<p>
		<label><spring:message code="memberId"/>:<br>
			<form:input path="memberId"/>
			<form:errors path="memberId"/>
		</label>
	</p>
	<p>
		<label><spring:message code="password"/>:<br>
			<form:password path="memberPw"/>
			<form:errors path="memberPw"/>
		</label>
	</p>
	<p>
		<label><spring:message code="remembermemberId"/>:<br>
			<form:checkbox path="remembermemberId"/>
		</label>
	</p>
	<input type="submit" value="<spring:message code="login.btn"/>" />
	</form:form>
</body>
</html>



