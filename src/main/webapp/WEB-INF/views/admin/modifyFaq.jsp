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
        <form:form action="modifyFaq">
            <div id="tbl">
               <input type="hidden" name="faqNumber" value="${fVO.faqNumber}">
               <div class="inputNotice">MODIFY <strong>FAQ</strong></div>
               <div class="box">
                    <div class="property">FAQ 메뉴선택</div>
                    <div>
                  <select name="faqMenuNumber">
                     <c:forEach var="faqMenuList" items="${faqMenuList}">
                        <option value=${faqMenuList.faqMenuNumber}>${faqMenuList.faqMenuTitle}</option>
                      </c:forEach>
                  </select>
                    </div>
                </div>
                <div class="box">
                    <div class="property">제 &nbsp;&nbsp;&nbsp;&nbsp; 목</div>
                    <div><input class="inputBox" type="text" name="faqTitle" id="quTitle" value="${fVO.faqTitle}"></div>
                </div>
                <div class="box">
                    <div class="property">공지내용</div>
                    <div><textarea class="inputBox" name="faqContent" id="quContent">${fVO.faqContent}</textarea></div>
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