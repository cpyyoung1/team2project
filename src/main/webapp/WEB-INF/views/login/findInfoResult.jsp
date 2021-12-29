<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FIND RESULT</title>
<link href="<c:url value="/resources/css/findId.css"/>" rel='stylesheet' />
</head>
<body>
   <div class="main">
   <c:if test="${!empty findIdResult}">
        <table>
                <tr>
                    <td id="title" colspan="2">find id</td>
                </tr>
                <tr class="box">
                    <td class="info">회원님의 정보와 일치하는 아이디 입니다.</td>
                </tr>
                <tr class="box">
                    <td>${findIdResult.memberId}</td>
                </tr>
                <tr>
                    <td colspan="2" class="btn"><input id="btn" type="button" value="메인으로" onclick="location.href='main'"></td>
                </tr>
        </table>
   </c:if>
   <c:if test="${!empty findPwResult}">
         <form:form action="modifyPw" commandName="modifyPass">
        <table>
                <tr>
                    <td id="title" colspan="2">find password
                    <input type="hidden" name="memberId" value="${findPwResult.memberId}"></td>
                </tr>
                <tr class="box">
                    <td><label for="currentPassword">현재 비밀번호</label></td>
                    <td><input class="form" type="password" name="currentPassword" id="currentPassword">
                    <span class="error"><form:errors path="currentPassword" /></span></td>
                </tr>
                <tr class="box">
                    <td><label for="newPassword">신규 비밀번호</label></td>
                    <td><input class="form" type="password" name="newPassword" id="newPassword">
                    <span class="error"><form:errors path="newPassword" /></span></td>
                </tr>
                <tr class="box">
                    <td><label for="confirmPassword">비밀번호 확인</label></td>
                    <td><input class="form" type="password" name="confirmPassword" id="confirmPassword">
                    <span class="error"><form:errors path="confirmPassword" /></span></td>
                </tr>
                <tr class="tText">
                    <td colspan="2">가입시 입력한 정보를 입력해주세요.
                    <span class="error"><form:errors /></span></td>
                </tr>
                <tr>
                    <td colspan="2" class="btn"><input id="btn" type="submit" value="확인" onclick="return checkFindPw()"></td>
                </tr>
        </table>
         </form:form>
   </c:if>
    </div>
</body>
</html>