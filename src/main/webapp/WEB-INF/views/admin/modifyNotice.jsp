<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
<link href="<c:url value="/resources/css/inputNotice.css"/>" rel='stylesheet' />
</head>
<body>
      <form:form action="modifyNotice">
            <div id="tbl">
               <input type="hidden" name="number" value="${nVO.noticeNumber}">
               <div class="inputNotice">MODIFY <strong>NOTICE</strong></div>
                <div class="box">
                    <div class="property">제 &nbsp;&nbsp;&nbsp;&nbsp; 목</div>
                    <div><input class="inputBox" type="text" name="title" id="quTitle" value="${nVO.noticeTitle}"></div>
                </div>
                <div class="box">
                    <div class="property">공지내용</div>
                    <div><textarea class="inputBox" name="content" id="quContent">${nVO.noticeContent}</textarea></div>
                </div>
                <div class="btns">
                    <div>
                        <input class="btn" type="reset" value="다시 작성">
                        <input class="btn" type="submit" value="등록">
                    </div>
                </div>
            </div>
        </form:form>
</body>
</html>