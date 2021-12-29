<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 등록</title>
    <link href="<c:url value="/resources/css/inputNotice.css"/>" rel='stylesheet' />
</head>
<body>
<jsp:include page="../Header.jsp"/>
    <div class="main">
        <form:form action="registerNotice">
            <div id="tbl">
               <div class="inputNotice">INPUT <strong>NOTICE</strong></div>
                <div class="box">
                    <div class="property">제 &nbsp;&nbsp;&nbsp;&nbsp; 목</div>
                    <div><input class="inputBox" type="text" name="title" id="quTitle"></div>
                </div>
                <div class="box">
                    <div class="property">공지내용</div>
                    <div><textarea class="inputBox" name="content" id="quContent"></textarea></div>
                </div>
                <div class="btns">
                    <div>
                        <input class="btn" type="reset" value="다시 작성">
                        <input class="btn" type="submit" value="등록">
                    </div>
                </div>
            </div>
        </form:form>
        <hr>
    </div>
    <jsp:include page="../Footer.jsp"/>
</body>
</html>