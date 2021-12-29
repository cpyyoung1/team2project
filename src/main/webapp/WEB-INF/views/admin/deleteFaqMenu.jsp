<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FAQ메뉴 삭제</title>
    <link href="<c:url value="/resources/css/inputNotice.css"/>" rel='stylesheet' />
</head>
<body>
<jsp:include page="../Header.jsp"/>
    <div class="main">
        <form:form action="deleteFaqMenu">
            <div id="tbl">
               <div class="inputNotice">INPUT <strong>FAQ</strong></div>
               <div class="box">
                    <div class="property">FAQ 메뉴삭제</div>
                    <div>
                  
                  <select name="faqMenuNumber">
                  <c:forEach var="faqMenuList" items="${faqMenuList}">
                     <c:if test="${faqMenuList.faqMenuNumber!=1 }">
                        <option value=${faqMenuList.faqMenuNumber}>${faqMenuList.faqMenuTitle}</option>
                     </c:if>
                  </c:forEach>
                  </select>
                    </div>
                </div>
                <div class="box">
                    <div><input class="inputBox" type="text" name="" id="quTitle" value="메뉴 삭제시 하위 항목은 모두 삭제됩니다." readonly></div>
                </div>
                <div class="btns">
                    <div>
                        <input class="btn" type="submit" value="완료">
                    </div>
                </div>
            </div>
        </form:form>
        <hr>
    </div>
    <jsp:include page="../Footer.jsp"/>
</body>
</html>