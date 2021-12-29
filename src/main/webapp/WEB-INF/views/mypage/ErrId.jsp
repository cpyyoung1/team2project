<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>임시 알림창</title>
</head>
<body>
	<script>
    alert('${notFoundId}');
    location.href='<c:out value="${pageContext.request.contextPath}"/>${errPage}';
</script>
</body>
</html>